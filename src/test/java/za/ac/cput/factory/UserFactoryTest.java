package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.User;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {

    @Test
    void createUser() {
        User user = UserFactory.createUser("219354359","Phihlello","phihle15.com@gmail.com");
        assertNotNull(user);
        System.out.print(user);
    }
}