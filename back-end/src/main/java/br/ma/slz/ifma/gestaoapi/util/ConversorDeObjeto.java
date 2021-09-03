package br.ma.slz.ifma.gestaoapi.util;

import java.util.List;
import java.util.stream.Collectors;

import br.ma.edu.ifma.ita.siged.servico.dto.DepartamentoDTO;
import br.ma.edu.ifma.ita.siged.servico.dto.FuncionarioDTO;
import br.ma.slz.ifma.gestaoapi.modelo.Departamento;
import br.ma.slz.ifma.gestaoapi.modelo.Funcionario;

public class ConversorDeObjeto {

    public static Departamento paraDepartamentoModelo(DepartamentoDTO dto){
        var departamento = new Departamento(dto.getCodigo(),dto.getNome(),dto.getSigla());
        return departamento;
    }

    public static Funcionario paraFuncionarioModelo(FuncionarioDTO dto){
        var departamento = paraDepartamentoModelo(dto.getDepartamento());
        var funcionario = new Funcionario(dto.getCodigo(),dto.getNome(),dto.getRg(),dto.getCpf(),departamento);
        return funcionario;
    }

    public static DepartamentoDTO paraDepartamentoDTO(Departamento departamento){
        //Padrão de projeto Builder
        var dto = DepartamentoDTO.builder()
            .codigo(departamento.getCodigo())
            .nome(departamento.getNome())
            .sigla(departamento.getSigla())
            .build();
        return dto;
    }


    public static DepartamentoDTO paraDepartamentoDTO(Departamento departamento,String id){
        //Padrão de projeto Builder
        var dto = paraDepartamentoDTO(departamento);
        dto.setId(id);
        return dto;
    }

    public static FuncionarioDTO paraFuncionarioDTO(Funcionario funcionario, DepartamentoDTO deDto){
        var dto= FuncionarioDTO.builder()
            .codigo(funcionario.getCodigo())
            .cpf(funcionario.getCpf())
            .nome(funcionario.getNome())
            .rg(funcionario.getRg())
            .departamento(deDto)
            .build();
        return dto;
    }

    public static FuncionarioDTO paraFuncionarioDTO(Funcionario funcionario, DepartamentoDTO deDto,String id){
        var dto = paraFuncionarioDTO(funcionario, deDto);
        dto.setId(id);
        return dto;
    }

    public static List<Departamento> listaDepartamentos(List<DepartamentoDTO> dtos){
        /*List<Departamento> departamentos = new ArrayList<Departamento>();
        for(int pos =0;pos<dtos.size();pos++){
            var departamento = paraModelo(dtos.get(pos));
            departamentos.add(departamento);
        }*/
        //Programação Funcional
        var departamentos = dtos.stream().map(dto -> paraDepartamentoModelo(dto)).collect(Collectors.toList());
        return departamentos;
    }

    public static List<Funcionario> listaFuncionarios(List<FuncionarioDTO> dtos){
        var funcionarios = dtos.stream().map(dto -> paraFuncionarioModelo(dto)).collect(Collectors.toList());
        return funcionarios;
    }
    
}
