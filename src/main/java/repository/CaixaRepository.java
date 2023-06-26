package repository;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import modal.Caixa;

public class CaixaRepository {

	private EntityManager entityManager;
	
	public List<Caixa> listarTodosCaixas(){
		String jpql = "SELECT c FROM Caixa c";
		Query query = entityManager.createQuery(jpql, Caixa.class);
		List<Caixa> caixas =query.getResultList();
		return caixas;
	}
	
	public void inserirCaixa(Caixa caixa) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(caixa);
			entityManager.getTransaction().commit();
			
		}catch(Exception e) {
			entityManager.getTransaction().rollback();
			e.getMessage();
		}
	}
	
	public Caixa listarCaixaPorId(Long id) {
		Caixa caixa = entityManager.find(Caixa.class, id);
		if(caixa == null) {
			return null;
		}
		return caixa;
	}
	
	public void atualizarCaixa(Caixa caixa) {
		try {
			entityManager.getTransaction().rollback();
			entityManager.merge(caixa);
			entityManager.getTransaction().commit();
		}catch(Exception e) {
			entityManager.getTransaction().rollback();
			e.getMessage();
		}
	}
	
	public void deletarCaixa(Long id) {
		Caixa caixa = listarCaixaPorId(id);
		entityManager.getTransaction().begin();
		try {
			if(caixa!=null) {
				entityManager.remove(caixa);
			}
			entityManager.getTransaction().commit();
		}catch(Exception e) {
			entityManager.getTransaction().rollback();
			e.getMessage();
		}
	}
	
}
