package dvtagin.services;

import dvtagin.dao.UserDao;
import dvtagin.dao.UserDaoImp;
import dvtagin.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UserServiceImp implements UserService{

    private UserDao userDao;

    @Autowired
    public void setUserDao (UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public void removeUser(int id) {
        userDao.removeUser(id);
    }

    @Override
    public void updateUser(int id, User user) {
        userDao.updateUser(id, user);
    }
}
