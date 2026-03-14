package dev.StockControl.AppControleEstoque.Produtos.service;

import dev.StockControl.AppControleEstoque.Produtos.dto.ProdutoDTO;
import dev.StockControl.AppControleEstoque.Produtos.mapper.ProdutoMapper;
import dev.StockControl.AppControleEstoque.Produtos.model.ProdutoModel;
import dev.StockControl.AppControleEstoque.Produtos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;
    private ProdutoMapper produtoMapper;

    public ProdutoService(ProdutoMapper produtoMapper, ProdutoRepository produtoRepository) {
        this.produtoMapper = produtoMapper;
        this.produtoRepository = produtoRepository;
    }

    //adicionar um produto - C
    public ProdutoDTO novoProduto (ProdutoDTO produtoDTO) {
        ProdutoModel produtoModel = produtoMapper.mapToModel(produtoDTO);

        produtoRepository.save(produtoModel);
        return produtoDTO;
    }

    //ver produtos - R
    public List<ProdutoDTO> verProdutos () {
        List <ProdutoModel> produtoModels = produtoRepository.findAll();

        List<ProdutoDTO> produtoDTOS = new ArrayList<>();

        for (ProdutoModel cadaProduto: produtoModels) {
            produtoDTOS.add(produtoMapper.mapToDto(cadaProduto));
        }

        return produtoDTOS;
    }

    //ver produtos por ID - R
    public ProdutoDTO verProdutoPorID (Long id) {
       // Optional<ProdutoModel> produtoModel = produtoRepository.findById(id);
       // return produtoModel.orElseThrow(() -> new RuntimeException("Este ID de produto não existe"));

        Optional<ProdutoModel> produtoModel = produtoRepository.findById(id);
        return produtoMapper.mapToDto(produtoModel.orElseThrow(() -> new RuntimeException("Este ID do produto não existe")));
    }

    //alterar produtos
    public ProdutoDTO alterarProduto(Long id,ProdutoDTO produtoNovo) {
       ProdutoModel produtoPraMudar = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Este ID de produto não existe"));

       produtoPraMudar.setNome(produtoNovo.getNome());
       produtoPraMudar.setValor(produtoNovo.getValor());
       produtoPraMudar.setQuantidade(produtoNovo.getQuantidade());

       produtoRepository.save(produtoPraMudar);

       return produtoMapper.mapToDto(produtoPraMudar);
    }

    //deletar produtos
    public void deletarProduto (Long id) {
        ProdutoModel produtoDeletar = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("ID não encontrado,impossivel deletar."));


        produtoRepository.delete(produtoDeletar);
    }

}
