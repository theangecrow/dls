package com.angecrow.prime.faces.beans;

import com.angecrow.jpa.data.Lesson;
import com.angecrow.jpa.data.Test;
import com.angecrow.jpa.data.UserTestResult;
import com.angecrow.spring.service.LessonService;
import com.angecrow.spring.service.TestService;

import javax.faces.bean.*;
import javax.faces.event.ActionEvent;


@ManagedBean
@SessionScoped
public class LessonBean {
    Long id;
    String URLVideo;
    String teoryLesson;
    Test TEST;
    @ManagedProperty("#{testService}")
    TestService testService;

    @ManagedProperty("#{lessonService}")
    LessonService lessonService;

    @ManagedProperty("#{userLogin}")
    UserLogin userLogin;

    public String getTeoryLesson() {
        return teoryLesson;
    }

    public void setTeoryLesson(String teoryLesson) {
        this.teoryLesson = teoryLesson;
    }

    public void IdLesson(ActionEvent event)
    {
        id=Long.parseLong(event.getComponent().getClientId());
    }
    public UserLogin getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    public TestService getTestService() {
        return testService;
    }

    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    public LessonService getLessonService() {
        return lessonService;
    }

    public void setLessonService(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    public LessonBean() {
        this.URLVideo = "";
        teoryLesson = "";
        this.TEST = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getURLVideo() {
        return URLVideo;
    }

    public void setURLVideo(String URLVideo) {
        this.URLVideo = URLVideo;
    }



    public Test getTEST() {
        return TEST;
    }

    public void setTEST(Test TEST) {
        this.TEST = TEST;
    }

    public String lessonChoice(Long id){
        this.id=id;
        Lesson lesson=lessonService.getLessonById(id);
        URLVideo=lesson.getVideoURL();
        teoryLesson=lesson.getTeory();
        TEST=lesson.getTest();
        return null;
    }

    public String getResultations()
    {
        if(TEST!=null)
        {
            if(TEST.allQuestionHaveUserAnswer())
            {
                TEST=testService.testCheck(TEST, userLogin.getId());
                String Resultats="";
                for(UserTestResult result:TEST.getResult())
                {
                    Resultats+=result.getResultat();
                    Resultats+=",";
                }
                return Resultats;
            }
        }
        return "U don't Choice All Answer";
    }
}
