package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ClienteRequestDTO;
import com.example.demo.DTO.ClienteResponseDTO;
import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Override
	public void guardarCliente(ClienteRequestDTO c) {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente();
		cliente.setIdCliente(c.getIdCliente());
		cliente.setNombre(c.getNombreCliente());
		cliente.setDireccion(c.getDireccionCliente());
		cliente.setDni(c.getDniCliente());
		
		repository.save(cliente);

	}

	@Override
	public void eliminarCliente(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public void editarCliente(ClienteRequestDTO c) {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente();
		
		cliente.setIdCliente(c.getIdCliente());
		cliente.setNombre(c.getNombreCliente());
		cliente.setDni(c.getDniCliente());
		cliente.setDireccion(c.getDireccionCliente());

	}

	@Override
	public List<ClienteResponseDTO> listarCliente() {
		// TODO Auto-generated method stub
		List<Cliente> cliente = repository.findAll();
		
		List<ClienteResponseDTO> dto = new ArrayList<ClienteResponseDTO>();
		ClienteResponseDTO clienteDto = null;
		
		for (Cliente clientes : cliente) {
			clienteDto = new ClienteResponseDTO();
			
			clienteDto.setIdCliente(clientes.getIdCliente());
			clienteDto.setNombreCliente(clientes.getNombre());
			clienteDto.setDireccionCliente(clientes.getDireccion());
			clienteDto.setDniCliente(clientes.getDni());
			
			dto.add(clienteDto);
		}
		return dto;
	}

	@Override
	public ClienteResponseDTO clienteById(Integer id) {
		// TODO Auto-generated method stub
		Cliente cliente = repository.findById(id).orElse(null);
		ClienteResponseDTO clienteDto = new ClienteResponseDTO();
		
		clienteDto = new ClienteResponseDTO();	
		clienteDto.setIdCliente(cliente.getIdCliente());
		clienteDto.setNombreCliente(cliente.getNombre());
		clienteDto.setDniCliente(cliente.getDni());
		clienteDto.setDireccionCliente(cliente.getDireccion());

		return clienteDto;
	}

}
