package com.bogdan.dao;

import com.bogdan.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class StudentsGroupsDao {

    public List listStudentsByGroups(String group_name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session
                .createSQLQuery("SELECT s.student_name FROM students as s JOIN students_groups as sg on s.student_id = sg.student_id " +
                        "JOIN groups as g on sg.group_id = g.group_id where lower(g.group_name) = lower(:group_name);")
                .setParameter("group_name", group_name)
                .getResultList();
    }

    public List listGroupsByStudents(String student_name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session
                .createSQLQuery("SELECT g.group_name FROM groups as g JOIN students_groups as sg on g.group_id = sg.group_id " +
                        "JOIN students as s on sg.student_id = s.student_id where lower(s.student_name) = lower(:student_name);")
                .setParameter("student_name", student_name)
                .getResultList();
    }
}
