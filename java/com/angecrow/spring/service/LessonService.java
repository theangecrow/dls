package com.angecrow.spring.service;

import com.angecrow.jpa.data.Lesson;
import com.angecrow.jpa.data.Study;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by AngeCrow on 24.04.2015.
 */
@Component
public class LessonService {
    @PersistenceContext
    private EntityManager em;
    @Transactional
    public Lesson getLessonById(Long idLesson){
        return em.find(Lesson.class,idLesson);
    }

    @Transactional
    public Lesson setLessonByStudy(Lesson lesson,Study study)
    {
        em.persist(lesson);
        study.addLesson(lesson);
        lesson.setStudys(study);
        em.merge(study);

        return lesson;
    }
    @Transactional
    public void mergeLesson(Lesson lesson)
    {
        em.merge(lesson);
    }
}
