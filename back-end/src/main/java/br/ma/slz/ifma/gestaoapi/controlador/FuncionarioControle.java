package br.ma.slz.ifma.gestaoapi.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ma.edu.ifma.ita.siged.excecao.CampoDuplicadoException;
import br.ma.edu.ifma.ita.siged.excecao.DepartamentoNaoExisteException;
import br.ma.edu.ifma.ita.siged.excecao.FuncionarioNaoExisteException;
import br.ma.slz.ifma.gestaoapi.modelo.Funcionario;
import br.ma.slz.ifma.gestaoapi.repositorio.IFuncionarioRepositorio;

@RestController
@RequestMapping(path = "/funcionarios",consumes = {MediaType.APPLICATION_JSON_VALUE})
public class FuncionarioControle {

    @Autowired
    private IFuncionarioRepositorio repositorio;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Funcionario>> listar(){
        var funcionarios = this.repositorio.listar();
        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping(path = "/{codigo}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> pesquisar(@PathVariable("codigo") String codigo){
        
        try{
            var func = this.repositorio.pesquisarPorCodigo(codigo);
            return ResponseEntity.ok().body(func);
        }catch(FuncionarioNaoExisteException erro){
            return ResponseEntity.badRequest().body(erro.getMessage());
        }
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> salvar(@RequestBody Funcionario funcionario){
        try{
            var func = this.repositorio.salvar(funcionario);
            return ResponseEntity.status(HttpStatus.CREATED).body(func);
        }catch(DepartamentoNaoExisteException | CampoDuplicadoException erro){
            return ResponseEntity.badRequest().body(erro.getMessage());
        }
    }

    @PutMapping(path = "/{codigo}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> atualizar(@PathVariable("codigo") String codigo, @RequestBody Funcionario funcionario){
        
        try{
            funcionario.setCodigo(codigo);
            var func = this.repositorio.atualizar(funcionario);
            return ResponseEntity.ok().body(func);
        }catch(DepartamentoNaoExisteException | FuncionarioNaoExisteException erro){
            return ResponseEntity.badRequest().body(erro.getMessage());
        }
    }

    @DeleteMapping(path = "/{codigo}")
    public ResponseEntity<?> excluir(@PathVariable("codigo") String codigo){

        try{
            this.repositorio.excluir(codigo);
            return ResponseEntity.noContent().build();

        }catch(FuncionarioNaoExisteException erro){
            return ResponseEntity.badRequest().body(erro.getMessage());
        }
    }   
}