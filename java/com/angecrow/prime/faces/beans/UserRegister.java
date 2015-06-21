package com.angecrow.prime.faces.beans;

import com.angecrow.jpa.data.DLUser;
import com.angecrow.jpa.data.RoleUser;
import com.angecrow.spring.service.UserService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 * Created by AngeCrow on 20.04.2015.
 */
@ManagedBean

public class UserRegister {
    String userName;
    String password;
    String firstName;
    String lastName;

    RoleUser roleUser;
    DLUser user;

    String  idRole;

    public UserRegister(){user = new DLUser();}

    @ManagedProperty("#{userService}")
    private UserService userService;


    public String getIdRole() {
        return idRole;
    }

    public void setIdRole(String idRole) {
        this.idRole = idRole;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
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

    public RoleUser getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(RoleUser roleUser) {
        this.roleUser = roleUser;
    }

    private String registerStudent(){
        user.setUserName(userName);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setRoleUser(RoleUser.ROLE_STUDENT);
        user.setStudies(null);
        userService.register(user);
        return "login";
    }
    private String registerTeacher(){
        user.setUserName(userName);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setRoleUser(RoleUser.ROLE_TEACHER);
        userService.register(user);
        return "login";
    }
    private String registerAdmin(){
        user.setUserName(userName);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setRoleUser(RoleUser.ROLE_ADMIN);
        userService.register(user);
        return "login";
    }

    public String register(){
        if (idRole.equals("1")) {
            return registerAdmin();
        } else if (idRole.equals("2")) {
            return registerStudent();
        } else if (idRole.equals("3")) {
            return registerTeacher();
        }

      return "login";

    }
}
