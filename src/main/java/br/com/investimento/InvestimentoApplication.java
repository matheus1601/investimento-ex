package br.com.investimento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.investimento.model.InvestidorModel;
import br.com.investimento.model.InvestimentoForaDaPlataformaModel;
import br.com.investimento.repository.InvestidorRepository;

@SpringBootApplication
@RestController
public class InvestimentoApplication {

	@Autowired
	private Gson gson;
	
	@Autowired
	private InvestidorRepository investidorRepository;

	public static void main(String[] args) {
		SpringApplication.run(InvestimentoApplication.class, args);
	}

	@GetMapping("/investidor/{id}")
	public String encontrarUsuario() {
		return "Usuario encontrado";
	}

	@PostMapping("/investidor/novo")
	public String adicionarUsuario() {
		return "Usuario adicionado";
	}

	@DeleteMapping("/investidor/{id}")
	public String deletarUsuario() {
		return "Usuario deletado";
	}

	@PutMapping("/investidor/{id}")
	public String atualizarUsuario() {
		return "Usuario atualizado";
	}

	public InvestidorModel busca(final String email) {
		return investidorRepository.findByEmail(email);
	}

	
	@PostMapping("/investimento-externo/novo/{email}")
	public InvestidorModel adicionaInvestimentoExterno(@RequestBody InvestimentoForaDaPlataformaModel investimento,
			@PathVariable String email) {
		return busca(email);
	}
}
