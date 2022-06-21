package com.favmovie.util;

import com.favmovie.models.MOVUser;
import com.favmovie.respository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class SecurityUserContext {

    @Autowired
    IUserRepository userRepository;


    public String getUsernameByContext(){
        Object context = SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String username = null;
        if(context instanceof UserDetails){
           return username = ((UserDetails)context).getUsername();
        }else{
          return  username = context.toString();
        }
    }


    public MOVUser getUserByContext(){
        return userRepository.findByUsername(getUsernameByContext());
    }
}
