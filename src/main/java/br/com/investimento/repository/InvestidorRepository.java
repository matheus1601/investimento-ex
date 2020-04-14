package br.com.investimento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.investimento.model.InvestidorModel;

@Repository
public interface InvestidorRepository extends JpaRepository<InvestidorModel, Integer>{

	InvestidorModel findByEmail(String email);
}
