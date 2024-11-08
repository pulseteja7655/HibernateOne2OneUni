package com.hib.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.qn.Entity.student;
import com.qn.Entity.address;

public class insert {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(student.class)
                .addAnnotatedClass(address.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            // Begin transaction
            session.beginTransaction();

            // Create an address object
            address addr = new address("123 Main St", "Ballari", "KA");

            // Create a student object and associate the address
            student s = new student("Arthi", "Basapur", "aru123@gmail.com.com");
            s.setAddress(addr);  // Set the address for the student

            // Save the student (and address due to CascadeType.ALL)
            session.save(s);

            // Commit the transaction
            session.getTransaction().commit();

            System.out.println("Student saved successfully!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
