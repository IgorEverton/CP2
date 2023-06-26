package modal;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name="tb_banco")
public class Banco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String location;
	
	@OneToMany(mappedBy="banco")
	List<Caixa> caixas = new ArrayList<Caixa>();
	
	@OneToMany(mappedBy="banco")
	List<Cliente> clientes = new ArrayList<Cliente>();
	
	
	public Banco() {
		
	}


	public Banco(Long id, String nome, String location) {
		super();
		this.id = id;
		this.nome = nome;
		this.location = location;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public List<Caixa> getCaixas() {
		return caixas;
	}


	public void setCaixas(List<Caixa> caixas) {
		this.caixas = caixas;
	}


	public List<Cliente> getClientes() {
		return clientes;
	}


	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
}
