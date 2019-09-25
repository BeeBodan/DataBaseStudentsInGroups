package com.bogdan;

import org.hibernate.Session;

public class Main {

    public static void main(String[] args) {

        //Connect with DB
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        //Create groups
        Group group1 = new Group("Java");
        Group group2 = new Group("C++");
        Group group3 = new Group("C#");
        Group group4 = new Group("JS");
        Group group5 = new Group("PHP");

        //Create students
        Students students1 = new Students("Den", 24);
        Students students2 = new Students("Mary", 27);
        Students students3 = new Students("Bob", 35);
        Students students4 = new Students("Carl", 28);
        Students students5 = new Students("Viki", 21);
        Students students6 = new Students("Alex", 26);
        Students students7 = new Students("Monty", 32);
        Students students8 = new Students("Gran", 41);
        Students students9 = new Students("Ben", 35);
        Students students10 = new Students("Alisa", 33);

        //Add students to groups
        group1.addStudent(students1);
        group1.addStudent(students4);
        group1.addStudent(students5);
        group1.addStudent(students9);
        group1.addStudent(students10);

        group2.addStudent(students3);
        group2.addStudent(students6);
        group2.addStudent(students9);

        group3.addStudent(students1);
        group3.addStudent(students2);
        group3.addStudent(students9);

        group4.addStudent(students4);
        group4.addStudent(students7);
        group4.addStudent(students8);
        group4.addStudent(students9);

        group5.addStudent(students5);
        group5.addStudent(students9);

        students1.addGroup(group1);
        students1.addGroup(group3);
        students2.addGroup(group3);
        students3.addGroup(group2);
        students4.addGroup(group1);
        students4.addGroup(group4);
        students5.addGroup(group1);
        students5.addGroup(group5);
        students6.addGroup(group2);
        students7.addGroup(group4);
        students8.addGroup(group4);
        students9.addGroup(group1);
        students9.addGroup(group2);
        students9.addGroup(group3);
        students9.addGroup(group4);
        students9.addGroup(group5);
        students10.addGroup(group1);

        session.save(group1);
        session.save(group2);
        session.save(group3);
        session.save(group4);
        session.save(group5);

        //Close
        session.getTransaction().commit();
        session.close();
    }
}
