/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angecrow.jpa.data;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author AngeCrow
 */
@Entity
public class Study implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String Name;

    @ManyToOne
    private DLUser teacher;

    @ManyToMany(mappedBy = "studys")
    private List<StudentsGroup> studentsGroups;


    @OneToMany(mappedBy = "studys")
    private List<Lesson> lessons;

    public DLUser getTeacher() {
        return teacher;
    }

    public void setTeacher(DLUser teacher) {
        this.teacher = teacher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void addGroup(StudentsGroup studentsGroup){this.studentsGroups.add(studentsGroup);}

    public List<StudentsGroup> getStudentsGroups() {
        return studentsGroups;
    }

    public void setStudentsGroups(List<StudentsGroup> studentsGroups) {
        this.studentsGroups = studentsGroups;
    }

    public void delStudentGroup(StudentsGroup studentsGroup)
    {
        studentsGroups.remove(studentsGroup);
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public void addLesson(Lesson lesson){this.lessons.add(lesson);}
}
