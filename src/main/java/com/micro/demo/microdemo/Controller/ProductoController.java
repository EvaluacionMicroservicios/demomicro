package com.micro.demo.microdemo.Controller;
import com.micro.demo.microdemo.Model.Producto;
import com.micro.demo.microdemo.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // Obtener todos los productos
    @GetMapping
    public Flux<Producto> obtenerTodosLosProductos() {
        return productoService.obtenerTodosLosProductos();
    }

    // Obtener un producto por su ID
    @GetMapping("/{id}")
    public Mono<Producto> obtenerProductoPorId(@PathVariable String id) {
        return productoService.obtenerProductoPorId(id);
    }

    // Crear un nuevo producto
    @PostMapping
    public Mono<Producto> crearProducto(@RequestBody Producto producto) {
        return productoService.crearProducto(producto);
    }

    // Actualizar un producto
    @PutMapping("/{id}")
    public Mono<Producto> actualizarProducto(@PathVariable String id, @RequestBody Producto producto) {
        return productoService.actualizarProducto(id, producto);
    }

    // Eliminar un producto
    @DeleteMapping("/{id}")
    public Mono<Void> eliminarProducto(@PathVariable String id) {
        return productoService.eliminarProducto(id);
    }
}