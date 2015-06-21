/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angecrow.jpa.data;

import java.io.Serializable;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.persistence.*;

/**
 *
 * @author AngeCrow
 */


@Entity
public class DLUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @Column(unique = true)
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private RoleUser roleUser;
    @ManyToOne
    private StudentsGroup group;
    @OneToMany(mappedBy = "dLUser")
    private List<UserTestResult> result;

    @OneToMany(mappedBy = "teacher")
    private List<Study> studies;

    public List<Study> getStudies() {
        return studies;
    }

    public void setStudies(List<Study> studies) {
        this.studies = studies;
    }
    public void addStudy(Study study){this.studies.add(study);}
    public void delStudy(Study study){
        for (Study study1:studies)
        {
            if(study.getId().equals(study1.getId()))
            {
                studies.remove(study1);
                break;
            }
        }

    }
    public RoleUser getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(RoleUser roleUser) {
        this.roleUser = roleUser;
    }

    public DLUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String email) {
        this.userName = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public StudentsGroup getGroup() {
        return group;
    }

    public void setGroup(StudentsGroup group) {
        this.group = group;
    }
    public void addResult(UserTestResult userTestResult){
        result.add(userTestResult);
    }
    public void delResult(UserTestResult userTestResult){result.remove(userTestResult);}
    public List<UserTestResult> getResult() {
        return result;
    }

    public void setResult(List<UserTestResult> result) {
        this.result = result;
    }

}

