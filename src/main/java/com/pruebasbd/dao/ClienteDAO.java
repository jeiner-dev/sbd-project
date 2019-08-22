package com.pruebasbd.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.pruebasbd.model.Cliente;
import com.pruebasbd.model.JPAUtil;

public class ClienteDAO {
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	
	public void guardar(Cliente cliente){
		entity.getTransaction().begin();
		entity.persist(cliente);
		entity.getTransaction().commit();
		//JPAUtil.killConection();
	}

	public void modificar(Cliente cliente){
		entity.getTransaction().begin();
		entity.merge(cliente);
		entity.getTransaction().commit();
		//JPAUtil.killConection();
	}
	
	public Cliente obtener(Long id) {
		Cliente cliente = new Cliente();
		cliente=entity.find(Cliente.class, id);
		//JPAUtil.killConection();
		return cliente;
	}
	
	public List<Cliente> obtenerClientes(){
		List<Cliente> listaClientes = new ArrayList<>();
		Query query = entity.createQuery("select c from Cliente c");
		listaClientes = query.getResultList();
		return listaClientes;
	}
	
	public void eliminar(Long id) {
		Cliente cliente = new Cliente();
		cliente=entity.find(Cliente.class, id);
		entity.getTransaction().begin();
		entity.remove(cliente);
		entity.getTransaction().commit();
	}
	
	
	
	
}
