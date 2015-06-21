package com.angecrow.prime.faces.beans;

import com.angecrow.jpa.data.DLUser;
import com.angecrow.jpa.data.StudentsGroup;
import com.angecrow.spring.service.GroupService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 * Created by AngeCrow on 18.05.2015.
 */
@ManagedBean
@SessionScoped
public class AdminStudentBean {

    List<StudentsGroup> studentsGroups;

    @ManagedProperty("#{groupService}")
    GroupService groupService;
    String newGroupName;
    String groupChoice;
    String editGroupName;
    List<DLUser> usersInGroup;
    List<DLUser> usersOutOfGroup;
    Boolean flagEdit;

    String idStrudentInGroup;
    String idStudentOutOfGroup;

    StudentsGroup editGroup;

    public StudentsGroup getEditGroup() {
        return editGroup;
    }

    public void setEditGroup(StudentsGroup editGroup) {
        this.editGroup = editGroup;
    }

    public String getEditGroupName() {
        return editGroupName;
    }

    public void setEditGroupName(String editGroupName) {
        this.editGroupName = editGroupName;
    }

    public String getIdStrudentInGroup() {
        return idStrudentInGroup;
    }

    public void setIdStrudentInGroup(String idStrudentInGroup) {
        this.idStrudentInGroup = idStrudentInGroup;
    }

    public String getIdStudentOutOfGroup() {
        return idStudentOutOfGroup;
    }

    public void setIdStudentOutOfGroup(String idStudentOutOfGroup) {
        this.idStudentOutOfGroup = idStudentOutOfGroup;
    }

    public Boolean getFlagEdit() {
        return flagEdit;
    }

    public void setFlagEdit(Boolean flagEdit) {
        this.flagEdit = flagEdit;
    }

    public List<DLUser> getUsersOutOfGroup() {
        return usersOutOfGroup;
    }

    public void setUsersOutOfGroup(List<DLUser> usersOutOfGroup) {
        this.usersOutOfGroup = usersOutOfGroup;
    }

    public List<DLUser> getUsersInGroup() {
        return usersInGroup;
    }

    public void setUsersInGroup(List<DLUser> usersInGroup) {
        this.usersInGroup = usersInGroup;
    }

    public void addUserOutOfGroup(DLUser user)
    {

        this.usersOutOfGroup.add(user);
        for(DLUser DLuser:usersInGroup)
        {
            if(DLuser.getId().equals(user.getId())) {
                this.usersInGroup.remove(DLuser);
                break;
            }
        }
    }

    public void addUserInGroup(DLUser user)
    {
        this.usersInGroup.add(user);
        for(DLUser DLuser:usersOutOfGroup)
        {
            if(DLuser.getId().equals(user.getId()))
            {
                this.usersOutOfGroup.remove(DLuser);
                break;
            }
        }
    }
    public String getNewGroupName() {
        return newGroupName;
    }

    public void setNewGroupName(String newGroupName) {
        this.newGroupName = newGroupName;
    }

    public String getGroupChoice() {
        return groupChoice;
    }

    public void setGroupChoice(String groupChoice) {
        this.groupChoice = groupChoice;
    }

    public GroupService getGroupService() {
        return groupService;
    }

    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

    public List<StudentsGroup> getStudentsGroups() {
        return studentsGroups;
    }

    public void setStudentsGroups(List<StudentsGroup> studentsGroups) {
        this.studentsGroups = studentsGroups;
    }

    public String addAllGroups(){
        studentsGroups=groupService.getAllGroups();
        flagEdit=false;

        return "admin/student";
    }
    public String addAllGroups1(){
        studentsGroups=groupService.getAllGroups();
        flagEdit=false;

        return "student";
    }

    public String createStudentGroup()
    {
        if(!newGroupName.equals(""))
        {
            StudentsGroup newStudentGroup=new StudentsGroup();
            newStudentGroup.setName(newGroupName);
            newStudentGroup=groupService.addNewStudentGroup(newStudentGroup);
            studentsGroups.add(newStudentGroup);
            newGroupName="";
        }
        return "";
    }
    public String deleteStudentGroup()
    {
        if(!groupChoice.equals("")) {
            Long idDeleteGroup = Long.parseLong(groupChoice);
            int count = 0;
            for (StudentsGroup group : studentsGroups)
                if (group.getId().equals(idDeleteGroup)) {
                    studentsGroups.remove(group);
                    break;
                }
            groupService.deleteStudentGroup(idDeleteGroup);
        }
        return "";
    }
    public String startEditGroup()
    {
        for(StudentsGroup group:studentsGroups)
        {
            if(group.getId()==Long.parseLong(groupChoice))
                editGroup=group;
        }
        editGroupName=editGroup.getName();
        flagEdit=true;
        usersInGroup=groupService.getUsersInGroup(Long.parseLong(groupChoice));
        usersOutOfGroup=groupService.allUsersOutOfGroup();
        return "";

    }

    public String addUserToGroup()
    {
        if(!idStudentOutOfGroup.equals(""))
            this.addUserInGroup(groupService.addStudentOnGroup(Long.parseLong(idStudentOutOfGroup),editGroup));
        return "";
    }

    public String deleteUserOfGroup()
    {
        if(!idStrudentInGroup.equals(""))
            this.addUserOutOfGroup(groupService.deleteUserOfGroup(Long.parseLong(idStrudentInGroup), editGroup));
        return "";
    }

    public String saveNewNameGroup()
    {
        flagEdit=false;
        editGroup.setName(this.editGroupName);
        groupService.editNameGroup(editGroup);
        editGroup=null;
        return "";
    }
}
