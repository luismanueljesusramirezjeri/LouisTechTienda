package com.tutienda.gestion_tienda.controller;

import com.tutienda.gestion_tienda.models.Usuario;
import com.tutienda.gestion_tienda.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.obtenerTodos();
        System.out.println("Lista de usuarios obtenida");
        return ResponseEntity.ok(usuarios);
    }

    // Obtener usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable Long id) {
        System.out.println("Buscando usuario con ID: " + id);
        return ResponseEntity.ok(usuarioService.obtenerPorId(id));
    }

    // Guardar usuario
    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        System.out.println("Creando usuario: " + usuario.getNombre());
        return ResponseEntity.ok(usuarioService.guardarUsuario(usuario));
    }

    // Eliminar usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        System.out.println("Eliminando usuario con ID: " + id);
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }



    // PUT - Reemplazar todo el usuario
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(
            @PathVariable Long id,
            @RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.actualizarUsuario(id, usuario));
    }

    // PATCH - Actualización parcial
    @PatchMapping("/{id}")
    public ResponseEntity<Usuario> actualizarParcialmente(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates) {
        return ResponseEntity.ok(usuarioService.actualizarParcialmente(id, updates));
    }
}
