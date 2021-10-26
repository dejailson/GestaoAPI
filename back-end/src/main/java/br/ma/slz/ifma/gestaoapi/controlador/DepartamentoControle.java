package br.ma.slz.ifma.gestaoapi.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ma.edu.ifma.ita.siged.excecao.CampoDuplicadoException;
import br.ma.edu.ifma.ita.siged.excecao.DepartamentoNaoExisteException;
import br.ma.slz.ifma.gestaoapi.modelo.Departamento;
import br.ma.slz.ifma.gestaoapi.repositorio.IDepartamentoRepositorio;

//http://locahost:8080/departamentos/1/funcionario
//gestao.recurso.api DNS
/*
Definir o acesso apenas ao recurso /departamentos
@CrossOrigin(originPatterns = {"http://localhost:4200","www.g1.com"},
    methods = {
        RequestMethod.DELETE,
        RequestMethod.GET,
        RequestMethod.HEAD,
        RequestMethod.OPTIONS,
        RequestMethod.PATCH,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.TRACE
    })
**/    
@RestController
@RequestMapping(path = "/departamentos", consumes = {MediaType.APPLICATION_JSON_VALUE})
public class DepartamentoControle {

    @Autowired
    private IDepartamentoRepositorio repositorio;
    
    /*
    Definir ao acesso apenas ao VERBO GET do recurso /departamentos
    @CrossOrigin(origins = {"http://localhost:4200","www.g1.com"})
    */
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Departamento>> listar(){
        /*var depInformatica = new Departamento("12212",
            "Departamento Acadêmico de Informática","DAI");

        var depFisica = new Departamento("12213",
            "Departamento Acadêmico de Física","DAF");

        var departamentos = List.of(depInformatica,depFisica);*/

        var departamentos = this.repositorio.listar();

        return ResponseEntity.ok().body(departamentos);
    }
    //http:localhost:8080/departamentos/10
    @GetMapping(path = "/{codigo}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> pesquisarPorCodigo(@PathVariable("codigo") String codigo){
        //var erro = "2";

        try{
            var departamento = repositorio.pesquisarPorCodigo(codigo);
            return ResponseEntity.ok().body(departamento);
        }catch(DepartamentoNaoExisteException erro){
            return ResponseEntity.badRequest().body(erro.getMessage());
        }
        /*var depFisica = new Departamento("12213",
            "Departamento Acadêmico de Física","DAF");
            if(erro.equals(codigo)){
                var msg = "Não existe departamento de código "
                .concat(codigo);
                return ResponseEntity.badRequest().body(msg);
            }*/
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> salvar(@RequestBody Departamento departamento){
        
        try{
            var dep = this.repositorio.salvar(departamento);
            return ResponseEntity.status(HttpStatus.CREATED).body(dep);
        }catch(CampoDuplicadoException erro){
            return ResponseEntity.badRequest().body(erro.getMessage());
        }
    }

    @PutMapping(path = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE}) 
    public ResponseEntity<?> atualizar(@PathVariable("codigo") String codigo,
        @RequestBody Departamento departamento){
            
        try{
            departamento.setCodigo(codigo);
            var dep = repositorio.atualizar(departamento);
            return ResponseEntity.ok().body(dep);
        }catch(DepartamentoNaoExisteException | CampoDuplicadoException erro){
            return ResponseEntity.badRequest().body(erro.getMessage());
        }    
        
    }

    @DeleteMapping
    public ResponseEntity<?> excluir(@RequestBody Departamento departamento){

        this.excluirPorCodigo(departamento.getCodigo());
        
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping(path = "/{codigo}") 
    public ResponseEntity<?> excluirPorCodigo (@PathVariable String codigo){
        try{
            var dep = this.repositorio.pesquisarPorCodigo(codigo);
            this.repositorio.excluir(dep);
        }catch(DepartamentoNaoExisteException erro){
            return ResponseEntity.badRequest().body(erro.getMessage());
        }    
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}