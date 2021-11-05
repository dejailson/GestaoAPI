import { DialogAlertaMensagemComponent } from './../dialog-alerta-mensagem/dialog-alerta-mensagem.component';
import { MatDialog } from '@angular/material/dialog';
import { DepartamentosService } from './../servico/departamentos.service';
import { Departamento } from './../modelo/departamento.interface';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-tela-dados',
  templateUrl: './tela-dados.component.html',
  styleUrls: ['./tela-dados.component.css']
})
export class TelaDadosComponent implements OnInit {

  nomesColunas: String[]=['codigo','nome', 'sigla','acoes']

  departamentos: Departamento[]=[]

  constructor(private servico: DepartamentosService,
              public caixaMensagem: MatDialog) { }

  ngOnInit(): void {
    this.carregarDados()
  }

  excluir(codigo: string){
    this.caixaMensagem.open(DialogAlertaMensagemComponent)
    .afterClosed().subscribe(
      excluir =>{
        if (excluir){
          this.servico.excluir(codigo)
            .subscribe(
              () => this.carregarDados()
          )
        }
      }
    )
  }

  private carregarDados(): void{
    this.servico.listar()
      .subscribe(
        data => this.departamentos = data
    )
  }
}
