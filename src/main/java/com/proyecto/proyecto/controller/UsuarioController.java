package com.proyecto.proyecto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.proyecto.proyecto.model.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;






@RestController
public class UsuarioController {
    private List<Usuario> usuarios = new
        ArrayList<>(Arrays.asList( new Usuario(123, "Moises", "Orellano")));

        @GetMapping("/Usuario")
        public List<Usuario> getUsuarios() {
            return usuarios;
        }

        @GetMapping("/{nombre}")
        public Usuario getuserid(@PathVariable String nombre) {
            for (Usuario c : usuarios) {
                if (c.getNombre().equalsIgnoreCase(nombre)) {
                    return c;
                }
            }
    
            return null;
        }
        
        
@PostMapping("/usuario")
public Usuario creaUsuario (@RequestBody Usuario usuario) {
    usuarios.add(usuario);
    return usuario;
    
    
}

};


