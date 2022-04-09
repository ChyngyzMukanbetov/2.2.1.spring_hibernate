package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"), new Car("bmw", 323));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"), new Car("mers", 500));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"), new Car("audi", 100));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"), new Car("lada", 99));
      userService.add(new User("User5", "Lastname5", "user5@mail.ru"), new Car("bmw", 323));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("CarID = "+user.getCar().getId());
         System.out.println("CarModel = "+user.getCar().getModel());
         System.out.println("CarSeries = "+user.getCar().getSeries());
         System.out.println();
      }

      List<User> users1 = userService.getUserByCar("bmw", 323);
      for (User user : users1) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Nam = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Id = "+user.getCar().getId());
         System.out.println("CarModel = "+user.getCar().getModel());
         System.out.println("CarSeries = "+user.getCar().getSeries());
         System.out.println();
      }
      context.close();
   }


//      List<Car> cars = userService.getUserByCar("mers", 500);
//      for (Car car : cars) {
//         System.out.println("Id = "+car.getUser().getId());
//         System.out.println("First Name = "+car.getUser().getFirstName());
//         System.out.println("Last Nam = "+car.getUser().getLastName());
//         System.out.println("Email = "+car.getUser().getEmail());
//         System.out.println("Id = "+car.getId());
//         System.out.println("CarModel = "+car.getModel());
//         System.out.println("CarSeries = "+car.getSeries());
//         System.out.println();
//      }
//      context.close();
//   }
}
