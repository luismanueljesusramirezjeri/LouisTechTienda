package com.tutienda.gestion_tienda.service;

import com.tutienda.gestion_tienda.models.Usuario;
import com.tutienda.gestion_tienda.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Obtener todos los usuarios
    // Obtener todos los usuarios
    public List<Usuario> obtenerTodos() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        System.out.println("Usuarios obtenidos: " + usuarios.size()); // 🔹 DEBUG
        for (Usuario u : usuarios) {
            System.out.println(u.getNombre() + " - " + u.getEmail()); // 🔹 Muestra cada usuario
        }
        return usuarios;
    }

    // Obtener un usuario por ID
    public Optional<Usuario> obtenerPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    // Guardar un nuevo usuario
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Eliminar usuario
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
