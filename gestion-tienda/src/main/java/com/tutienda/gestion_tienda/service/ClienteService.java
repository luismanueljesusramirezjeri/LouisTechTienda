package com.tutienda.gestion_tienda.service;

import com.tutienda.gestion_tienda.exception.ResourceNotFoundException;
import com.tutienda.gestion_tienda.models.Cliente;
import com.tutienda.gestion_tienda.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
