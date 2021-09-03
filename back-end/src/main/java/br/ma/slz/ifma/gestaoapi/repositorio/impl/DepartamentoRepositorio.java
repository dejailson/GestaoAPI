package br.ma.slz.ifma.gestaoapi.repositorio.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.ma.edu.ifma.ita.siged.excecao.CampoDuplicadoException;
import br.ma.edu.ifma.ita.siged.excecao.DepartamentoNaoExisteException;
import br.ma.edu.ifma.ita.siged.servico.DepartamentoServico;
import br.ma.edu.ifma.ita.siged.servico.dto.DepartamentoDTO;
import br.ma.slz.ifma.gestaoapi.modelo.Departamento;
import br.ma.slz.ifma.gestaoapi.repositorio.IDepartamentoRepositorio;
import br.ma.slz.ifma.gestaoapi.util.ConversorDeObjeto;

@Repository
public class DepartamentoRepositorio implements IDepartamentoRepositorio {
    //Dependência 
    private DepartamentoServico servico;

    @Autowired
    public DepartamentoRepositorio(DepartamentoServico servico){
        this.servico = servico;
    }

    public List<Departamento> listar(){
        var dtos = this.servico.listar();

        return ConversorDeObjeto.listaDepartamentos(dtos);
    }

    public Departamento pesquisarPorCodigo(String codigo) throws DepartamentoNaoExisteException{
        
        var dto = this.servico.pesquisarPorCodigo(codigo);
        
        return ConversorDeObjeto.paraDepartamentoModelo(dto);
    }
    public Departamento salvar(Departamento departamento) throws CampoDuplicadoException{
        
        var dto = ConversorDeObjeto.paraDepartamentoDTO(departamento);

        return ConversorDeObjeto.paraDepartamentoModelo(this.servico.salvar(dto));
    }
    public Departamento atualizar(Departamento departamento)throws DepartamentoNaoExisteException, CampoDuplicadoException{
        
        var depAtual = this.servico.pesquisarPorCodigo(departamento.getCodigo());

        var dto = ConversorDeObjeto.paraDepartamentoDTO(departamento, depAtual.getId());

        
        return ConversorDeObjeto.paraDepartamentoModelo(this.servico.atualizar(dto));
    }
    public void excluir(Departamento departamento){
        var dto = ConversorDeObjeto.paraDepartamentoDTO(departamento);

        this.servico.remover(dto);
    }
}
