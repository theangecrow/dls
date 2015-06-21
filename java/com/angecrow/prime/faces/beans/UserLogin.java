package com.angecrow.prime.faces.beans;

import com.angecrow.jpa.data.DLUser;
import com.angecrow.jpa.data.RoleUser;
import com.angecrow.jpa.data.Study;
import com.angecrow.spring.service.StudiesService;
import com.angecrow.spring.service.UserService;
import org.springframework.jmx.export.annotation.ManagedAttribute;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 * Created by AngeCrow on 21.04.2015.
 */
@ManagedBean
@SessionScoped
public class UserLogin {
    Long id;
    Long idGroup;
    String userName;
    String password;
    List<Study> studies;
    RoleUser roleUser;

    @ManagedProperty("#{studiesService}")
    StudiesService studiesService;

    @ManagedProperty("#{userService}")
    private UserService userService;

    List<Study> teacherStudyList;

    public List<Study> getTeacherStudyList() {
        return teacherStudyList;
    }

    public void setTeacherStudyList(List<Study> teacherStudyList) {
        this.teacherStudyList = teacherStudyList;
    }

    public RoleUser getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(RoleUser roleUser) {
        this.roleUser = roleUser;
    }

    public Long getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Long idGroup) {
        this.idGroup = idGroup;
    }

    public StudiesService getStudiesService() {
        return studiesService;
    }

    public void setStudiesService(StudiesService studiesService) {
        this.studiesService = studiesService;
    }

    public List<Study> getStudies() {
        return studies;
    }

    public void setStudies(List<Study> studies) {
        this.studies = studies;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login(){
        DLUser user=userService.login(userName, password);
        if(user.equals(null)){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Неверный UserName или Password"));
            return "";
        }
        switch(user.getRoleUser())
        {
            case ROLE_STUDENT:
                id=user.getId();
                if(user.getGroup()!=null){
                idGroup=user.getGroup().getId();
                studies = studiesService.getStudies(id);}
                return "index";
            case ROLE_ADMIN:
                id=user.getId();
                roleUser=RoleUser.ROLE_ADMIN;
                return "admin";
            case ROLE_TEACHER:
                roleUser=RoleUser.ROLE_TEACHER;
                teacherStudyList=studiesService.getStudyByIdTeacher(user.getId());
                return "teacher";
        }
        return "";
    }
    public String logout()
    {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login?faces-redirect=true";
    }
}
