package com.truongvietdung.model.request.user;

import com.truongvietdung.entity.Role;
import com.truongvietdung.entity.RoleGroup;
import com.truongvietdung.entity.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomerUserDetails implements UserDetails {

    private Users users;

    public CustomerUserDetails(Users users) {
        this.users = users;
    }

    public String getFullName(){
        return this.users.getFullName();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<RoleGroup> roleGroups = users.getRoleGroups();

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for(RoleGroup roleGroup : roleGroups) {
            for(Role role : roleGroup.getRoles()){
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            }
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return users.getPassword();
    }

    @Override
    public String getUsername() {
        return users.getUserName();
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
}
