import { HomeComponent } from './home/home.component';
import { DepartamentoCadastroComponent } from './departamento-cadastro/departamento-cadastro.component';
import { TelaDadosComponent } from './tela-dados/tela-dados.component';
import { BarraMenuComponent } from './barra-menu/barra-menu.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EdicaoDepartamentoComponent } from './edicao-departamento/edicao-departamento.component';

const routes: Routes = [
  {path:'',component:HomeComponent, outlet:'menu'},
  {path:'departamentos',component:TelaDadosComponent},
  {path:'departamentos/novo',component:DepartamentoCadastroComponent},
  {path:'departamentos/:codigo',component:EdicaoDepartamentoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
