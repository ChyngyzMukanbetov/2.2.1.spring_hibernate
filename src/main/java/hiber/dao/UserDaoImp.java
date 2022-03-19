package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

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
   public List<Car> getUserByCar(String model, int series) {
      TypedQuery<Car> query=sessionFactory.getCurrentSession().createQuery("from Car where model = :model and series = :series").setParameter("model", model).setParameter("series", series);
      return query.getResultList();
   }
}