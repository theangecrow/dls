package com.angecrow.spring.service;

import com.angecrow.jpa.data.*;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by AngeCrow on 12.05.2015.
 */
@Component
public class TestService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Test testCheck(Test test, Long id) {
        DLUser user = em.find(DLUser.class, id);
        int count = 0;
        int trueChoice = 0;
        for (Question question : test.getQuestions()) {
            if (question.getTrueAnswer() == Integer.parseInt(question.getUserAnswer())) {
                trueChoice++;
            }
            count++;
        }
        for (Question question : test.getQuestions())
            question.setUserAnswer("");

        int resultat = trueChoice * 100 / count;
        UserTestResult userTestResult = new UserTestResult();
        userTestResult.setdLUser(user);
        userTestResult.setResultat(resultat);
        Test PersistTest = em.find(Test.class, test.getId());
        PersistTest.addResult(userTestResult);
        user.addResult(userTestResult);
        userTestResult.setTest(PersistTest);
        em.persist(userTestResult);
        return PersistTest;
    }

    @Transactional
    public Test addTestToLesson(Test test, Lesson lesson) {
        lesson.setTest(test);
        test.setLesson(lesson);
        em.persist(test);
        em.merge(lesson);
        return test;
    }

    @Transactional
    public void renameTest(Test test) {
        em.merge(test);
    }

    @Transactional
    public Question addQuestionToTest(Question question, Test test) {
        question.setTest(test);
        em.persist(question);
        test.addQuestion(question);
        em.merge(test);


        return question;
    }

    @Transactional
    public Question getQuestionForId(Long idQuestion) {
        return em.find(Question.class, idQuestion);
    }

    @Transactional
    public Question editQuestion(Question question) {
        em.merge(question);
        return question;
    }

    @Transactional
    public Question delQuestionForId(Long idQuestion)
    {
        Question question=em.find(Question.class, idQuestion);
        question.getTest().delQuestion(question);
        em.remove(question);
        Test test=question.getTest();
        em.persist(test);
        return question;
    }

    @Transactional
    public void delTest(Test test)
    {
        test=em.merge(test);
        if(test.getQuestions()!=null) {
            List<Question> questionList = test.getQuestions();
            for(Question question: questionList)
            {
                em.remove(question);
            }
        }
        if(test.getResult()!=null)
        {
            for(UserTestResult result:test.getResult())
            {
                DLUser user=result.getdLUser();
                user.delResult(result);
                em.remove(result);
            }
        }
        test.getLesson().setTest(null);
        em.remove(test);
    }

    public Boolean allQuestionHaveUserAnswer(List<Question> questionList)
    {
        for(Question question:questionList)
        {
            if(question.getUserAnswer().equals(""))return false;
        }
        return true;
    }
}
