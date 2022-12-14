package com.github.curriculeon.repository;

import com.github.curriculeon.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

/** This is the class that allows us to speak to the database
 * By extending CrudRepository, PersonRepository inherits several methods for working with "User" persistence.
 * Including: saving, deleting, finding "User" entities.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsernameAndPassword(String username, String password);
    /*This method is used to query the database for a user with a given username and password.
    The 'LoginController' uses this class to determine if a user with the given username and password exists in the database.
    */
}
