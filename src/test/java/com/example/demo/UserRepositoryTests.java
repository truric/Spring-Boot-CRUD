package com.example.demo;

import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {
    @Autowired private UserRepository repo;

    @Test
    public void testAddNew() {
        User user = new User();
        user.setFirstName("Ricardo");
        user.setLastName("Parada");
        user.setEmail("email@email.com");
//        user.setFirstName("Daniela");
//        user.setLastName("Seixas");
//        user.setEmail("dani@email.com");
        user.setPassword("password");

        User savedUser = repo.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll() {
        Iterable<User> users = repo.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);

        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testUpdate() {
        Long userId = Long.valueOf(1);
        Optional<User> optionalUser = repo.findById(userId);
        User user = optionalUser.get();
        user.setPassword("new password");
        repo.save(user);

        User updateUser  =  repo.findById(userId).get();
        Assertions.assertThat(updateUser.getPassword()).isEqualTo("new password");
    }

    @Test
    public void testGet() {
        Long userId = Long.valueOf(4);
        Optional<User> optionalUser = repo.findById(userId);
        User user = optionalUser.get();

        Assertions.assertThat(optionalUser).isPresent();
        System.out.println(optionalUser.get());
    }

    @Test
    public void testDelete() {
        Long userId = Long.valueOf(5);
        repo.deleteById(userId);

        Optional<User> optionalUser = repo.findById(userId);
        Assertions.assertThat(optionalUser).isNotPresent();
    }
}
