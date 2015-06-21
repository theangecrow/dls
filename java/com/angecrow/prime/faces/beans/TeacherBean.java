package com.angecrow.prime.faces.beans;

import com.angecrow.jpa.data.Lesson;
import com.angecrow.jpa.data.Question;
import com.angecrow.jpa.data.Study;
import com.angecrow.jpa.data.Test;
import com.angecrow.spring.service.LessonService;
import com.angecrow.spring.service.StudiesService;
import com.angecrow.spring.service.TestService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import java.util.List;


@ManagedBean
@SessionScoped
public class TeacherBean {
    List<Study> studyList;
    List<Lesson> lessonList;

    Boolean flagChoiceStudy = false;
    Boolean flagAddNewLesson = false;
    Boolean flagEditLesson = false;
    Boolean flagTest = false;
    Boolean flagQuestion = false;
    Boolean flagRenameTest=false;
    Boolean flagEditQuestion=false;

    String studyChoiceId;
    Study studyChoice;

    String nameLesson;
    String urlLesson;
    String teoryLesson;
    String nameTest;

    Lesson editLesson;

    Test editTest;

    String editQuestion;
    String editAnswer1;
    String editAnswer2;
    String editAnswer3;
    String editAnswer4;
    String editAnswer5;
    String editTrueAnswer;
    List<Question> questionList;
    String editQuestionId;

    Question questionForEdit;

    @ManagedProperty("#{studiesService}")
    StudiesService studiesService;

    @ManagedProperty("#{lessonService}")
    LessonService lessonService;

    @ManagedProperty("#{testService}")
    TestService testService;

    public Question getQuestionForEdit() {
        return questionForEdit;
    }

    public void setQuestionForEdit(Question questionForEdit) {
        this.questionForEdit = questionForEdit;
    }

    public String getEditQuestionId() {
        return editQuestionId;
    }

    public void setEditQuestionId(String editQuestionId) {
        this.editQuestionId = editQuestionId;
    }

    public Boolean getFlagEditQuestion() {
        return flagEditQuestion;
    }

