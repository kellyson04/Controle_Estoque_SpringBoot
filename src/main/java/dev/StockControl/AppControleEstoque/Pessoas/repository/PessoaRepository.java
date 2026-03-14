package dev.StockControl.AppControleEstoque.Pessoas.repository;

import dev.StockControl.AppControleEstoque.Pessoas.model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel,Long> {
}
