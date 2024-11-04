package com.version1.finalprojectdashboard.FinalProjectDashboard;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Entity
public class User implements UserDetails {

    @Serial
    private static final transient long serialVersionUID = -2481664232573993804L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="user_id")
    private int userId;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="is_active")
    private boolean active; //boolean not Boolean
    @Column(name="roles")
    private List<UserRole> roles = new ArrayList<>();


    public User(int userId, String username, String password, boolean active, List<UserRole> roles) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.active = active;
        this.roles = roles;
    }

    public User() {}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (UserRole role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getTitle()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {return this.password;}
    @Override
    public String getUsername() {return this.username;}
    public int getUserId() {return userId;}
    public boolean isAccountNonExpired() {return true;}
    public boolean isAccountNonLocked() {return true;}
    public boolean isEnabled() {return true;}
    public boolean isCredentialsNonExpired() {return true;}
    public void setUsername(String username) {this.username = username;}
    public void setPassword(String password) {this.password = password;}
    public boolean isActive() {return active;} //isActive not getActive
    public void setActive(boolean active) {this.active = active;}
    public List<UserRole> getRoles() { return roles; }
    public void setRoles(List<UserRole> roles) { this.roles = roles; }

}
