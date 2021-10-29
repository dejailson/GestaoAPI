import { DepartamentosService } from './../servico/departamentos.service';
import { Departamento } from './../modelo/departamento.interface';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

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

  constructor(private servico: DepartamentosService) { }

  ngOnInit(): void {

  }
   salvar(form:NgForm){
     if(form.valid){
      this.servico.salvar(this.departamento)
      .subscribe(
        data => console.log(data),
        error => console.log('error')
      )
      //.unsubscribe();
     }
   }

}
