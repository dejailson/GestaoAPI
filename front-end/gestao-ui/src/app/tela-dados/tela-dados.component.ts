import { DepartamentosService } from './../servico/departamentos.service';
import { Departamento } from './../modelo/departamento.interface';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-tela-dados',
  templateUrl: './tela-dados.component.html',
  styleUrls: ['./tela-dados.component.css']
})
export class TelaDadosComponent implements OnInit {

  nomesColunas: String[]=['codigo','nome', 'sigla']

  departamentos: Departamento[]=[{
    codigo: '',
    nome: '',
    sigla:''
  }]

  constructor(private servico: DepartamentosService) { }

  ngOnInit(): void {
    this.servico.listar()
      .subscribe(
        data => this.departamentos = data,
        error => console.log('ERROR'),
        () => console.log('Concluído')
      )
  }

}
