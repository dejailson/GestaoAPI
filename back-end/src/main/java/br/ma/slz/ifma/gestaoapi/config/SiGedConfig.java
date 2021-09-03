package br.ma.slz.ifma.gestaoapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.ma.edu.ifma.ita.siged.servico.DepartamentoServico;
import br.ma.edu.ifma.ita.siged.servico.FuncionarioServico;

@Configuration
public class SiGedConfig {

    @Bean
    public DepartamentoServico departamentoServico(){
        return new DepartamentoServico();
    }
    
    @Bean
    public FuncionarioServico FuncionarioServico(){
        return new FuncionarioServico();
    }
}
