package dev.jx.app.dto;

import java.util.List;
import java.util.stream.Collectors;
import java.io.Serializable;

import dev.jx.app.entity.User;
import dev.jx.app.entity.Role;

public class UserDTO implements Serializable {

    private Integer id;

    private String username;

    private List<String> roles;

    private Boolean active;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.roles = user.getRoles().stream().map(Role::getName).collect(Collectors.toList());
        this.active = user.getActive();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
