package br.ma.slz.ifma.gestaoapi.modelo;

public class Funcionario {
    private String codigo;
    private String nome;
    private String rg;
    private String cpf;
    private Departamento departamento;

    public Funcionario(String codigo, String nome, String rg, String cpf, Departamento departamento) {
        this.codigo = codigo;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.departamento = departamento;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getRg() {
        return rg;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public Departamento getDepartamento() {
        return departamento;
    }
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
