import { Departamento } from './../modelo/departamento.interface';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { take } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class DepartamentosService {

  URI_BASE='http://gestao.recurso.api:8080'
  recurso = 'departamentos'

  constructor(private http: HttpClient) { }

  public listar(): Observable<Departamento[]>{
    //let dep: Departamento[] = []; retirar
    return this.http.get<Departamento[]>(`${this.URI_BASE}/${this.recurso}`,
      {headers:this.getHeaders()}
    )
    .pipe(
      take(1)
    );
  }

  public salvar(departamento: Departamento): Observable<Departamento>{
    return this.http.post<Departamento>(`${this.URI_BASE}/${this.recurso}`,
        departamento,{headers:this.getHeaders()})
        .pipe(
          take(1)
        )
  }

  public excluir(codigo: string): Observable<void>{
    return this.http.delete<void> (`${this.URI_BASE}/${this.recurso}/${codigo}`,
    {headers: this.getHeaders()})
      .pipe(
        take(1)
      )
  }

  public atualizar(departamento: Departamento): Observable<Departamento>{
    return this.http.put<Departamento> (`${this.URI_BASE}/${this.recurso}`,
      departamento,{headers: this.getHeaders()})
      .pipe(
        take(1)
      )
  }

  public pesquisar(codigo: string): Observable<Departamento>{
    return this.http.get<Departamento> (`${this.URI_BASE}/${this.recurso}/${codigo}`,
    {headers: this.getHeaders()})
    .pipe(
      take(1)
    )
      }

  private getHeaders(): HttpHeaders{
    const cabecalho = new HttpHeaders().
      append('Content-Type', 'application/json').
      append('Accept','application/json');
    return cabecalho;
  }
}
