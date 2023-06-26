package repository;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import modal.Banco;

public class BancoRepository {
	private EntityManager entityManager;

	public BancoRepository(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	public List<Banco> listarTodosOsBancos(){
		String jpql= "SELECT b FROM Banco b";
		Query query = entityManager.createQuery(jpql,Banco.class);
	    List<Banco> bancos = query.getResultList();
	    return bancos;
	}
	
	public void inserirBanco(Banco banco) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(banco);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.getMessage();
		}
	}
	
	public Banco listarBancoPorId(Long id) {
	   
	        /*String jpql = "SELECT b FROM Banco b WHERE b.id = :id";
	        TypedQuery<Banco> query = entityManager.createQuery(jpql, Banco.class);
	        query.setParameter("id", id);
	        return query.getSingleResult();
			*/
			
			Banco banco = entityManager.find(Banco.class, id);
			if(banco==null) {
				return null;
			}
			return banco;
			
	}
	
	public void atualizarBanco(Banco banco) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(banco);
			entityManager.getTransaction().commit();
		}catch(Exception e ) {
			entityManager.getTransaction().rollback();
			e.getMessage();
		}
	}
	
	
	public void deletarBanco(Long id) {
		Banco banco=listarBancoPorId(id);
		entityManager.getTransaction().begin();
		try {
			if(banco!=null) {
				entityManager.remove(banco);
			}
			entityManager.getTransaction().commit();
		}catch(Exception e) {
			entityManager.getTransaction().rollback();
			e.getMessage();
		}
	}
	
	
	
}
