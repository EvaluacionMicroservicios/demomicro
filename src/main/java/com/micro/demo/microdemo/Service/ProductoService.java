package com.micro.demo.microdemo.Service;
import com.micro.demo.microdemo.Model.Producto;
import com.micro.demo.microdemo.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // Obtener todos los productos
    public Flux<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    // Obtener un producto por su ID
    public Mono<Producto> obtenerProductoPorId(String id) {
        return productoRepository.findById(id);
    }

    // Crear un nuevo producto
    public Mono<Producto> crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    // Actualizar un producto
    public Mono<Producto> actualizarProducto(String id, Producto producto) {
        return productoRepository.findById(id)
                .flatMap(existingProducto -> {
                    // Solo actualizamos los campos que no son por defecto
                    if (producto.getNombre() != null) {
                        existingProducto.setNombre(producto.getNombre());
                    }
                    if (producto.getPrecio() != 0) {  // Usamos 0 como valor por defecto
                        existingProducto.setPrecio(producto.getPrecio());
                    }
                    if (producto.getCantidad() != 0) {  // Usamos 0 como valor por defecto
                        existingProducto.setCantidad(producto.getCantidad());
                    }

                    // Guardamos el producto actualizado
                    return productoRepository.save(existingProducto);
                })
                .switchIfEmpty(Mono.error(new RuntimeException("Producto no encontrado")));
    }

    // Eliminar un producto
    public Mono<Void> eliminarProducto(String id) {
        return productoRepository.deleteById(id);
    }
}