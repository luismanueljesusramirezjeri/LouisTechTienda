package com.tutienda.gestion_tienda.service;

import com.tutienda.gestion_tienda.exception.ResourceNotFoundException;
import com.tutienda.gestion_tienda.models.Cliente;
import com.tutienda.gestion_tienda.repository.ClienteRepository;
import com.tutienda.gestion_tienda.repository.projection.ResumenClienteProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Obtener todos los clientes
    public List<Cliente> obtenerTodosLosClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        System.out.println("Clientes obtenidos: " + clientes.size()); //DEBUG
        return clientes;
    }

    // Obtener un cliente por ID
    public Cliente obtenerClientePorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente con ID " + id + " no encontrado"));
    }

    // Guardar un nuevo cliente
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Eliminar un cliente con validación
    public void eliminarCliente(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cliente con ID " + id + " no encontrado");
        }
        clienteRepository.deleteById(id);
    }


    // Actualizar un cliente con validación
    public Cliente actualizarCliente(Long id, Cliente nuevoCliente) {
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        // Se reemplazan todos los datos
        clienteExistente.setNombre(nuevoCliente.getNombre());
        clienteExistente.setEmail(nuevoCliente.getEmail());
        clienteExistente.setTelefono(nuevoCliente.getTelefono());

        return clienteRepository.save(clienteExistente);
    }
    //Actualiza cliente parcialmente
    public Cliente actualizarParcialmenteCliente(Long id, Map<String, Object> updates) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        updates.forEach((campo, valor) -> {
            switch (campo) {
                case "nombre" -> cliente.setNombre((String) valor);
                case "email" -> cliente.setEmail((String) valor);
                case "telefono" -> cliente.setTelefono((String) valor);
            }
        });

        return clienteRepository.save(cliente);
    }







    // Obtener clientes por nombre utilizando la interfaz de proyección ResumenClienteProjection
    public List<ResumenClienteProjection> obtenerClientesPorNombreProyectado(String nombre) {
        return clienteRepository.obtenerClientesPorNombreProyectado(nombre);
    }

}
