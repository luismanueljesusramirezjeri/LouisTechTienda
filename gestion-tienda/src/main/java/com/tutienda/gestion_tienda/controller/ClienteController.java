package com.tutienda.gestion_tienda.controller;

import com.tutienda.gestion_tienda.models.Cliente;
import com.tutienda.gestion_tienda.repository.projection.ResumenClienteProjection;
import com.tutienda.gestion_tienda.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    // Actualizar cliente
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        System.out.println("Actualizando cliente con ID: " + id);
        Cliente clienteActualizado = clienteService.actualizarCliente(id, cliente);
        return ResponseEntity.ok(clienteActualizado);
    }



    // Actualiza cliente parcialmente
    @PatchMapping("/{id}")
    public ResponseEntity<Cliente> actualizarParcialmenteCliente(
            @PathVariable Long id, @RequestBody Map<String, Object> updates) {

        System.out.println("Actualizando parcialmente cliente con ID: " + id);
        Cliente clienteActualizado = clienteService.actualizarParcialmenteCliente(id, updates);
        return ResponseEntity.ok(clienteActualizado);
    }







    // Obtener clientes por nombre utilizando la interfaz de proyección ResumenClienteProjection
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<ResumenClienteProjection>> obtenerClientesPorNombre(@PathVariable String nombre) {
        System.out.println("Buscando clientes con nombre: " + nombre);
        List<ResumenClienteProjection> clientes = clienteService.obtenerClientesPorNombreProyectado(nombre);
        return ResponseEntity.ok(clientes);
    }


}
