package dev.StockControl.AppControleEstoque.Produtos.repository;

import dev.StockControl.AppControleEstoque.Produtos.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel,Long> {
}
