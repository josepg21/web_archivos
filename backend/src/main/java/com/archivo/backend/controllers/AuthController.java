package com.archivo.backend.controllers;


import com.archivo.backend.dtos.LoginUserDto;
import com.archivo.backend.dtos.NuevoUsuarioDto;
import com.archivo.backend.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import com.archivo.backend.repositories.RoleRepository;
import com.archivo.backend.entities.Rol;
import com.archivo.backend.dtos.RoleDto;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginUserDto loginUserDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body("Revise sus credenciales");
        }
        try {
            String jwt = authService.authenticate(loginUserDto.getUsuario(), loginUserDto.getContraseña());
            return ResponseEntity.ok(jwt);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody NuevoUsuarioDto NuevoUsuarioDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body("Revise los campos");
        }
        try {
            authService.registerUser(NuevoUsuarioDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Registrado");
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/check-auth")
    public ResponseEntity<String> checkAuth(){
        return ResponseEntity.ok().body("Autenticado");
    }

    @GetMapping("/roles")
    public ResponseEntity<List<RoleDto>> getRoles() {
        List<Rol> roles = roleRepository.findAll();
        List<RoleDto> dtos = roles.stream().map(r -> {
            RoleDto dto = new RoleDto();
            dto.setId(r.getId());
            dto.setRoles(r.getRoles());
            return dto;
        }).toList();
        return ResponseEntity.ok(dtos);
    }
}
