package br.com.investimento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.investimento.model.DeclaracaoModel;

@Repository
public interface DeclaracaoRepository extends JpaRepository<DeclaracaoModel, Integer> {
	
	DeclaracaoModel findById(String id);
}
