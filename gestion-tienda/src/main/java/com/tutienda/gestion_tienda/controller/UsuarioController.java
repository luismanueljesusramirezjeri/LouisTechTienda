package com.tutienda.gestion_tienda.controller;

import com.tutienda.gestion_tienda.models.Usuario;
import com.tutienda.gestion_tienda.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.obtenerTodos();
        System.out.println("Lista de usuarios obtenida"); // 🔹 DEBUG
        return ResponseEntity.ok(usuarios);
    }

    // Obtener usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable Long id) {
        System.out.println("Buscando usuario con ID: " + id); // 🔹 DEBUG
        return ResponseEntity.ok(usuarioService.obtenerPorId(id));
    }

    // Guardar usuario
    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        System.out.println("Creando usuario: " + usuario.getNombre()); // 🔹 DEBUG
        return ResponseEntity.ok(usuarioService.guardarUsuario(usuario));
    }

    // Eliminar usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        System.out.println("Eliminando usuario con ID: " + id); // 🔹 DEBUG
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
