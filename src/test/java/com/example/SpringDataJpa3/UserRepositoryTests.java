package com.example.SpringDataJpa3;

import com.example.SpringDataJpa3.entity.User;
import com.example.SpringDataJpa3.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByUsername() {
        User user = userRepository.findByUsername("john");
        Assertions.assertEquals("john", user.getUsername());
    }

    @Test
    public void testFindByUserNameIs() {
        User user = userRepository.findByUsernameIs("john");
        Assertions.assertEquals("john", user.getUsername());
    }

    @Test
    public void testFindByUserNameEquals() {
        User user = userRepository.findByUsernameEquals("john");
        Assertions.assertEquals("john", user.getUsername());
    }

    @Test
    public void testFindAllByOrderByRegistrationDate() {
        List<User> users = userRepository.findAllByOrderByRegistrationDate();
        Assertions.assertEquals(7, users.size());
        Assertions.assertEquals("katie@somewhrelse.com", users.get(0).getEmail());
    }

    @Test
    public void testFindAllByOrderByRegistrationDateAsc() {
        List<User> users = userRepository.findAllByOrderByRegistrationDateAsc();
        Assertions.assertEquals(7, users.size());
        Assertions.assertEquals("katie", users.get(0).getUsername());
    }

    @Test
    public void testFindAllByOrderByRegistrationDateDesc() {
        List<User> users = userRepository.findAllByOrderByRegistrationDateDesc();
        Assertions.assertEquals(7, users.size());
        Assertions.assertEquals("john", users.get(0).getUsername());
    }

    @Test
    public void testFindByRegistrationDateOrderByUsername() {
        List<User> users = userRepository.findByRegistrationDateOrderByUsername(LocalDate.of(2014, Month.APRIL, 5));
        Assertions.assertEquals(2, users.size());
        Assertions.assertEquals("alissa", users.get(0).getUsername());
    }

    @Test
    public void testFindByRegistrationDateOrderByUsernameAsc() {
        List<User> users = userRepository.findByRegistrationDateOrderByUsernameAsc(LocalDate.of(2014, Month.APRIL, 5));
        Assertions.assertEquals(2, users.size());
        Assertions.assertEquals("alissa", users.get(0).getUsername());
    }

    @Test
    public void testFindByRegistrationDateOrderByUsernameDesc() {
        List<User> users = userRepository.findByRegistrationDateOrderByUsernameDesc(LocalDate.of(2014, Month.APRIL, 5));
        Assertions.assertEquals(2, users.size());
        Assertions.assertEquals("tom", users.get(0).getUsername());
    }

    @Test
    public void testFindByRegistrationDateBetween() {
        List<User> users = userRepository.findByRegistrationDateBetween(LocalDate.of(2014, Month.APRIL, 2), LocalDate.now());
        Assertions.assertEquals(6, users.size());
    }

    @Test
    public void testFindByRegistrationDateBefore() {
        List<User> users = userRepository.findByRegistrationDateBefore(LocalDate.now());
        Assertions.assertEquals(7, users.size());
    }

    @Test
    public void testFindByRegistrationDateAfter() {
        List<User> users = userRepository.findByRegistrationDateAfter(LocalDate.of(2014, Month.APRIL, 2));
        Assertions.assertEquals(6, users.size());
    }

    @Test
    public void testFindByLevelIn() {
        List<User> users = userRepository.findByLevelIn(List.of(2, 3));
        Assertions.assertEquals(4, users.size());
    }

    @Test
    public void testFindByLevelNotIn() {
        List<User> users = userRepository.findByLevelNotIn(List.of(2, 3));
        Assertions.assertEquals(3, users.size());
    }

    @Test
    public void testFindByLevelLessThan() {
        List<User> users = userRepository.findByLevelLessThan(2);
        Assertions.assertEquals(3, users.size());
    }

    @Test
    public void testFindByLevelLessThanEqual() {
        List<User> users = userRepository.findByLevelLessThanEqual(2);
        Assertions.assertEquals(6, users.size());
    }

    @Test
    public void testFindByLevelGreaterThan() {
        List<User> users = userRepository.findByLevelGreaterThan(2);
        Assertions.assertEquals(1, users.size());
    }

    @Test
    public void testFindByLevelGreaterThanEqual() {
        List<User> users = userRepository.findByLevelGreaterThanEqual(2);
        Assertions.assertEquals(4, users.size());
    }

    @Test
    public void testFindByUsernameStartingWith() {
        List<User> users = userRepository.findByUsernameStartingWith("j");
        Assertions.assertEquals(2, users.size());
        Assertions.assertEquals("john", users.get(0).getUsername());
    }

    @Test
    public void testFindByUsernameEndingWith() {
        List<User> users = userRepository.findByUsernameEndingWith("e");
        Assertions.assertEquals(3, users.size());
        Assertions.assertEquals("katie", users.get(2).getUsername());
    }

    @Test
    public void testFindByUsernameContaining() {
        List<User> users = userRepository.findByUsernameContaining("a");
        Assertions.assertEquals(4, users.size());
        Assertions.assertEquals("ravi", users.get(1).getUsername());
        Assertions.assertEquals("katie@somewhrelse.com", users.get(3).getEmail());
    }

    @Test
    public void testFindByUsernameContainingIgnoreCase() {
        List<User> users = userRepository.findByUsernameContainingIgnoreCase("A");
        Assertions.assertEquals(4, users.size());
        Assertions.assertEquals("ravi", users.get(1).getUsername());
        Assertions.assertEquals("katie@somewhrelse.com", users.get(3).getEmail());
    }

    @Test
    public void testFindByUsernameNull() {
        List<User> users = userRepository.findByUsernameNull();
        Assertions.assertEquals(0, users.size());
    }

    @Test
    public void testFindByUsernameIsNull() {
        List<User> users = userRepository.findByUsernameIsNull();
        Assertions.assertEquals(0, users.size());
    }

    @Test
    public void testFindByUsernameNotNull() {
        List<User> users = userRepository.findByUsernameNotNull();
        Assertions.assertEquals(7, users.size());
    }

    @Test
    public void testFindByUsernameIsNotNull() {
        List<User> users = userRepository.findByUsernameIsNotNull();
        Assertions.assertEquals(7, users.size());
    }

    @Test
    public void testFindByLevelNot() {
        List<User> users = userRepository.findByLevelNot(2);
        Assertions.assertEquals(4, users.size());
    }

    @Test
    public void testFindByLevelIsNot() {
        List<User> users = userRepository.findByLevelIsNot(1);
        Assertions.assertEquals(4, users.size());
    }

    @Test
    public void testFindByIsActiveTrue() {
        List<User> users = userRepository.findByIsActiveTrue();
        Assertions.assertEquals(5, users.size());
    }

    @Test
    public void testFindByIsActiveFalse() {
        List<User> users = userRepository.findByIsActiveFalse();
        Assertions.assertEquals(2, users.size());
    }

    @Test
    public void testFindByIsActiveAndUsernameEndingWith() {
        List<User> users = userRepository.findFirst2ByIsActiveAndUsernameEndingWith(false, "e");
        Assertions.assertEquals(1, users.size());
        Assertions.assertEquals("nicole", users.get(0).getUsername());
    }

    @Test
    public void testFindByIsActiveTrueAndUsernameStartingWith() {
        List<User> users = userRepository.findFirst2ByIsActiveTrueAndUsernameEndingWith("m");
        Assertions.assertEquals(1, users.size());
        Assertions.assertEquals("tom", users.get(0).getUsername());
    }

    @Test
    public void testFindAllPage1Of3Users() {
        Pageable pageable = PageRequest.of(0, 3);
        Page<User> page1Of3Users = userRepository.findAll(pageable);
        List<User> users = page1Of3Users.getContent();
        Assertions.assertEquals(3, users.size());
        Assertions.assertEquals("nicole", users.get(2).getUsername());
    }

    @Test
    public void testFindAllPage2Of3Users() {
        Pageable pageable = PageRequest.of(1, 3);
        Page<User> page2Of3Users = userRepository.findAll(pageable);
        List<User> users = page2Of3Users.getContent();
        Assertions.assertEquals(3, users.size());
        Assertions.assertEquals("tom", users.get(2).getUsername());
    }

    @Test
    public void testFindAllPage2Of3UsersSortByLevel() {
        Sort sortByLevel = Sort.by("level");
        Pageable pageable = PageRequest.of(1, 3, sortByLevel);
        Page<User> page2Of3Users = userRepository.findAll(pageable);
        List<User> users = page2Of3Users.getContent();
        Assertions.assertEquals(3, users.size());
        Assertions.assertTrue(List.of(2L, 5L, 6L).containsAll(List.of(users.get(0).getId(), users.get(1).getId(), users.get(2).getId())));
    }

    @Test
    public void testFindAllPage2Of3UsersSortByLevelAndId() {
        Sort sortByLevelAndId = Sort.by("level").and(Sort.by("id"));
        Pageable pageable = PageRequest.of(1, 3, sortByLevelAndId);
        Page<User> page2Of3Users = userRepository.findAll(pageable);
        List<User> users = page2Of3Users.getContent();
        Assertions.assertEquals(3, users.size());
        Assertions.assertEquals(2L, users.get(0).getId());
        Assertions.assertEquals(5L, users.get(1).getId());
        Assertions.assertEquals(6L, users.get(2).getId());
    }

    @BeforeAll
    public void populateData(){
        List<User> users = new ArrayList<>();
        users.add(new User("john", LocalDate.of(2021, Month.AUGUST, 4), "john@Gmail.com", 1, true));
        users.add(new User("jane", LocalDate.of(2019, Month.MARCH, 18), "jane@somewhrelse.com", 2, true));
        users.add(new User("nicole", LocalDate.of(2017, Month.JULY, 21), "nicole@somewhr.com", 1, false));
        users.add(new User("ravi", LocalDate.of(2018, Month.JUNE, 15), "ravi@somewhrelse.com", 1, false));
        users.add(new User("alissa", LocalDate.of(2014, Month.APRIL, 5), "alissa@somewhr.com", 2, true));
        users.add(new User("tom", LocalDate.of(2014, Month.APRIL, 5), "tom@somewhr.com", 2, true));
        users.add(new User("katie", LocalDate.of(2014, Month.APRIL, 1), "katie@somewhrelse.com", 3, true));
        userRepository.saveAll(users);
    }

    @AfterAll
    public void dePopulateData(){
        userRepository.deleteAll();
    }

}
