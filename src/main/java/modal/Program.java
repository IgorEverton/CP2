package modal;

import java.util.List;

import repository.BancoRepository;
import repository.ClienteRepository;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Banco banco = new Banco();
	banco.setId(null);
	banco.setLocation("AV vasco");
	banco.setNome("itau da potaria");
		
	Banco banco1 = new Banco();
	banco1.setId(null);
	banco1.setLocation("Sabia");
	banco1.setNome("Bradesco lgvbtqiea");
	
	Banco banco2 = new Banco();
	banco2.setId(null);
	banco2.setLocation("Lins de Vasconcelos");
	banco2.setNome("Igor Evernton Infinity");
	
	Cliente cliente =  new Cliente();
	cliente.setId(null);
	cliente.setBanco(banco1);
	cliente.setEndereco("Av bolinha");
	cliente.setNome("Romilson");
	cliente.setNumero("2324");
	cliente.setTelefone("+55919291029");
	
	BancoRepository bancoRepository = new BancoRepository(JPAUtil.getEntityManager());
	
	bancoRepository.inserirBanco(banco);
	bancoRepository.inserirBanco(banco1);
	bancoRepository.inserirBanco(banco2);
	
	//List<Banco> bancos = bancoRepository.listarTodosOsBancos();
	
	/*bancos.stream()
    .forEach(b -> {
        System.out.println("Nome: " + b.getId());
        System.out.println("CNPJ: " + b.getNome());
        System.out.println("Endereço: " + b.getLocation());

        System.out.println("------------------");
    });*/
	
	Banco bancoTeste = bancoRepository.listarBancoPorId(3L);
	
	Cliente cliente1 =  new Cliente();
	cliente1.setId(null);
	cliente1.setBanco(bancoTeste);
	cliente1.setEndereco("Rua pavao");
	cliente1.setNome("Rogerinho");
	cliente1.setNumero("2434");
	cliente1.setTelefone("+555198691029");
	
	ClienteRepository clienteRepository = new ClienteRepository(JPAUtil.getEntityManager());
	clienteRepository.inserirCliente(cliente);
	clienteRepository.inserirCliente(cliente1);
	
	
	
	Cliente c = clienteRepository.listarClientePorId(2L);
	System.out.println("Nome: " + c.getNome());
	System.out.println("ID: " + c.getId());
	System.out.println("Endereço: " + c.getEndereco());
	System.out.println("Banco: " + c.getBanco().getNome());
	
/*	List<Cliente> clientes = clienteRepository.listarTodosOsClientes();
	clientes.stream().forEach(c->{
		System.out.println("Nome: " + c.getNome());
		System.out.println("ID: " + c.getId());
		System.out.println("Endereço: " + c.getEndereco());
		System.out.println("Banco: " + c.getBanco().getNome());
		System.out.println("");
	});
*/	
	}
	
	
/*	System.out.println(bancoTeste.getNome());
	bancoTeste.setNome("X willian");
	bancoRepository.atualizarBanco(bancoTeste);
	Banco bancoTeste1 = bancoRepository.listarBancoPorId(3L);
	System.out.println(bancoTeste1.getNome());
	bancoRepository.deletarBanco(4l);
*/
	}
	


