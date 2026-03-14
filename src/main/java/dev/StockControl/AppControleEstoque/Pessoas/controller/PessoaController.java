package dev.StockControl.AppControleEstoque.Pessoas.controller;

import dev.StockControl.AppControleEstoque.Pessoas.dto.PessoaDTO;
import dev.StockControl.AppControleEstoque.Pessoas.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarPessoas (@RequestBody PessoaDTO novaPessoa) {
         pessoaService.criarPessoa(novaPessoa);
         return ResponseEntity.status(HttpStatus.CREATED).body("Usuario criado com sucesso!");
    }

    //R
    @GetMapping("/listar")
    public ResponseEntity <List<PessoaDTO>> listaPessoas () {

        List<PessoaDTO> listaPessoas = pessoaService.listaDePessoas();

        return ResponseEntity.ok(listaPessoas);
    }

    //R
    @GetMapping("/listar/{id}")
    public ResponseEntity<PessoaDTO> pessoaPorId (@PathVariable Long id) {

        PessoaDTO listarPessoa = pessoaService.listarPessoaPorID(id);

        return ResponseEntity.ok(listarPessoa);
    }

    //U
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarPessoas (@PathVariable Long id, @RequestBody PessoaDTO alterarPessoa) {

        pessoaService.alterarPessoa(id,alterarPessoa);

        return ResponseEntity.status(HttpStatus.FOUND).body("Usuario atualizado com sucesso!");
    }


    //D
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarPessoas (@PathVariable Long id) {

        pessoaService.deletarPessoa(id);

        return ResponseEntity.ok("Usuario deletado com sucesso!");
    }

}
