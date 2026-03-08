package dev.StockControl.AppControleEstoque.Produtos;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    //adicionar um produto - C
    public ProdutoModel novoProduto (ProdutoModel produtoModel) {
        produtoRepository.save(produtoModel);
        return produtoModel;
    }

    //ver produtos - R
    public List<ProdutoModel> verProdutos () {
        return produtoRepository.findAll();
    }

    //ver produtos por ID - R
    public ProdutoModel verProdutoPorID (Long id) {
        Optional<ProdutoModel> produtoModel = produtoRepository.findById(id);
        return produtoModel.orElseThrow(() -> new RuntimeException("Este ID de produto não existe"));
    }

    //alterar produtos
    public ProdutoModel alterarProduto(Long id,ProdutoModel produtoNovo) {
       ProdutoModel produtoPraMudar = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Este ID de produto não existe"));

       produtoPraMudar.setNome(produtoNovo.getNome());
       produtoPraMudar.setValor(produtoNovo.getValor());
       produtoPraMudar.setQuantidade(produtoNovo.getQuantidade());

       return produtoRepository.save(produtoPraMudar);
    }

    //deletar produtos
    public void deletarProduto (Long id) {
        ProdutoModel produtoDeletar = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("ID não encontrado,impossivel deletar."));

        produtoRepository.deleteById(id);
    }

}
