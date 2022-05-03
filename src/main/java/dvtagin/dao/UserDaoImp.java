package dvtagin.dao;

import dvtagin.models.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager manager;

    public EntityManager getManager () {
        return this.manager;
    }


    @Override
    public List<User> getAllUsers() {
        return getManager().createQuery("SELECT u from User u", User.class).getResultList();
    }

    @Override
    public User getUserById(int id) {
        return getManager().find(User.class, id);
    }

    @Override
    public void addUser(User user) {
        getManager().persist(user);
    }

    @Override
    public void removeUser(int id) {
        getManager().remove(getUserById(id));
    }

    @Override
    public void updateUser(int id, User user) {
        getManager().merge(user);
    }
}
