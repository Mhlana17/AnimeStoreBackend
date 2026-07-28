//Author: Phihlello Junaid Maroga 219354359
package za.ac.cput.repository;

import za.ac.cput.domain.User;

import java.util.List;

public interface IUserRepository  extends IRepository <User,String> {
    List<User> getAll() ;
}
