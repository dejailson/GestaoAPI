import { Departamento } from './../modelo/departamento.interface';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DepartamentosService {

  URI_BASE='http://gestao.recurso.api:8080'
  recurso = 'departamentos'

  constructor(private http: HttpClient) { }

  public listar(): Observable<Departamento[]>{
    let dep: Departamento[] = [];
    return this.http.get<Departamento[]>(`${this.URI_BASE}/${this.recurso}`,
      {headers:this.getHeaders()}
    );
  }

  private getHeaders(): HttpHeaders{
    const cabecalho = new HttpHeaders().
      append('Content-Type', 'application/json').
      append('Accept','application/json');
    return cabecalho;
  }
}
