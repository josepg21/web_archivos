package com.archivo.backend.services;


import com.archivo.backend.dtos.NewUserDto;
import com.archivo.backend.entities.Role;
import com.archivo.backend.entities.User;
import com.archivo.backend.jwt.JwtUtil;
import com.archivo.backend.repositories.RoleRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserService userService;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public AuthService(UserService userService, RoleRepository roleRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil, AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.userService = userService;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    public String authenticate(String username, String password){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,password);
        Authentication authResult = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authResult);
        return jwtUtil.generateToken(authResult);
    }

    public void registerUser(NewUserDto newUserDto){
        if (userService.existsByUserName(newUserDto.getUserName())){
            throw new IllegalArgumentException("El nombre de usuario ya existe");
        }

        Role role = roleRepository.findByName(newUserDto.getRole())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        User user = new User(newUserDto.getUserName(), passwordEncoder.encode(newUserDto.getPassword()), role);
        userService.save(user);
    }

}
