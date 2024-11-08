package com.hib.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.qn.Entity.address;
import com.qn.Entity.student;

public class reterive {
    public static void main(String[] args) {
        // Set up Hibernate session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(student.class)
                .addAnnotatedClass(address.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            // Retrieve student by ID
            int studentId = 1;  // Example student ID
            student retrievedStudent = session.get(student.class, studentId);

            // Print the student and their address
            System.out.println("Retrieved Student: " + retrievedStudent);
            System.out.println("Address: " + retrievedStudent.getAddress());

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
