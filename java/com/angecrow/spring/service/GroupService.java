package com.angecrow.spring.service;

import com.angecrow.jpa.data.DLUser;
import com.angecrow.jpa.data.RoleUser;
import com.angecrow.jpa.data.StudentsGroup;
import com.angecrow.jpa.data.Study;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by AngeCrow on 18.05.2015.
 */
@Component
public class GroupService {
    @PersistenceContext
    private EntityManager em;
    @Transactional
    public List<StudentsGroup> getAllGroups()
    {
        String queryString = "SELECT a FROM StudentsGroup a";
        Query query = em.createQuery(queryString);

        return (List<StudentsGroup>)query.getResultList();
    }
    @Transactional
    public StudentsGroup addNewStudentGroup(StudentsGroup studentsGroup)
    {
        em.persist(studentsGroup);
        return studentsGroup;
    }
    @Transactional
    public void deleteStudentGroup(Long idGroup)
    {
        StudentsGroup studentsGroup=em.find(StudentsGroup.class, idGroup);
        for(DLUser user:studentsGroup.getdLUsers())
            user.setGroup(null);

        em.remove(studentsGroup);
    }
    @Transactional
    public List<DLUser> allUsersOutOfGroup()
    {
        String queryString = "SELECT a FROM DLUser a WHERE a.group IS NULL and a.roleUser = :roleUser";
        Query query=em.createQuery(queryString);
        query.setParameter("roleUser",RoleUser.ROLE_STUDENT);
        List<DLUser> users=(List<DLUser>)query.getResultList();
        return users;
    }
    public  List<DLUser> getUsersInGroup(long IdGroup){
        return em.find(StudentsGroup.class,IdGroup).getdLUsers();
    }

    @Transactional
    public DLUser addStudentOnGroup(Long id,StudentsGroup studentsGroup){
        DLUser user=em.find(DLUser.class,id);
        user.setGroup(studentsGroup);
        studentsGroup.addDLUser(user);
        em.merge(studentsGroup);
        return user;
    }

    @Transactional
    public DLUser deleteUserOfGroup(Long id,StudentsGroup studentsGroup){
        DLUser user=em.find(DLUser.class,id);
        user.setGroup(null);
        studentsGroup.deleteDLUser(user);
        em.remove(studentsGroup);
        return user;
    }

    @Transactional
    public void editNameGroup(StudentsGroup studentsGroup)
    {
        em.merge(studentsGroup);
    }

    @Transactional
    public StudentsGroup getGroupById(Long idGroup){
        return em.find(StudentsGroup.class,idGroup);
    }


}