    public void setFlagEditQuestion(Boolean flagEditQuestion) {
        this.flagEditQuestion = flagEditQuestion;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public String getEditQuestion() {
        return editQuestion;
    }

    public void setEditQuestion(String editQuestion) {
        this.editQuestion = editQuestion;
    }

    public String getEditAnswer1() {
        return editAnswer1;
    }

    public void setEditAnswer1(String editAnswer1) {
        this.editAnswer1 = editAnswer1;
    }

    public String getEditAnswer2() {
        return editAnswer2;
    }

    public void setEditAnswer2(String editAnswer2) {
        this.editAnswer2 = editAnswer2;
    }

    public String getEditAnswer3() {
        return editAnswer3;
    }

    public void setEditAnswer3(String editAnswer3) {
        this.editAnswer3 = editAnswer3;
    }

    public String getEditAnswer4() {
        return editAnswer4;
    }

    public void setEditAnswer4(String editAnswer4) {
        this.editAnswer4 = editAnswer4;
    }

    public String getEditAnswer5() {
        return editAnswer5;
    }

    public void setEditAnswer5(String editAnswer5) {
        this.editAnswer5 = editAnswer5;
    }

    public String getEditTrueAnswer() {
        return editTrueAnswer;
    }

    public void setEditTrueAnswer(String editTrueAnswer) {
        this.editTrueAnswer = editTrueAnswer;
    }

    public Boolean getFlagRenameTest() {
        return flagRenameTest;
    }

    public void setFlagRenameTest(Boolean flagRenameTest) {
        this.flagRenameTest = flagRenameTest;
    }

    public Boolean getFlagQuestion() {
        return flagQuestion;
    }

    public void setFlagQuestion(Boolean flagQuestion) {
        this.flagQuestion = flagQuestion;
    }

    public Test getEditTest() {
        return editTest;
    }

    public void setEditTest(Test editTest) {
        this.editTest = editTest;
    }

    public TestService getTestService() {
        return testService;
    }

    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    public String getNameTest() {
        return nameTest;
    }

    public void setNameTest(String nameTest) {
        this.nameTest = nameTest;
    }

    public Boolean getFlagTest() {
        return flagTest;
    }

    public void setFlagTest(Boolean flagTest) {
        this.flagTest = flagTest;
    }

    public Lesson getEditLesson() {
        return editLesson;
    }

    public void setEditLesson(Lesson editLesson) {
        this.editLesson = editLesson;
    }

    public LessonService getLessonService() {
        return lessonService;
    }

    public void setLessonService(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    public String getNameLesson() {
        return nameLesson;
    }

    public void setNameLesson(String nameLesson) {
        this.nameLesson = nameLesson;
    }

    public String getUrlLesson() {
        return urlLesson;
    }

    public void setUrlLesson(String urlLesson) {
        this.urlLesson = urlLesson;
    }

    public String getTeoryLesson() {
        return teoryLesson;
    }

    public void setTeoryLesson(String teoryLesson) {
        this.teoryLesson = teoryLesson;
    }

    public Boolean getFlagAddNewLesson() {
        return flagAddNewLesson;
    }

    public void setFlagAddNewLesson(Boolean flagAddNewLesson) {
        this.flagAddNewLesson = flagAddNewLesson;
    }

    public Boolean getFlagEditLesson() {
        return flagEditLesson;
    }

    public void setFlagEditLesson(Boolean flagEditLesson) {
        this.flagEditLesson = flagEditLesson;
    }

    public Boolean getFlagChoiceStudy() {
        return flagChoiceStudy;
    }

    public void setFlagChoiceStudy(Boolean flagChoiceStudy) {
        flagChoiceStudy = flagChoiceStudy;
    }

    public List<Study> getStudyList() {
        return studyList;
    }

    public void setStudyList(List<Study> studyList) {
        this.studyList = studyList;
    }

    public String getStudyChoiceId() {
        return studyChoiceId;
    }

    public void setStudyChoiceId(String studyChoiceId) {
        this.studyChoiceId = studyChoiceId;
    }

    public List<Lesson> getLessonList() {
        return lessonList;
    }

    public void setLessonList(List<Lesson> lessonList) {
        this.lessonList = lessonList;
    }

    public Study getStudyChoice() {
        return studyChoice;
    }

    public void setStudyChoice(Study studyChoice) {
        this.studyChoice = studyChoice;
    }

    public StudiesService getStudiesService() {
        return studiesService;
    }

    public void setStudiesService(StudiesService studiesService) {
        this.studiesService = studiesService;
    }

    public void startTeacherPage(ValueChangeEvent event) {
        String value=event.getNewValue().toString();
        if(!value.equals("false")&&!(flagAddNewLesson|| flagEditLesson)&&!(flagTest||flagQuestion||flagRenameTest)) {
            studyChoiceId = event.getNewValue().toString();
            studyChoice = studiesService.getStudyById(Long.parseLong(studyChoiceId));
            lessonList = studyChoice.getLessons();
            flagAddNewLesson = false;
            flagChoiceStudy = true;
        }
    }

    public void startEditLesson(ValueChangeEvent event) {
        String value=event.getNewValue().toString();
        if(!value.equals("false")&&!(flagAddNewLesson)&&!(flagTest||flagQuestion||flagRenameTest)){
            editLesson = lessonService.getLessonById(Long.parseLong(event.getNewValue().toString()));
            this.nameLesson = editLesson.getName();
            this.urlLesson = editLesson.getVideoURL();
            this.teoryLesson = editLesson.getTeory();
            flagEditLesson = true;
            flagAddNewLesson=false;
        }

    }

    public String addNewLesson() {
        this.flagAddNewLesson = true;
        this.flagEditLesson =false;
        this.nameLesson="";
        this.urlLesson="";
        this.teoryLesson="";
        return "";
    }

    public String doNotAddNewLesson()
    {
        flagAddNewLesson=false;
        return "";
    }

    private void chengeNameLesson() {
        for (Lesson lesson : lessonList) {
            if (lesson.getId().equals(this.editLesson.getId())) {
                lesson.setName(this.nameLesson);
            }
        }
    }


    public String saveLesson() {
        if (flagAddNewLesson&&!(nameLesson.equals("")||teoryLesson.equals("")||urlLesson.equals(""))) {
            Lesson lesson = new Lesson();
            lesson.setName(this.nameLesson);
            lesson.setVideoURL(this.urlLesson);
            lesson.setTeory(this.teoryLesson);
            lessonService.setLessonByStudy(lesson, studyChoice);
            flagAddNewLesson = false;
        }
        if (flagEditLesson) {
            editLesson.setName(this.nameLesson);
            editLesson.setVideoURL(this.urlLesson);
            editLesson.setTeory(this.teoryLesson);
            lessonService.mergeLesson(editLesson);
            chengeNameLesson();
            flagEditLesson = false;
        }
        return "";
    }

    public String addTest() {
        if(!nameTest.equals(""))
        {
            Test test = new Test();
            test.setName(nameTest);
            editTest = testService.addTestToLesson(test, editLesson);
            questionList=editTest.getQuestions();
            flagTest = false;
            flagQuestion = true;
        }
        return "";
    }
    public String stopTest()
    {
        flagTest=false;
        flagEditLesson=true;
        return "";
    }
    public String startTest() {
        if (editLesson.getTest() == null) {
            flagTest = true;
            flagEditLesson = false;
        }
        else {
            editTest=editLesson.getTest();
            questionList=editTest.getQuestions();
            nameTest=editTest.getName();
            flagEditLesson=false;
            flagTest=false;
            flagQuestion=true;
        }
        return "";
    }
    public String startRenameTest()
    {
        flagQuestion=false;
        flagRenameTest=true;
        return "";
    }
    public String renameTest() {
        if (!nameTest.equals(""))
        {
            editTest.setName(nameTest);
            flagQuestion=true;
            flagRenameTest=false;
            testService.renameTest(editTest);
        }
        return "";
    }



    public String addNewQuestion() {
        if (!editQuestion.equals("") && !editAnswer1.equals("") && !editAnswer2.equals("") && !editAnswer3.equals("") && !editAnswer4.equals("") && !editAnswer5.equals("") && !editTrueAnswer.equals("")) {
            Question question = new Question();
            question.setQuestion(this.editQuestion);
            question.setA1(this.editAnswer1);
            question.setA2(this.editAnswer2);
            question.setA3(this.editAnswer3);
            question.setA4(this.editAnswer4);
            question.setA5(this.editAnswer5);
            question.setTrueAnswer(Integer.parseInt(this.editTrueAnswer));
            testService.addQuestionToTest(question, editTest);
            editQuestion = "";
            editAnswer1 = "";
            editAnswer2 = "";
            editAnswer3 = "";
            editAnswer4 = "";
            editAnswer5 = "";
            editTrueAnswer = "";
        }
        return "";
    }

    public String startEditQuestion()
    {
        questionForEdit=testService.getQuestionForId(Long.parseLong(this.editQuestionId));
        this.editQuestion=questionForEdit.getQuestion();
        this.editAnswer1=questionForEdit.getA1();
        this.editAnswer2=questionForEdit.getA2();
        this.editAnswer3=questionForEdit.getA3();
        this.editAnswer4=questionForEdit.getA4();
        this.editAnswer5=questionForEdit.getA5();
        this.editTrueAnswer=Integer.toString(questionForEdit.getTrueAnswer());
        flagEditQuestion=true;
        return "";
    }
    public void reNameQuestion(Question question)
    {
        for(Question question1:questionList)
        {
            if(question.getId().equals(question1.getId()))
            {
                question1.setQuestion(question.getQuestion());
            }
        }
    }
    public String goEditQuestion()
    {
        if (!editQuestion.equals("") && !editAnswer1.equals("") && !editAnswer2.equals("") && !editAnswer3.equals("") && !editAnswer4.equals("") && !editAnswer5.equals("") && !editTrueAnswer.equals("")) {
            questionForEdit.setQuestion(this.editQuestion);
            questionForEdit.setA1(this.editAnswer1);
            questionForEdit.setA2(this.editAnswer2);
            questionForEdit.setA3(this.editAnswer3);
            questionForEdit.setA4(this.editAnswer4);
            questionForEdit.setA5(this.editAnswer5);
            questionForEdit.setTrueAnswer(Integer.parseInt(this.editTrueAnswer));
            reNameQuestion(testService.editQuestion(questionForEdit));
            editQuestion = "";
            editAnswer1 = "";
            editAnswer2 = "";
            editAnswer3 = "";
            editAnswer4 = "";
            editAnswer5 = "";
            editTrueAnswer = "";
            flagEditQuestion=false;
        }
        return "";
    }

    private  void delDelQuestion(Question question) {
        for (Question question1 : questionList)
        {
            if(question.getId().equals(question1.getId()))
            {
                questionList.remove(question1);
                break;
            }
        }
    }

    public String delQuestion()
    {
        delDelQuestion(testService.delQuestionForId(Long.parseLong(editQuestionId)));
        return "";
    }

    public String deleteTest()
    {
        testService.delTest(editTest);
        editLesson.setTest(null);
        editTest=null;
        flagQuestion=false;
        flagTest=true;
        nameTest="";

        return "";
    }

    public String stopEditTest()
    {
        flagQuestion=false;
        flagTest=false;
        flagEditLesson=true;
        return "";
    }

}
