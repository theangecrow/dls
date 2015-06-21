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
public class StudentsGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "group")
    private List<DLUser> dLUsers;
    @ManyToMany
    private List<Study> studys;

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

    public List<DLUser> getdLUsers() {
        return dLUsers;
    }

    public void setdLUsers(List<DLUser> dLUsers) {
        this.dLUsers = dLUsers;
    }

    public void addStudy(Study study){this.studys.add(study);}
    public void delStudy(Study study){
        for(Study study1:studys){
            if(study.getId().equals(study1.getId()))
            {
                studys.remove(study1);
                break;
            }
        }
    }
    public List<Study> getStudys() {
        return studys;
    }

    public void setStudys(List<Study> studys) {
        this.studys = studys;
    }

    public void addDLUser(DLUser user) {
        this.dLUsers.add(user);
    }

    public void deleteDLUser(DLUser user)
    {
        this.dLUsers.remove(user);
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
        if (!(object instanceof StudentsGroup)) {
            return false;
        }
        StudentsGroup other = (StudentsGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.StudentGroup[ id=" + id + " ]";
    }
    
}
