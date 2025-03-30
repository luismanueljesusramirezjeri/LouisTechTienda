package com.tutienda.gestion_tienda.service;

import com.tutienda.gestion_tienda.exception.ResourceNotFoundException;
import com.tutienda.gestion_tienda.models.Proveedor;
import com.tutienda.gestion_tienda.repository.ProveedorRepository;
import com.tutienda.gestion_tienda.repository.projection.ResumenProductoProjection;
import com.tutienda.gestion_tienda.repository.projection.ResumenProveedorProjection;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    // Obtener todos los proveedores
    public List<Proveedor> obtenerTodosLosProveedores() {
        return proveedorRepository.findAll();
    }

    // Obtener un proveedor por ID
    // Obtener un proveedor por ID con validación
    public Proveedor obtenerProveedorPorId(Long id) {
        return proveedorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor con ID " + id + " no encontrado"));
    }
    // Guardar un nuevo proveedor
    public Proveedor guardarProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    // Eliminar un proveedor
    // Eliminar un proveedor con validación
    public void eliminarProveedor(Long id) {
        if (!proveedorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Proveedor con ID " + id + " no encontrado");
        }
        proveedorRepository.deleteById(id);
    }


    // PUT - Actualizar completamente un proveedor
    public Proveedor actualizarProveedor(Long id, Proveedor nuevoProveedor) {
        Proveedor proveedorExistente = proveedorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor con ID " + id + " no encontrado"));

        // Se reemplazan todos los datos
        proveedorExistente.setNombre(nuevoProveedor.getNombre());
        proveedorExistente.setEmail(nuevoProveedor.getEmail());
        proveedorExistente.setTelefono(nuevoProveedor.getTelefono());
        proveedorExistente.setContacto(nuevoProveedor.getContacto());

        return proveedorRepository.save(proveedorExistente);
    }

    // PATCH - Actualizar parcialmente un proveedor
    public Proveedor actualizarParcialmenteProveedor(Long id, Map<String, Object> updates) {
        Proveedor proveedor = proveedorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor con ID " + id + " no encontrado"));

        updates.forEach((campo, valor) -> {
            switch (campo) {
                case "nombre" -> proveedor.setNombre((String) valor);
                case "email" -> proveedor.setEmail((String) valor);
                case "telefono" -> proveedor.setTelefono((String) valor);
                case "contacto" -> proveedor.setContacto((String) valor);
            }
        });

        return proveedorRepository.save(proveedor);
    }





    // obtener datosw de proveedor por nombre
    public List<ResumenProveedorProjection>obtenerProveedorPorNombreProyectado(String proveedor){
        return proveedorRepository.obtenerProveedorPorNombreProyectado(proveedor);
    }

    //Nativo JPA
    @Transactional
    public void actualizarProveedor(Long idProveedor ,String contacto ,String telefono ,String email){
        //verfiicar si existe el proveddor
        if(!proveedorRepository.existsById(idProveedor)){
            throw new ResourceNotFoundException("El proveedor con ID " + idProveedor + " no existe.");
        }

        //llamar al metod
        proveedorRepository.actualizarDatosdelProveedor(contacto,telefono,email,idProveedor);
    }



}
