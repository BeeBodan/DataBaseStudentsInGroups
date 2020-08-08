# Many-To-Many Relationship in JPA

The program implements the Many-To-Many Relationship useng JPA. **A relationship is a connection between two types of entities. In case of a many-to-many relationship, both sides can relate to multiple instances of the other side.**

### Task

M:M Relationship

Create several groups add several students to each group and write to the database. Make a request to the database and display:

- 1.List of students by group name (in any case) 
- 2.List of groups by student name (in any case)

### Tech

* Postgresql;
* Hibernate;
* SQL.

### Result

**1.** The first step is to create three tables (students, groups, students_groups) using the SQL command [Script](https://github.com/bbogdasha/postgresqlManyToMany/blob/master/Script.sql):

```sql
CREATE TABLE students (
  student_id int GENERATED BY DEFAULT AS IDENTITY,
  student_name varchar (45) NOT NULL,
  student_age int NOT NULL,
  PRIMARY KEY (student_id)
); 
 
CREATE TABLE groups (
  group_id int GENERATED BY DEFAULT AS IDENTITY,
  group_name varchar (45) NOT NULL,
  PRIMARY KEY (group_id)
);
 
CREATE TABLE students_groups (
  student_id int,
  group_id int,
  PRIMARY KEY (student_id, group_id),
  CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES students (student_id),
  CONSTRAINT fk_group FOREIGN KEY (group_id) REFERENCES groups (group_id)
);
```
===========================

**2.** Next step groups, students are created and the belonging of each student to different groups is indicated.

Result in database:
- Groups
![Screenshot](https://github.com/bbogdasha/postgresqlManyToMany/blob/master/screenshots/Screenshot_1.jpg)
- Students
![Screenshot](https://github.com/bbogdasha/postgresqlManyToMany/blob/master/screenshots/Screenshot_2.jpg)
- Student_Groups
![Screenshot](https://github.com/bbogdasha/postgresqlManyToMany/blob/master/screenshots/Screenshot_3.jpg)
===========================

**3.** Using SQL queries, you can get data from a database, a list of students from a specific group, or a list of groups that have a student with a specific name.

Result: 

![Screenshot](https://github.com/bbogdasha/postgresqlManyToMany/blob/master/screenshots/Screenshot_4.jpg)

