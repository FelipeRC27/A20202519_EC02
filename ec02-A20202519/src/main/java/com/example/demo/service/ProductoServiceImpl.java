package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.BodegaResponseDTO;
import com.example.demo.DTO.ProductoResponseDTO;
import com.example.demo.DTO.ProductosRequestDTO;
import com.example.demo.model.Bodega;
import com.example.demo.model.Productos;
import com.example.demo.repository.BodegaRepository;
import com.example.demo.repository.ProductoRepository;
@Service
public class ProductoServiceImpl implements ProductosService {

	@Autowired
	private ProductoRepository repository;
	
	@Override
	public void guardarProductos(ProductosRequestDTO p) {
		// TODO Auto-generated method stub
		Productos producto = new Productos();
		producto.setIdProducto(p.getIdProducto());
		producto.setProducto(p.getNombreProducto());
		producto.setDescripcion(p.getDescripcionProducto());
		producto.setPrecio(p.getPrecioProducto());
		producto.setStock(p.getStockProducto());	
		
		repository.save(producto);
	}

	@Override
	public void eliminarProducto(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public void editarProducto(ProductosRequestDTO p) {
		// TODO Auto-generated method stub
		Productos producto = new Productos();
		
		producto.setIdProducto(p.getIdProducto());
		producto.setProducto(p.getNombreProducto());
		producto.setDescripcion(p.getDescripcionProducto());
		producto.setPrecio(p.getPrecioProducto());
		producto.setStock(p.getStockProducto());
		
	}

	@Override
	public List<ProductoResponseDTO> listarProducto() {
		// TODO Auto-generated method stub
		List<Productos> producto = repository.findAll();
		
		List<ProductoResponseDTO> dto = new ArrayList<ProductoResponseDTO>();
		ProductoResponseDTO productoDto = null;
		
		for (Productos productos : producto) {
			productoDto = new ProductoResponseDTO();
			
			productoDto.setIdProducto(productos.getIdProducto());
			productoDto.setNombreProducto(productos.getProducto());
			productoDto.setDescripcionProducto(productos.getDescripcion());
			productoDto.setPrecioProducto(productos.getPrecio());
			productoDto.setStockProducto(productos.getStock());
			
			dto.add(productoDto);
		}
		return dto;
	}

	@Override
	public ProductoResponseDTO productoById(Integer id) {
		// TODO Auto-generated method stub
		Productos producto = repository.findById(id).orElse(null);
		ProductoResponseDTO productoDto = new ProductoResponseDTO();
		
		productoDto = new ProductoResponseDTO();	
		productoDto.setIdProducto(producto.getIdProducto());
		productoDto.setNombreProducto(producto.getProducto());
		productoDto.setDescripcionProducto(producto.getDescripcion());
		productoDto.setPrecioProducto(producto.getPrecio());
		productoDto.setStockProducto(producto.getStock());
		
		return productoDto;
	}

}
