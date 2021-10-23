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
    codigo: '1',
    nome: 'Departamento Acadêmico de Letras',
    sigla:'DAL'
  },
  {
    codigo: '2',
    nome: 'Departamento Metal Mecânica',
    sigla:'DMM'
  }]

  constructor() { }

  ngOnInit(): void {
  }

}
