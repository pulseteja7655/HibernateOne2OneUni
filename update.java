//updating the data using set()and update()
package com.hib.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.qn.Entity.address;
import com.qn.Entity.student;

public class update {
    public static void main( String[] args )
    {
    	SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(student.class)
                .addAnnotatedClass(address.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();
        
        session.beginTransaction();
student s=(student)session.get(student.class,1);
s.setLast_name("B");
session.update(s);

        
        session.getTransaction().commit();
        
    }
}
