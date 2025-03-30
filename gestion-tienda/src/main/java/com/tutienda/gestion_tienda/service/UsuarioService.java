package com.tutienda.gestion_tienda.service;

import com.tutienda.gestion_tienda.exception.ResourceNotFoundException;
import com.tutienda.gestion_tienda.models.Usuario;
import com.tutienda.gestion_tienda.repository.UsuarioRepository;
import com.tutienda.gestion_tienda.repository.projection.ResumenUsuarioProjection;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Obtener todos los usuarios
    public List<Usuario> obtenerTodos() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        System.out.println("Usuarios obtenidos: " + usuarios.size()); // DEBUG
        for (Usuario u : usuarios) {
            System.out.println(u.getNombre() + " - " + u.getEmail()); // Muestra cada usuario
        }
        return usuarios;
    }

    // Obtener un usuario por ID
    public Usuario obtenerPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario con ID " + id + " no encontrado"));
    }

    // Guardar un nuevo usuario
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Eliminar un usuario con validación
    public void eliminarUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Usuario con ID " + id + " no encontrado");
        }
        usuarioRepository.deleteById(id);
    }


    // PUT - Reemplazar todos los datos de un usuario
    public Usuario actualizarUsuario(Long id, Usuario nuevoUsuario) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario con ID " + id + " no encontrado"));

        usuarioExistente.setNombre(nuevoUsuario.getNombre());
        usuarioExistente.setEmail(nuevoUsuario.getEmail());
        usuarioExistente.setTelefono(nuevoUsuario.getTelefono());
        usuarioExistente.setContraseña(nuevoUsuario.getContraseña());
        usuarioExistente.setRol(nuevoUsuario.getRol());

        return usuarioRepository.save(usuarioExistente);
    }

    // PATCH - Actualizar parcialmente usando un Map<String, Object>
    public Usuario actualizarParcialmente(Long id, Map<String, Object> updates) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario con ID " + id + " no encontrado"));

        updates.forEach((campo, valor) -> {
            switch (campo) {
                case "nombre" -> usuario.setNombre((String) valor);
                case "email" -> usuario.setEmail((String) valor);
                case "telefono" -> usuario.setTelefono((String) valor);
                case "contraseña" -> usuario.setContraseña((String) valor);
                case "rol" -> usuario.setRol((String) valor);
            }
        });

        return usuarioRepository.save(usuario);
    }





    // Obtener clientes por nombre utilizando la interfaz de proyección ResumenClienteProjection
    public List<ResumenUsuarioProjection>obtenerUsuariosPorNombreProyectado(String usuario){
        return usuarioRepository.obtenerUsuariosPorNombreProyectado(usuario);
    }

    //Nativo JPA
    @Transactional
    public void actualizarUsuario(Long idUsurio ,String nombre ,String telefono ,String email){
        //Verificar si el usuario Existe antes de modificar o actualziar ps
        if(!usuarioRepository.existsById(idUsurio)){
            throw new EntityNotFoundException("El usuario con ID " + idUsurio + " no existe.");
        }
        // Llama al metodo nativo
        usuarioRepository.actualizarUsuario(nombre,telefono,email ,idUsurio);
    }



}
