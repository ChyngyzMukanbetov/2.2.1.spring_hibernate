package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.addAll;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public void add(User user, Car car) {
      sessionFactory.getCurrentSession().save(car);
      sessionFactory.getCurrentSession().save(user);


   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> getUserByCar(String model, int series) {
      List<User> usersByCar = new ArrayList<>();
      TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("from Car where model = :model and series = :series").setParameter("model", model).setParameter("series", series);
      List<Car> cars = query.getResultList();
      if (!cars.isEmpty()) {
         for (Car car : cars) {
            TypedQuery<User> userQuery = sessionFactory.getCurrentSession().createQuery("from User where car = :car").setParameter("car", car);
            usersByCar.addAll(userQuery.getResultList());
         }
         return usersByCar;
      }
      return null;
   }

}