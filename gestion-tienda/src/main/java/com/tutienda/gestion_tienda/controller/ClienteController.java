package com.tutienda.gestion_tienda.controller;

import com.tutienda.gestion_tienda.models.Cliente;
import com.tutienda.gestion_tienda.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Obtener todos los clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> obtenerClientes() {
        List<Cliente> clientes = clienteService.obtenerTodosLosClientes();
        System.out.println("Lista de clientes obtenida");
        return ResponseEntity.ok(clientes);
    }

    // Obtener cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable Long id) {
        System.out.println("Buscando cliente con ID: " + id);
        return ResponseEntity.ok(clienteService.obtenerClientePorId(id));
    }

    // Crear un nuevo cliente
    @PostMapping
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        System.out.println("Creando cliente: " + cliente.getNombre());
        return ResponseEntity.ok(clienteService.guardarCliente(cliente));
    }

    // Eliminar cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        System.out.println("Eliminando cliente con ID: " + id);
        clienteService.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
