package com.archivo.backend.services;


import com.archivo.backend.dtos.NuevoUsuarioDto;
import com.archivo.backend.entities.Cliente;
import com.archivo.backend.entities.Rol;
import com.archivo.backend.entities.Usuario;
import com.archivo.backend.jwt.JwtUtil;
import com.archivo.backend.repositories.RoleRepository;
import com.archivo.backend.repositories.ClienteRepository;
import com.archivo.backend.repositories.AreaInternaRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UsuarioService usuarioService;
    private final ClienteRepository clienteRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private RoleRepository roleRepository;
    public AuthService(UsuarioService usuarioService, RoleRepository roleRepository, ClienteRepository clienteRepository, AreaInternaRepository areaInternaRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil, AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.usuarioService = usuarioService;
        this.roleRepository = roleRepository;
        this.clienteRepository = clienteRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    public String authenticate(String usuario, String contraseña){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(usuario, contraseña);
        Authentication authResult = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authResult);
        return jwtUtil.generateToken(authResult);
    }

public void registerUser(NuevoUsuarioDto nuevoUsuarioDto) {
    // Verificar si el usuario ya existe
    if (usuarioService.existsByUsuario(nuevoUsuarioDto.getUsuario())) {
        throw new IllegalArgumentException("El nombre de usuario ya existe");
    }

    // Buscar el rol por nombre
    Rol rol = roleRepository.findByRoles(nuevoUsuarioDto.getRol())
        .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

    // Crear el usuario
    Usuario usuario = new Usuario();
    usuario.setUsuario(nuevoUsuarioDto.getUsuario());
    usuario.setContraseña(passwordEncoder.encode(nuevoUsuarioDto.getContraseña()));
    usuario.setNombreCompleto(nuevoUsuarioDto.getNombreCompleto());
    usuario.setRol(rol);


    usuario.setFechaCreado(java.time.LocalDateTime.now());
    usuario.setFechaActualizado(java.time.LocalDateTime.now());

    // Guardar el usuario
    usuarioService.save(usuario);
}
}