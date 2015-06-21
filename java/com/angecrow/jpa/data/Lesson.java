/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angecrow.jpa.data;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author AngeCrow
 */
@Entity
public class Lesson implements Serializable {

    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;
    private String videoURL;
    @Column(length = 10000)
    private String teory;
    @ManyToOne
    private Study studys;
    @OneToOne
    private Test test;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public String getTeory() {
        return teory;
    }

    public void setTeory(String teory) {
        this.teory = teory;
    }

    public Study getStudys() {
        return studys;
    }

    public void setStudys(Study studys) {
        this.studys = studys;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

}
