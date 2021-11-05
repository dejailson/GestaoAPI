import { DialogErroMensagemComponent } from './../dialog-erro-mensagem/dialog-erro-mensagem.component';
import { DialogSucessoMensagemComponent } from './../dialog-sucesso-mensagem/dialog-sucesso-mensagem.component';
import { MatDialog } from '@angular/material/dialog';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Departamento } from './../modelo/departamento.interface';
import { DepartamentosService } from './../servico/departamentos.service';

@Component({
  selector: 'app-departamento-cadastro',
  templateUrl: './departamento-cadastro.component.html',
  styleUrls: ['./departamento-cadastro.component.css']
})
export class DepartamentoCadastroComponent implements OnInit {

  departamento: Departamento = {
    nome: null,
    codigo: null,
    sigla: null
  }

  constructor(
    private servico: DepartamentosService,
    public caixa: MatDialog
    ) { }

  ngOnInit(): void {
  }
   salvar(form:NgForm){
     if(form.valid){
      this.servico.salvar(this.departamento)
      .subscribe(
        data => {
          this.caixa.open(DialogSucessoMensagemComponent)
          .afterClosed().subscribe(
            () => form.resetForm()
          )
        },
        error => {
          this.caixa.open(DialogErroMensagemComponent,{
            data:{mensagem:error.error}
          })
        }
      )
      //.unsubscribe();
     }
   }

}
