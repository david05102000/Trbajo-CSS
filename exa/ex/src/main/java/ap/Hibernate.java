package ap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class Hibernate {
    public static void persisDatos(List datos){
        StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        SessionFactory sf = new MetadataSources((sr).buildMetadata().buildSessionFactory();
        Session sesion = sf.openSession();
        sesion.beginTransaction();
        datos.forEach(d ->{
            sesion.persist(d);
        });
        sesion.getTransaction().commit();
        sesion.close();
        sf.close();
    }
}
