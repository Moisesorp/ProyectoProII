package com.proyecto.proyecto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.proyecto.proyecto.model.Usuario;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;







@RestController
public class UsuarioController {
    private List<Usuario> usuarios = new
        ArrayList<>(Arrays.asList( new Usuario(123, "Moises", "Orellano")));

        @GetMapping("/Usuario")/*comentario */ 
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
        
        
@PostMapping("/Usuario")
public Usuario creaUsuario (@RequestBody Usuario usuario) {
    usuarios.add(usuario);
    return usuario;
    
    
}
@PutMapping("/Usuario")
public Usuario putusuario(@RequestBody Usuario usuario) {
    for(Usuario u: usuarios) {
        if (u.getIdUsuario() == usuario.getIdUsuario()) {
            u.setNombre(usuario.getNombre());
            u.setApellido(usuario.getApellido());
            return u;
        }
        


    }
    return null;
}

    @DeleteMapping("algo/{idUsuario}")
    public Usuario deleteuser(@PathVariable int idUsuario) {
        for (Usuario u : usuarios) {
            if (u.getIdUsuario() == idUsuario) {
                usuarios.remove(u);
                return u;
            }
        }
        
        return null;
    }
    

        }
        



    
    
    





