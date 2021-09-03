package br.ma.slz.ifma.gestaoapi.modelo;

public class Departamento {

    private String codigo;
    private String nome;
    private String sigla;

    public Departamento(){}

    public Departamento(String codigo, String nome,String sigla){
        this.codigo = codigo;
        this.nome = nome;
        this.sigla = sigla;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public String toString() {
        return "Departamento [codigo=" + codigo + ", nome=" + nome + ", sigla=" + sigla + "]";
    }    
}