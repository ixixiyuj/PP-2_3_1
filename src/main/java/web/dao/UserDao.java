package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void saveUser(String name, String lastName, String email);
    void removeUserById(long id);
    void updateUser(long id, String name, String lastName, String email);
    void add(User user);
    List<User> listUsers();

    User getUser(long id);


}
