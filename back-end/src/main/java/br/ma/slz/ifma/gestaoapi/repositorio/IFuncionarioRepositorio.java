package br.ma.slz.ifma.gestaoapi.repositorio;

import java.util.List;

import br.ma.edu.ifma.ita.siged.excecao.CampoDuplicadoException;
import br.ma.edu.ifma.ita.siged.excecao.DepartamentoNaoExisteException;
import br.ma.edu.ifma.ita.siged.excecao.FuncionarioNaoExisteException;
import br.ma.slz.ifma.gestaoapi.modelo.Funcionario;

public interface IFuncionarioRepositorio {
    
    public Funcionario salvar(Funcionario funcionario) throws DepartamentoNaoExisteException, CampoDuplicadoException;
    
    public Funcionario atualizar(Funcionario funcionario) throws DepartamentoNaoExisteException, FuncionarioNaoExisteException;
    
    public void excluir(String codigo) throws FuncionarioNaoExisteException;

    public List<Funcionario> listar();
    
    public Funcionario pesquisarPorCodigo(String codigo) throws FuncionarioNaoExisteException;
}