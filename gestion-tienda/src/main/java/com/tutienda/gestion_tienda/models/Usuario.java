package com.tutienda.gestion_tienda.models;

import jakarta.persistence.*;
//Creado por LuisRamirez
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "contraseña", nullable = false)
    private String contraseña;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "rol", nullable = false)
    private String rol;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    // 🔹 Constructor vacío requerido por JPA
    public Usuario() {
    }

    // 🔹 Constructor con parámetros
    public Usuario(Long idUsuario, String contraseña, String email, String nombre, String rol, String telefono) {
        this.idUsuario = idUsuario;
        this.contraseña = contraseña;
        this.email = email;
        this.nombre = nombre;
        this.rol = rol;
        this.telefono = telefono;
    }

    // 🔹 Getters y Setters

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
            this.idUsuario = idUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
