package com.angecrow.prime.faces.beans;

import com.angecrow.jpa.data.DLUser;
import com.angecrow.jpa.data.StudentsGroup;
import com.angecrow.jpa.data.Study;
import com.angecrow.spring.service.GroupService;
import com.angecrow.spring.service.StudiesService;
import com.angecrow.spring.service.UserService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean
@SessionScoped
public class AdminStudyBean {

    @ManagedProperty("#{userService}")
    UserService userService;

    @ManagedProperty("#{studiesService}")
    StudiesService studiesService;

    @ManagedProperty("#{groupService}")
    GroupService groupService;

    List<Study> studies;

    List<DLUser> teachers;

    String delStudyChoice;

    List<Study> teacherStudies;
    List<Study> noHaveTeacherStudyes;
    String nameCreateStudy;
    String TeacherId;
    String groupId;
    DLUser teacherStudy;
    Boolean flagTeacherStudyEdit;
    Boolean flagGroupStudyEdit;

    String teacherStudyChoice;
    String noHaveTeacherStudyChoice;
    List<StudentsGroup> studentsGroups;


    List<Study> studiesInGroup;
    List<Study> studiesOutOfGroup;
    StudentsGroup studentsGroup;


    String studyGroupChoice;
    String studyOutGroupChoice;

    public String getStudyGroupChoice() {
        return studyGroupChoice;
    }

    public void setStudyGroupChoice(String studyGroupChoice) {
        this.studyGroupChoice = studyGroupChoice;
    }

    public String getStudyOutGroupChoice() {
        return studyOutGroupChoice;
    }

    public void setStudyOutGroupChoice(String studyOutGroupChoice) {
        this.studyOutGroupChoice = studyOutGroupChoice;
    }

    public StudentsGroup getStudentsGroup() {
        return studentsGroup;
    }

    public void setStudentsGroup(StudentsGroup studentsGroup) {
        this.studentsGroup = studentsGroup;
    }

    public List<Study> getStudiesInGroup() {
        return studiesInGroup;
    }

    public void setStudiesInGroup(List<Study> studiesInGroup) {
        this.studiesInGroup = studiesInGroup;
    }

    public List<Study> getStudiesOutOfGroup() {
        return studiesOutOfGroup;
    }

