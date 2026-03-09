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
    public PessoaDTO criarPessoas (@RequestBody PessoaDTO novaPessoa) {
        return pessoaService.criarPessoa(novaPessoa);
    }

    //R
    @GetMapping("/listar")
    public List<PessoaDTO> listaPessoas () {
        return pessoaService.listaDePessoas();
    }

    //R
    @GetMapping("/listar/{id}")
    public PessoaDTO pessoaPorId (@PathVariable Long id) {
        return pessoaService.listarPessoaPorID(id);
    }

    //U
    @PutMapping("/atualizar/{id}")
    public PessoaDTO atualizarPessoas (@PathVariable Long id, @RequestBody PessoaDTO alterarPessoa) {
        return pessoaService.alterarPessoa(id,alterarPessoa);
    }


    //D
    @DeleteMapping("/deletar/{id}")
    public void deletarPessoas (@PathVariable Long id) {

        pessoaService.deletarPessoa(id);
    }

}
