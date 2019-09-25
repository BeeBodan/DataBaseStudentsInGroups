package com.bogdan;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "students")
public class Students {

    private long id;
    private String studentName;
    private int age;
    private Set<Group> groups = new HashSet<Group>();

    public Students(String studentName, int age) {
        this.studentName = studentName;
        this.age = age;
    }

    public void addGroup(Group group) {
        this.groups.add(group);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    public long getId() {
        return id;
    }

    @Column(name = "student_name")
    public String getStudentName() {
        return studentName;
    }

    @ManyToMany(mappedBy = "students")
    public Set<Group> getGroups() {
        return groups;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }
}