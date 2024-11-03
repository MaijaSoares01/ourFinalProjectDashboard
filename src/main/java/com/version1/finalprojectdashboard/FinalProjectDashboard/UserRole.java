package com.version1.finalprojectdashboard.FinalProjectDashboard;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_role_id")
    private int userRoleId;

    @Column
    private String title; // e.g., ROLE_USER or ROLE_ADMIN

    public UserRole() {}

    public UserRole(String title) {
        this.title = title;
    }

    // Getters and setters
    public int getUserRoleId() { return userRoleId; }
    public void setUserRoleId(Long id) { this.userRoleId = userRoleId; }
    public String getTitle() { return title; }
    public void setTitle(String name) { this.title = title; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole role = (UserRole) o;
        return Objects.equals(title, role.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
