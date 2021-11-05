import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-edicao-departamento',
  templateUrl: './edicao-departamento.component.html',
  styleUrls: ['./edicao-departamento.component.css']
})
export class EdicaoDepartamentoComponent implements OnInit {
  codigo = null
  constructor(
    private rota: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.rota.params.subscribe(
      (parametro) => this.codigo = parametro['codigo']
    )
  }

}
