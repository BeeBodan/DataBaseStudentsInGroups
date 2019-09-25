package com.bogdan;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "GROUPS")
public class Group {

    private long id;
    private String groupName;

    private Set<Students> students = new HashSet<Students>();

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public void addStudent(Students students) {
        this.students.add(students);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    public long getId() {
        return id;
    }

    @Column(name = "group_name")
    public String getGroupName() {
        return groupName;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "students_groups",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    public Set<Students> getStudents() {
        return students;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setStudents(Set<Students> students) {
        this.students = students;
    }
}