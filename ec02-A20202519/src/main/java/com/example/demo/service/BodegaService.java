package com.example.demo.service;

import java.util.List;

import com.example.demo.DTO.BodegaRequestDTO;
import com.example.demo.DTO.BodegaResponseDTO;



public interface BodegaService {

	public void guardarBodega(BodegaRequestDTO b);
	public void eliminarBodega(Integer id);
	public void editarBodega(BodegaRequestDTO b);
	public List<BodegaResponseDTO> listarCliente();
	public BodegaResponseDTO bodegaById(Integer id);
	
}
