package dev.jx.app.entity;

import java.util.Collection;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "db_users")
public class User implements UserDetails {

    @Id
    @Column(name = "dbu_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "db_users_roles",
            joinColumns = @JoinColumn(name = "db_user_id", referencedColumnName = "dbu_id"),
            inverseJoinColumns = @JoinColumn(name = "db_rol_id", referencedColumnName = "dbr_id")
    )
    private Set<Role> roles = new HashSet<>();

    @Column(name = "db_username", nullable = false, unique = true)
    @NotBlank(message = "Username must not be blank")
    @Pattern(
            regexp = "^[A-Z0-9_]{3,12}$",
            flags = Pattern.Flag.CASE_INSENSITIVE,
            message = "Username must be at least 3 characters to 12 in length and may only contain alphanumeric characters"
    )
    private String username;

    @Column(name = "dbu_password", nullable = false)
    @NotBlank(message = "Password must not be blank")
    @Pattern(
            regexp = "^(?=.*[A-Za-z])(?=.*[0-9])[A-Z0-9]{8,}$",
            flags = Pattern.Flag.CASE_INSENSITIVE,
            message = "Password must contain at least 8 characters, at least one letter and one number"
    )
    private String password;

    @Column(name = "dbu_active")
    private Boolean active;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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

    public boolean isEnabled() {
        return active;
    }
}
