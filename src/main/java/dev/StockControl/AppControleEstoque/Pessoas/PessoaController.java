package dev.StockControl.AppControleEstoque.Pessoas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    private PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    // C
    @PostMapping("/criar")
    public PessoaModel criarPessoas (@RequestBody PessoaModel pessoaModel) {
        return pessoaService.criarPessoa(pessoaModel);
    }

    //R
    @GetMapping("/listar")
    public List<PessoaModel> listaPessoas () {
        return pessoaService.listaDePessoas();
    }

    //R
    @GetMapping("/listar/{id}")
    public PessoaModel pessoaPorId (@PathVariable Long id) {
        return pessoaService.listarPessoaPorID(id);
    }

    //U
    @PutMapping("/atualizar/{id}")
    public PessoaModel atualizarPessoas (@PathVariable Long id, @RequestBody PessoaModel alterarPessoa) {
        return pessoaService.alterarPessoa(id,alterarPessoa);
    }


    //D
    @DeleteMapping("/deletar/{id}")
    public void deletarPessoas (@PathVariable Long id) {

        pessoaService.deletarPessoa(id);
    }

}
