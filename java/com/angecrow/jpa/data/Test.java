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
public class Test implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;
    @OneToOne(mappedBy = "test")
    private Lesson lesson;
    @OneToMany(mappedBy = "test")
    private List<UserTestResult> result;
    @OneToMany(mappedBy = "test")
    private List<Question> questions;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserTestResult> getResult() {
        return result;
    }

    public void setResult(List<UserTestResult> result) {
        this.result = result;
    }

    public void addResult(UserTestResult resultat){ this.result.add(resultat);}

    public List<Question> getQuestions() {
        return questions;
    }

    public void addQuestion(Question question){this.questions.add(question);}

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void delQuestion(Question question){this.questions.remove(question);}

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Boolean allQuestionHaveUserAnswer()
    {
        for(Question question:questions)
        {
            if(question.getUserAnswer().equals(""))return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Test)) {
            return false;
        }
        Test other = (Test) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Test[ id=" + id + " ]";
    }
    
}
