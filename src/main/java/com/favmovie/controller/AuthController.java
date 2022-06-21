package com.favmovie.controller;

import com.favmovie.dto.LoginDto;
import com.favmovie.dto.RegisterDto;
import com.favmovie.models.MOVUser;
import com.favmovie.models.Favorite;
import com.favmovie.models.Rol;
import com.favmovie.respository.IFavoriteRepository;
import com.favmovie.respository.IRolRepository;
import com.favmovie.respository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private IRolRepository IRolRepository;

    @Autowired
    private IUserRepository IUserRepository;

    @Autowired
    private IFavoriteRepository favoriteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody LoginDto loginDto){
        if(!IUserRepository.existsByUsername(loginDto.getUsername())){
            return ResponseEntity.notFound().build();
        }
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(),
                        loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return ResponseEntity.ok("User Sign In Succesfully!");
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody RegisterDto userDto){
        if(IUserRepository.existsByUsername(userDto.getUsername())){
            return ResponseEntity.badRequest().build();
        }
        try{
            MOVUser user = new MOVUser();
            user.setUsername(userDto.getUsername());
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            Rol roles = IRolRepository.findByName("ROLE_ADMIN").get();
            user.setRoles(Collections.singleton(roles));
            Favorite favorite =  new Favorite();
            favorite.setUser(user);
            favorite.getUser().setFavoriteList(favorite);
            favoriteRepository.save(favorite);
            IUserRepository.save(user);
        }catch (Exception ignore){}
        return ResponseEntity.status(HttpStatus.CREATED).body("User SignUp Successfully");
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logOut(){
       SecurityContext securityContext = SecurityContextHolder.getContext();
        if(securityContext.getAuthentication().isAuthenticated()){
            securityContext.getAuthentication().setAuthenticated(false);
            SecurityContextHolder.clearContext();
            return ResponseEntity.ok("Logout successfully");
        }
        return ResponseEntity.badRequest().build();
    }
}
