package repository;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import modal.Cliente;

public class ClienteRepository {
	
	private EntityManager entityManager;

	public ClienteRepository(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	public List<Cliente> listarTodosOsClientes(){
		String jpql = "SELECT c FROM Cliente c";
		Query query = entityManager.createQuery(jpql,Cliente.class);
		List<Cliente> clientes = query.getResultList();
		return clientes;
		
	}
	
	public void inserirCliente(Cliente cliente) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(cliente);
			entityManager.getTransaction().commit();
		}catch(Exception e) {
			entityManager.getTransaction().rollback();
			e.getMessage();
		}
	}
	
	public Cliente listarClientePorId(Long id) {
		Cliente cliente = entityManager.find(Cliente.class, id);
		if(cliente == null) {
			return null;
		}
		return cliente;
	}
	
	public void atualizarCliente(Cliente cliente) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(cliente);
			entityManager.getTransaction().commit();
			
		}catch(Exception e) {
			entityManager.getTransaction().rollback();
			e.getMessage();
		}
	}
	
	public void deletarCliente(Long id) {
		Cliente cliente = listarClientePorId(id);
		entityManager.getTransaction().begin();
		try {
			if(cliente!=null) {
				entityManager.remove(cliente);
			}
			entityManager.getTransaction().commit();
		}catch(Exception e) {
			entityManager.getTransaction().rollback();
			e.getMessage();
		}
	}
	
	
}
