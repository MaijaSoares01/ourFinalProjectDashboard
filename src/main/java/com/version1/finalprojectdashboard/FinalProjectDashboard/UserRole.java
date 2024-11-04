package com.version1.finalprojectdashboard.FinalProjectDashboard;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_role_id")
    private int userRoleId;

    @Column(unique = true, nullable = false) // Ensure name cannot be null
    private String name; // e.g., ROLE_USER or ROLE_ADMIN

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    // Default constructor
    public UserRole() {}

    // Constructor for creating roles with only a name
    public UserRole(String name) {
        this.name = name;
    }

    // Getters and Setters
    public int getUserRoleId() { return userRoleId; }
    public void setUserRoleId(int userRoleId) { this.userRoleId = userRoleId; } // Changed to accept int type

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

//    public List<User> getUsers() { return users; }
//    public void setUsers(List<User> users) { this.users = users; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole role = (UserRole) o;
        return Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}