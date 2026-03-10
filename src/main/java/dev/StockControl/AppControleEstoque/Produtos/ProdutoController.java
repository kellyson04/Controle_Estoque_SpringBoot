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
    public ProdutoDTO criarProdutos (@RequestBody ProdutoDTO produtoDTO) {
        return produtoService.novoProduto(produtoDTO);
    }

    @GetMapping("/listar")
    public List<ProdutoDTO> listarProdutos () {
        return produtoService.verProdutos();
    }

    @GetMapping("/listar/{id}")
    public ProdutoDTO produtoDTO(@PathVariable Long id) {
        return produtoService.verProdutoPorID(id);
    }

    @PutMapping("/alterar/{id}")
    public ProdutoDTO produtoDTO (@PathVariable Long id, @RequestBody ProdutoDTO produtoAlterar) {
        return produtoService.alterarProduto(id,produtoAlterar);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarProduto (@PathVariable Long id) {
        produtoService.deletarProduto(id);
    }


}
