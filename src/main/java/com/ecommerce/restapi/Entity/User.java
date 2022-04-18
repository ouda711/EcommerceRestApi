package com.ecommerce.restapi.Entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name="users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email_address"),
        @UniqueConstraint(columnNames = "phone_number")
})
public class User extends TimestampedEntity implements UserDetails {
    public User(){}

    @Column(name="first_name", nullable = false, length = 100)
    private String first_name;

    @Column(name="last_name", nullable = false, length = 100)
    private String last_name;

    @Column(name="email_address", nullable = false, length = 255)
    private String email_address;

    @Column(name="phone_number", nullable = false, length = 100)
    private String phone_number;

    @Column(name = "password")
    private String password;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;

    public User(String first_name, String last_name, String email_address, String phone_number, String password, String role){
        this(first_name, last_name, email_address, phone_number, password, Collections.singletonList(new Role(role)));
    }

    public User(String first_name, String last_name, String email_address, String phone_number, String password, List<Role>roles){
        this(first_name, last_name, email_address, phone_number, password, new HashSet<Role>(roles));
    }

    public User(String first_name, String last_name, String email_address, String phone_number, String password, Set<Role> roles){
        this.first_name = first_name;
        this.last_name = last_name;
        this.email_address = email_address;
        this.phone_number = phone_number;
        this.password = password;
        this.roles = roles;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String toString(){
        return "User{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email_address='" + email_address + '\'' +
                ",phone_number = '" + phone_number + '\'' +
                ", password='" + "*********" + '\'' +
                ", roles=" + roles +
                '}';
    }
}