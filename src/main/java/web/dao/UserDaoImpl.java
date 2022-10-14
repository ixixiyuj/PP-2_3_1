package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository

public class UserDaoImpl implements UserDao{
    @PersistenceContext
    private final EntityManager entityManager;
    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);

    }
    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return entityManager.createQuery("FROM User").getResultList();
    }

    @Override
    public User getUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void saveUser(String name, String lastName, String email) {
        this.add(new User(name, lastName, email));
    }

    @Override
    public void removeUserById(long id) {
        entityManager.remove(entityManager.find(User.class, id));

    }

    @Override
    public void updateUser(long id, String name, String lastName, String email) {
        User user = entityManager.find(User.class, id);
        user.setFirstName(name);
        user.setLastName(lastName);
        user.setEmail(email);
    }



}
