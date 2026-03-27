package za.ac.cput.repository;

import za.ac.cput.domain.User;

import java.awt.desktop.UserSessionListener;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private static IUserRepository repository = null;
            private List<User> userList;

    private UserRepository (){
        userList = new ArrayList<>();


    }

    public static IUserRepository getRepository(){
        if ( repository == null){
            repository = new UserRepository();
        }
        return repository;
    }

    @Override
    public User create(User user) {
        boolean success = userList.add(user);
        if (success){
            return  user;
        }
        return  null;
    }

    @Override
    public User read(String userId) {
        for(User user : userList){
            if(user.getUserId().equals(userId)){
                return user;
            }
        }
        return null;
    }

    @Override
    public User update(User user) {
        String id = user.getUserId();
        User oldUser =  read(id);
        if (oldUser == null){
            return null ;
        }
        boolean success = userList.remove(oldUser);
        if (!success) {
            return null ;
        }
        if (userList.add(user)){
            return user ;
        }
        return null ;
    }

    @Override
    public boolean delete(String id) {
        User userToDelete = read(id);
        if (userToDelete == null) {
            return false;
        }
        return (userList.remove(userToDelete));
    }

    @Override
    public List<User> getAll() {
        return userList;
    }
}
