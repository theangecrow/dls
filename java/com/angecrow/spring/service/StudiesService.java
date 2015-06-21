package com.angecrow.spring.service;

import com.angecrow.jpa.data.*;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by AngeCrow on 21.04.2015.
 */
@Component
public class StudiesService {
    @PersistenceContext
    private EntityManager em;
    @Transactional
    public List<Study> getStudies(Long id){
       DLUser user=em.find(DLUser.class,id);
        List<Study> studies = user.getGroup().getStudys();
        return studies;
    }

    @Transactional
    public Study CreateStudy(Study study){
        em.persist(study);
        return study;
    }

    @Transactional
    public List<Study> getAllStudyNoHaveTeacher()
    {
        String queryString = "SELECT a FROM Study a WHERE a.teacher is null";
        Query query=em.createQuery(queryString);
        List<Study> users=(List<Study>)query.getResultList();
        return users;
    }


    @Transactional
    public Study setTeacherOnStudy(DLUser user,Long idStudy)
    {
        Study study=em.find(Study.class, idStudy);
        study.setTeacher(user);
        user.addStudy(study);
        em.merge(user);
        return study;
    }

    @Transactional
    public Study delTeacherOfStudy(DLUser user,Long idStudy){
        Study study=em.find(Study.class,idStudy);
        study.setTeacher(null);
        user.delStudy(study);
        em.merge(user);
        return study;
    }
    @Transactional
    public List<Study> getAllStudies()
    {
        String queryString = "SELECT a FROM Study a";
        Query query=em.createQuery(queryString);
        List<Study> users=(List<Study>)query.getResultList();
        return users;
    }
    @Transactional
    public Study delStudyById(Long idStudy)
    {
        Study study=em.find(Study.class,idStudy);
        if(study.getTeacher()!=null)
            study.getTeacher().delStudy(study);

        if(study.getLessons()!=null) {
            List<Lesson> lessonList=study.getLessons();
            for (Lesson lesson : lessonList) {
                em.remove(lesson);
                if (lesson.getTest() != null) {
                    em.remove(lesson.getTest());
                    if (lesson.getTest().getQuestions() != null)
                        for (Question question : lesson.getTest().getQuestions()) {
                            em.remove(question);
                        }
                    if (lesson.getTest().getResult() != null)
                        for (UserTestResult userTestResult : lesson.getTest().getResult()) {
                            userTestResult.getdLUser().delResult(userTestResult);
                            em.remove(userTestResult);
                        }
                }
            }
        }

        if(study.getStudentsGroups()!=null)
            for(StudentsGroup studentsGroup:study.getStudentsGroups())
            {
                studentsGroup.delStudy(study);
            }
        em.remove(study);
        return study;
    }
    @Transactional
    public List<Study> getStudiesOutByGroupById(Long idGroup)
    {
        String queryString = "SELECT a FROM Study a";
        Query query=em.createQuery(queryString);
        List<Study> studies=(List<Study>)query.getResultList();
        Boolean flagToDelete = false;
        for(int i=0;i<studies.size();i++)
        {
            for(StudentsGroup studentsGroup:studies.get(i).getStudentsGroups())
            {
                if(studentsGroup.getId().equals(idGroup))
                {
                    flagToDelete=true;
                    break;
                }
                else flagToDelete=false;
            }
            if(flagToDelete)
            {
                studies.remove(i);
                i--;
            }
        }
        return studies;
    }
    @Transactional
    public Study addStudyInGroupById(Long idStudy,StudentsGroup studentsGroup)
    {
        Study study=em.find(Study.class, idStudy);
        studentsGroup.addStudy(study);
        study.addGroup(studentsGroup);
        em.merge(studentsGroup);
        return study;
    }
    @Transactional
    public Study delStudyOfGroupById(Long idStudy,StudentsGroup studentsGroup)
    {
        Study study=em.find(Study.class,idStudy);
        studentsGroup.delStudy(study);
        study.delStudentGroup(studentsGroup);
        em.merge(studentsGroup);
        return study;
    }

    @Transactional
    public List<Study> getStudyByIdTeacher(Long idTeacher)
    {
        DLUser teacher=em.find(DLUser.class,idTeacher);
        String queryString = "SELECT a FROM Study a WHERE a.teacher =:teacher";
        Query query=em.createQuery(queryString);
        query.setParameter("teacher",teacher);
        List<Study> studies=(List<Study>)query.getResultList();
        return studies;
    }

    @Transactional
    public Study getStudyById(Long idStudy)
    {
        Study study=em.find(Study.class,idStudy);
        return study;
    }
}
