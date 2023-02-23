package org.venus_teah_poketeam_casestudy.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;

//DON'T USE LOMBOK
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomUserDetails implements UserDetails {
//USING THIS INSTEAD OF A DTO MAPPING SO I CAN GET THE USERDETAIL OBJECT BACK AND SAVE IT TO TRAINER

    // FIELDS
    private User user;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    //CONSTRUCTOR
   public CustomUserDetails(User user){
        this.user = user;
    }

   //OVERRIDED METHODS


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new HashSet<GrantedAuthority>();
    }


//    @Override
//    public String getPassword() { //ALREADY HAVE GETPASSWORD SO WON'T NEED THIS
//        return user.getPassword();
////        return new BCryptPasswordEncoder().encode(user.getPassword());
//    }


    @Override
    public String getUsername() {
        return user.getEmail();
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
