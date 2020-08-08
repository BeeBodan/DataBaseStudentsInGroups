package com.bogdan.dao;

import com.bogdan.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentsGroupsDao {

    private static Session session;

    public List listStudentsByGroups(String group_name) {
        List studentsList = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            transaction.commit();
            studentsList = session
                    .createSQLQuery("SELECT s.student_name FROM crud.students as s JOIN crud.students_groups as sg on s.student_id = sg.student_id " +
                            "JOIN crud.groups as g on sg.group_id = g.group_id where lower(g.group_name) = lower(:group_name);")
                    .setParameter("group_name", group_name)
                    .getResultList();
            if (studentsList != null) {
                System.out.println(">>> Student(s) in the group '" + group_name + "': ");
                for (Object s : studentsList) {
                    System.out.println(s);
                }
            }
        } catch(Exception sqlException) {
            if(session.getTransaction() != null) {
                System.out.println("\nTransaction is being rolled back\n");
                session.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return studentsList;
    }

    public List listGroupsByStudents(String student_name) {
        List groupsList = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            transaction.commit();
            groupsList = session
                    .createSQLQuery("SELECT g.group_name FROM crud.groups as g JOIN crud.students_groups as sg on g.group_id = sg.group_id " +
                            "JOIN crud.students as s on sg.student_id = s.student_id where lower(s.student_name) = lower(:student_name);")
                    .setParameter("student_name", student_name)
                    .getResultList();
            if (groupsList != null) {
                System.out.println(">>> Student - " + student_name + ", in the group(s): ");
                for (Object s : groupsList) {
                    System.out.println(s);
                }
            }
        } catch(Exception sqlException) {
            if(session.getTransaction() != null) {
                System.out.println("\nTransaction is being rolled back\n");
                session.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return groupsList;
    }
}