    public void setStudiesOutOfGroup(List<Study> studiesOutOfGroup) {
        this.studiesOutOfGroup = studiesOutOfGroup;
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

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getDelStudyChoice() {
        return delStudyChoice;
    }

    public void setDelStudyChoice(String delStudyChoice) {
        this.delStudyChoice = delStudyChoice;
    }

    public List<Study> getNoHaveTeacherStudyes() {
        return noHaveTeacherStudyes;
    }

    public void setNoHaveTeacherStudyes(List<Study> noHaveTeacherStudyes) {
        this.noHaveTeacherStudyes = noHaveTeacherStudyes;
    }

    public String getNoHaveTeacherStudyChoice() {
        return noHaveTeacherStudyChoice;
    }

    public void setNoHaveTeacherStudyChoice(String noHaveTeacherStudyChoice) {
        this.noHaveTeacherStudyChoice = noHaveTeacherStudyChoice;
    }

    public String getTeacherStudyChoice() {
        return teacherStudyChoice;
    }

    public void setTeacherStudyChoice(String teacherStudyChoice) {
        this.teacherStudyChoice = teacherStudyChoice;
    }

    public List<Study> getTeacherStudies() {
        return teacherStudies;
    }

    public void setTeacherStudies(List<Study> teacherStudies) {
        this.teacherStudies = teacherStudies;
    }

    public DLUser getTeacherStudy() {
        return teacherStudy;
    }

    public void setTeacherStudy(DLUser teacherStudy) {
        this.teacherStudy = teacherStudy;
    }

    public Boolean getFlagGroupStudyEdit() {
        return flagGroupStudyEdit;
    }

    public void setFlagGroupStudyEdit(Boolean flagGroupStudyEdit) {
        this.flagGroupStudyEdit = flagGroupStudyEdit;
    }

    public Boolean getFlagTeacherStudyEdit() {
        return flagTeacherStudyEdit;
    }

    public void setFlagTeacherStudyEdit(Boolean flagTeacherStudyEdit) {
        this.flagTeacherStudyEdit = flagTeacherStudyEdit;
    }

    public String getTeacherId() {
        return TeacherId;
    }

    public void setTeacherId(String teacherId) {
        TeacherId = teacherId;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public List<Study> getStudies() {
        return studies;
    }

    public void setStudies(List<Study> studies) {
        this.studies = studies;
    }

    public List<DLUser> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<DLUser> teachers) {
        this.teachers = teachers;
    }

    public StudiesService getStudiesService() {
        return studiesService;
    }

    public void setStudiesService(StudiesService studiesService) {
        this.studiesService = studiesService;
    }

    public String getNameCreateStudy() {
        return nameCreateStudy;
    }

    public void setNameCreateStudy(String nameCreateStudy) {
        this.nameCreateStudy = nameCreateStudy;
    }



    public String ChreateStudy(){
        if(!this.nameCreateStudy.equals("")) {
            Study study=new Study();
            study.setName(nameCreateStudy);
            studies.add(studiesService.CreateStudy(study));
            this.nameCreateStudy = "";
        }
            return "";
    }
    public String AllTeacherGet(){
        teachers=userService.getAllTeacher();
        studies=studiesService.getAllStudies();
        flagGroupStudyEdit=false;
        flagTeacherStudyEdit=false;
        studentsGroups=groupService.getAllGroups();
        return "admin/study";
    }
    public String AllTeacherGet1(){
        teachers=userService.getAllTeacher();
        studies=studiesService.getAllStudies();
        flagGroupStudyEdit=false;
        flagTeacherStudyEdit=false;
        studentsGroups=groupService.getAllGroups();
        return "study";
    }

    public String startEditTeacherStudies(){
        flagTeacherStudyEdit=true;
        this.teacherStudy=userService.getUserById(Long.parseLong(this.TeacherId));
        this.teacherStudies =this.teacherStudy.getStudies();
        this.noHaveTeacherStudyes=studiesService.getAllStudyNoHaveTeacher();
        return "";
    }


    public void addStudyTeacher(Study study) {
        for (Study study1 : this.noHaveTeacherStudyes)
        {
            if(study.getId().equals(study1.getId()))
            {
                this.noHaveTeacherStudyes.remove(study1);
                break;
            }
        }
    }

    public void delStudyTeacher(Study study){
        for(Study study1: this.teacherStudies)
        {
            if(study.getId().equals(study1.getId()))
            {
                this.teacherStudies.remove(study1);
                break;
            }
        }
        this.noHaveTeacherStudyes.add(study);
    }

    public String addStudyToTeacher(){
        if(!this.noHaveTeacherStudyChoice.equals(""))
            addStudyTeacher(studiesService.setTeacherOnStudy(teacherStudy, Long.parseLong(this.noHaveTeacherStudyChoice)));
        return "";
    }

    public String delStudyToTeacher(){
        if(!this.teacherStudyChoice.equals(""))
            this.delStudyTeacher(studiesService.delTeacherOfStudy(teacherStudy, Long.parseLong(this.teacherStudyChoice)));
        return "";
    }

    public String endOfEditTeacherStudies(){
        flagTeacherStudyEdit=false;
        return "";
    }

    public void delStudyInBean(Study study){
        for(Study study1:studies)
        {
            if(study.getId().equals(study1.getId()))
            {
                studies.remove(study1);
                break;
            }
        }
    }
    public String deleteStudy(){
        if(!this.delStudyChoice.equals(""))
            delStudyInBean(studiesService.delStudyById(Long.parseLong(this.delStudyChoice)));
        return "";
    }

    public String startEditGroupStudies(){
        flagGroupStudyEdit=true;
        this.studiesOutOfGroup=this.studiesService.getStudiesOutByGroupById(Long.parseLong(this.groupId));
        this.studentsGroup=this.groupService.getGroupById(Long.parseLong(groupId));
        this.studiesInGroup=this.studentsGroup.getStudys();
        return "";
    }


    public void addStudyGroup(Study study)
    {
        for(Study study1:studiesOutOfGroup)
            if(study.getId().equals(study1.getId()))
            {
                studiesOutOfGroup.remove(study1);
                break;
            }
    }
    public void delStudyGroup(Study study)
    {
        this.studiesOutOfGroup.add(study);
    }

    public String addStudyToGroup()
    {
        if (!studyOutGroupChoice.equals(""))
        this.addStudyGroup(studiesService.addStudyInGroupById(Long.parseLong(this.studyOutGroupChoice), this.studentsGroup));
        return "";
    }
    public String delStrudyOfGroup()
    {
        if(!studyGroupChoice.equals(""))
        this.delStudyGroup(studiesService.delStudyOfGroupById(Long.parseLong(this.studyGroupChoice), this.studentsGroup));
        return "";
    }
    public String endEditGroupStudies()
    {
        flagGroupStudyEdit=false;
        return "";
    }

}
