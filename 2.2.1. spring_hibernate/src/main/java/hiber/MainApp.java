package hiber;

import hiber.config.AppConfig;


import hiber.model.User;
import hiber.service.UserService;
import org.hibernate.Session;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {

//      UserService userService = context.getBean(UserService.class);
//
//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
////      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
////      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
//
//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }
//
//      context.close();

//      ******************************************
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      Session session = null;
      try {
         HibernateTransactionManager transactionManager =
                 context.getBean("getTransactionManager", HibernateTransactionManager.class);
         session = transactionManager.getSessionFactory().openSession();
         session.beginTransaction();

         User user = session.get(User.class, 1L);

         session.getTransaction().commit();
         System.out.println(user);

      } finally {
         session.close();
         context.close();
      }

//       ***************************
//      Session session = null;
//
//      try {
//         HibernateTransactionManager transactionManager =
//                 context.getBean("getTransactionManager", HibernateTransactionManager.class);
//         session = transactionManager.getSessionFactory().openSession();
//
//
//         UserService userService = context.getBean(UserService.class);
//
//
//         Car bmw = new Car("BMW", 3);
//         User user = new User("User1", "Lastname1", "user1@mail.ru");
//         user.setUserCar(bmw);
//         userService.add(user);
//
//         session.beginTransaction();
//         session.save(user);
//         session.getTransaction().commit();
//
//
//         session.beginTransaction();
//         User user1 = session.get(User.class, 1);
//         session.getTransaction().commit();
//         System.out.println(user1);
//
//      } finally {
//         session.close();
//         context.close();
//      }

   }
}
