package com.pruebasbd.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.pruebasbd.dao.ClienteDAO;
import com.pruebasbd.model.Cliente;

@ManagedBean(name="clienteBean")
@RequestScoped
public class ClienteBean {	
	
	public String insertar(){
		Cliente cliente = new Cliente();
		Map<String,Object> sessionMap=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente", cliente);
		return "insertar.xhtml";
	}
	
	public String guardar(Cliente cliente) {
		ClienteDAO clienteDao = new ClienteDAO();
		clienteDao.guardar(cliente);
		return "index.xhtml";
	}
	
	public List<Cliente> obtenerClientes(){
		List<Cliente> listaCliente = new ArrayList<>();
		ClienteDAO clienteDao = new ClienteDAO();
		return clienteDao.obtenerClientes();
	}
	
	public String modificar(Long id){
		ClienteDAO clienteDao = new ClienteDAO();
		Cliente cliente = new Cliente();
		cliente = clienteDao.obtener(id);
		System.out.print("cliente :::::::  :::: "+cliente);
		
		Map<String,Object> sessionMap=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente", cliente);
		return "editar.xhtml";
	}
	
	public String actualizar(Cliente cliente) {
		ClienteDAO clienteDao = new ClienteDAO();
		clienteDao.modificar(cliente);
		return "index.xhtml";
	}
	
	public void eliminar(Long id) {
		ClienteDAO clienteDao = new ClienteDAO();
		clienteDao.eliminar(id);
	}
	
}
