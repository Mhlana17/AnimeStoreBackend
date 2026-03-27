//Author: Phihlello Junaid Maroga 219354359
package za.ac.cput.repository;

import za.ac.cput.domain.User;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {

    private static UserRepository repository = null;
    private List<User> userList;

    private UserRepository() {
        userList = new ArrayList<>();
    }

    public static UserRepository getRepository() {
        if (repository == null) {
            repository = new UserRepository();
        }
        return repository;
    }

    @Override
    public User create(User user) {
        userList.add(user);
        return user;
    }

    @Override
    public User read(String userId) {
        for (User user : userList) {
            if (user.getUserId().equals(userId)) {
                return null;
            }
        }
        return null;
    }

    @Override
    public User update(User user) {
        User oldUser = read(user.getUserId());
        if (oldUser == null) {
            return null;
        }
        userList.remove(oldUser);
        userList.add(user);
        return user;
    }

    @Override
    public boolean delete(String id) {
        User userToDelete = read(id);
        if (userToDelete == null) {
            return false;
        }
        return userList.remove(userToDelete);
    }

    @Override
    public List<User> getAll() {
        return userList;
    }
}