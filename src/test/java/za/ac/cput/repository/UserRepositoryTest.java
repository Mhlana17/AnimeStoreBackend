package za.ac.cput.repository;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class UserRepositoryTest {

    private static UserRepository repository = (UserRepository) UserRepository.getRepository();
    private static User user = UserFactory.createUser(
            "429536",
            "Phihlello",
            "phihlello.junaid@icloud.com"
    );

    @Test
    void a_create() {
        User created = repository.create(user);
        assertNotNull(created);
        assertEquals(user.getUserId(), created.getUserId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        User read = repository.read(user.getUserId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        User updatedUser = new User.Builder()
                .copy(user)
                .setUserName("PJ Maroga")
                .build();

        User updated = repository.update(updatedUser);
        assertNotNull(updated);
        assertEquals("PJ Maroga", updated.getUserName());
        System.out.println("Updated: " + updated);
    }

    @Test
    @Disabled
    void d_delete() {
        boolean success = repository.delete(user.getUserId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void e_getAll() {
        System.out.println(repository.getAll());
        assertFalse(repository.getAll().isEmpty());
    }
}
