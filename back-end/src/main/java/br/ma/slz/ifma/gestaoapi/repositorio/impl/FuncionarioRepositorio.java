package br.ma.slz.ifma.gestaoapi.repositorio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.ma.edu.ifma.ita.siged.excecao.CampoDuplicadoException;
import br.ma.edu.ifma.ita.siged.excecao.DepartamentoNaoExisteException;
import br.ma.edu.ifma.ita.siged.excecao.FuncionarioNaoExisteException;
import br.ma.edu.ifma.ita.siged.servico.DepartamentoServico;
import br.ma.edu.ifma.ita.siged.servico.FuncionarioServico;
import br.ma.edu.ifma.ita.siged.util.Parametro;
import br.ma.slz.ifma.gestaoapi.modelo.Funcionario;
import br.ma.slz.ifma.gestaoapi.repositorio.IFuncionarioRepositorio;
import br.ma.slz.ifma.gestaoapi.util.ConversorDeObjeto;

@Repository
public class FuncionarioRepositorio implements IFuncionarioRepositorio{

    private FuncionarioServico funcServico;
    private DepartamentoServico depServico;

    @Autowired
    public FuncionarioRepositorio(FuncionarioServico funcServico, DepartamentoServico depServico) {
        this.funcServico = funcServico;
        this.depServico = depServico;
    }

    @Override
    public Funcionario salvar(Funcionario funcionario) throws DepartamentoNaoExisteException, CampoDuplicadoException {
        var departamentoDTO = this.depServico.pesquisarPorCodigo(funcionario.getDepartamento().getCodigo());
        var funcionatioDTO = ConversorDeObjeto.paraFuncionarioDTO(funcionario, departamentoDTO);
        funcionatioDTO = this.funcServico.salvar(funcionatioDTO);
        return ConversorDeObjeto.paraFuncionarioModelo(funcionatioDTO);
    }

    @Override
    public Funcionario atualizar(Funcionario funcionario) throws DepartamentoNaoExisteException, FuncionarioNaoExisteException {
        var departamentoDTO = this.depServico.pesquisarPorCodigo(funcionario.getDepartamento().getCodigo());
        var funcionarioDTO = this.funcServico.pesquisarPorCodigo(funcionario.getCodigo());
        funcionarioDTO = ConversorDeObjeto.paraFuncionarioDTO(funcionario, departamentoDTO, funcionarioDTO.getId());

        return ConversorDeObjeto.paraFuncionarioModelo(this.funcServico.atualizar(funcionarioDTO));
    }

    @Override
    public void excluir(String codigo) throws FuncionarioNaoExisteException {
        var funcionarioDTO = this.funcServico.pesquisarPorCodigo(codigo);
        this.funcServico.remover(funcionarioDTO);
    }

    @Override
    public List<Funcionario> listar() {
        var parametro = Parametro.construtor().construir();
        var dtos = this.funcServico.listar(parametro);
        return ConversorDeObjeto.listaFuncionarios(dtos);
    }

    @Override
    public Funcionario pesquisarPorCodigo(String codigo) throws FuncionarioNaoExisteException {
        var funcionarioDTO = this.funcServico.pesquisarPorCodigo(codigo);
        return ConversorDeObjeto.paraFuncionarioModelo(funcionarioDTO);
    }
    
}
