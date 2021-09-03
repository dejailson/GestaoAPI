package br.ma.slz.ifma.gestaoapi.repositorio;
import java.util.List;

import br.ma.slz.ifma.gestaoapi.modelo.Departamento;

public interface IDepartamentoRepositorio {
    
    public List<Departamento> listar();
    public Departamento pesquisarPorCodigo(String codigo);
    public Departamento salvar(Departamento departamento);
    public Departamento atualizar(Departamento departamento);
    public void excluir(Departamento departamento);
    
}
