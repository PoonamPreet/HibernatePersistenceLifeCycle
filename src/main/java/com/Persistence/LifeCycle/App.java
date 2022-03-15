package com.Persistence.LifeCycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import javax.persistence.*;
import com.Persistence.LifeCycle.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Configuration config = new Configuration().configure().addAnnotatedClass(Laptop.class);

		ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();

		SessionFactory sessionFactory=config.buildSessionFactory(reg);

		Session session =sessionFactory.openSession();

		session.beginTransaction();
		
		
		
		//Laptop l=new Laptop();
		
//For inserting//		l.setLid(52);
//		l.setBrand("Lenova");
//		l.setPrice(8000);
		//session.detach(l);//need to see how to use as methos r not available
		//session.remove(l);//need to see how to use as methos r not available
		//for retrieving
		//Laptop lap=(Laptop)session.get(Laptop.class, 51);//This will give the object
		
		Laptop lap=(Laptop) session.load(Laptop.class,51);//This will give the proxy of the object
		System.out.println(lap);
		
		//session.save(l);
		
	//	l.setPrice(9500);
		 
		
		
		
		session.getTransaction().commit();
		
		
		
		
    }
}
