package dev.StockControl.AppControleEstoque.Produtos;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("/criar")
    public ProdutoModel produtoModel (@RequestBody ProdutoModel produtoModel) {
        return produtoService.novoProduto(produtoModel);
    }

    @GetMapping("/listar")
    public List<ProdutoModel> listarProdutos () {
        return produtoService.verProdutos();
    }

    @GetMapping("/listar/{id}")
    public ProdutoModel produtoModel(@PathVariable Long id) {
        return produtoService.verProdutoPorID(id);
    }

    @PutMapping("/alterar/{id}")
    public ProdutoModel produtoModel (@PathVariable Long id, @RequestBody ProdutoModel produtoAlterar) {
        return produtoService.alterarProduto(id,produtoAlterar);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarProduto (@PathVariable Long id) {
        produtoService.deletarProduto(id);
    }


}
