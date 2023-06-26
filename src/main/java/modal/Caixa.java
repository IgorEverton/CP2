package modal;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="tb_caixa")
public class Caixa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private double saldo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_banco")
	private Banco banco;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name= "tb_cliente_caixa",
	joinColumns = @JoinColumn(name="caixa_id"),
	inverseJoinColumns = @JoinColumn(name="cliente_id"))
	private Set<Cliente> clientes = new HashSet<Cliente>();
	
	public void Coletar(double valor) {
		saldo = saldo + valor;
	}

	public Caixa() {
		
	}
	
	public Caixa(Long id, String nome, double saldo, Banco banco) {
		super();
		this.id = id;
		this.nome = nome;
		this.saldo = saldo;
		this.banco = banco;
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

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}
	
	
	
}
