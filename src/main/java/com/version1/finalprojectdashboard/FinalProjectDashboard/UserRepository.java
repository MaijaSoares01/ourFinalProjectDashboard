package com.version1.finalprojectdashboard.FinalProjectDashboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);
    // Custom query to filter users by username or role
    List<User> findByUsernameOrRoles(String username, String roles);
    List<User> findByUsernameAndRoles(String username, String role);

    // Custom query to filter users by role
    @Query("SELECT u FROM User u WHERE u.roles LIKE %:role%")
    List<User> filterByRole(@Param("role") String role);

    // Filter users by role (partial match)
    List<User> findByRoles(String role);

    List<User> findByRolesContaining(String roleFilter);
}