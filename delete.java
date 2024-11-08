//deleting the  the data using delete()
package com.hib.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.qn.Entity.address;
import com.qn.Entity.student;


public class delete {
    public static void main( String[] args )
    {
    	 SessionFactory factory = new Configuration()
                 .configure()
                 .addAnnotatedClass(student.class)
                 .addAnnotatedClass(address.class)
                 .buildSessionFactory();

         Session session = factory.openSession();
        session.beginTransaction();
address as=session.get(address.class,3);
session.delete(as);

                session.getTransaction().commit();
        
    }
}
