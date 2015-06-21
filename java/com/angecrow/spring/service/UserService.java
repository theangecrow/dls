package com.angecrow.spring.service;

        import com.angecrow.jpa.data.DLUser;
        import com.angecrow.jpa.data.RoleUser;
        import com.angecrow.jpa.data.StudentsGroup;
        import com.angecrow.jpa.data.Study;
        import org.springframework.stereotype.Component;

        import javax.persistence.EntityManager;
        import javax.persistence.PersistenceContext;
        import javax.persistence.Query;

        import org.springframework.transaction.annotation.Transactional;

        import java.util.List;


@Component
public class UserService
{
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void registerStudent(DLUser user) {
//        user.setGroup(em.find(StudentsGroup.class, new Long(1)));
        em.persist(user);
    }
    @Transactional
    public void register(DLUser user){
        em.persist(user);
    }
    @Transactional
    public DLUser login(String userName,String password){

        String queryString = "SELECT user FROM DLUser user " +
                "WHERE user.userName = '"+userName+"'";
        Query query = em.createQuery(queryString);
        DLUser user=null;
        List<DLUser> listuser = (List<DLUser>) query.getResultList();
        if(listuser.size()==0)return null;
        user=listuser.get(0);
        if(user.getPassword().equals(password))
            return user;
        return null;
    }

    @Transactional
    public List<DLUser> getAllTeacher()
    {
        String queryString = "SELECT a FROM DLUser a WHERE a.roleUser = :roleUser";
        Query query=em.createQuery(queryString);
        query.setParameter("roleUser", RoleUser.ROLE_TEACHER);
        List<DLUser> users=(List<DLUser>)query.getResultList();
        return users;
    }
    public DLUser getUserById(Long idUser)
    {
        return em.find(DLUser.class,idUser);
    }
}
