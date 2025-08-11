package com.example.SpringDataJpa3.repository;

import com.example.SpringDataJpa3.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    User findByUsernameIs(String username);
    User findByUsernameEquals(String username);

    List<User> findAllByOrderByRegistrationDate();
    List<User> findAllByOrderByRegistrationDateAsc();
    List<User> findAllByOrderByRegistrationDateDesc();

    List<User> findByRegistrationDateOrderByUsername(LocalDate registrationDate);
    List<User> findByRegistrationDateOrderByUsernameAsc(LocalDate registrationDate);
    List<User> findByRegistrationDateOrderByUsernameDesc(LocalDate registrationDate);

    List<User> findByRegistrationDateBetween(LocalDate start, LocalDate end);
    List<User> findByRegistrationDateBefore(LocalDate before);
    List<User> findByRegistrationDateAfter(LocalDate after);

    List<User> findByLevelIn(List<Integer> levels);
    List<User> findByLevelNotIn(List<Integer> levels);


    List<User> findByLevelLessThan(Integer level);
    List<User> findByLevelLessThanEqual(Integer level);

    List<User> findByLevelGreaterThan(Integer level);
    List<User> findByLevelGreaterThanEqual(Integer level);

    List<User> findByUsernameStartingWith(String start);
    List<User> findByUsernameEndingWith(String end);
    List<User> findByUsernameContaining(String contain);

    List<User> findByUsernameContainingIgnoreCase(String contain);

    List<User> findByUsernameNull();
    List<User> findByUsernameIsNull();

    List<User> findByUsernameNotNull();
    List<User> findByUsernameIsNotNull();

    List<User> findByLevelNot(Integer level);
    List<User> findByLevelIsNot(Integer level);

    List<User> findByIsActiveTrue();
    List<User> findByIsActiveFalse();

    List<User> findFirst2ByIsActiveAndUsernameEndingWith(Boolean isActive, String end);
    List<User> findFirst2ByIsActiveTrueAndUsernameEndingWith(String end);

    Page<User> findAll(Pageable pageable);

    @Transactional
    Integer deleteByLevel(Integer level);

    @Transactional
    @Modifying
    @Query("delete from User u where u.level = :level")
    Integer deleteInBulkLevel(Integer level);

}
