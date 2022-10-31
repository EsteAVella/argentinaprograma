/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.backendAvella.Service;

import com.backend.backendAvella.Entity.Persona;
import com.backend.backendAvella.Entity.dto.UserDto;
import com.backend.backendAvella.Repository.AuthRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service

public class AuthService {
    @Autowired
    AuthRepository repository;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
        
    public boolean isUserEnabled(UserDto userDto) {
        boolean isUserEnabled = false;
        List<Persona> personas = repository.findByEmailAndIsEnabledTrue(userDto.getEmail());
        if (!personas.isEmpty()) {
            Persona persona = personas.get(0);
            if (passwordEncoder.matches(userDto.getPassword(), persona.getPassword()))
                isUserEnabled = true;
        }
        return isUserEnabled;
    }
    
    public void crearUsuario(Persona persona) throws Exception{
        List<Persona> personas = repository.findByEmailAndIsEnabledTrue(persona.getEmail());
        if (!personas.isEmpty()) {
            throw new Exception("El email ya está registrado.");
        } else {
            persona.setPassword(passwordEncoder.encode(persona.getPassword()));
            persona.setEnabled(true);
            repository.save(persona);
        }
    }

  
}
