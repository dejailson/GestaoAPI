import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BarraMenuComponent } from './barra-menu/barra-menu.component';

import {MatToolbarModule} from '@angular/material/toolbar';
import {MatCardModule} from '@angular/material/card';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatTableModule} from '@angular/material/table';
import { HttpClientModule } from '@angular/common/http';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import {MatDialogModule} from '@angular/material/dialog';

import { TelaDadosComponent } from './tela-dados/tela-dados.component';
import { DepartamentoCadastroComponent } from './departamento-cadastro/departamento-cadastro.component';
import { DialogSucessoMensagemComponent } from './dialog-sucesso-mensagem/dialog-sucesso-mensagem.component';
import { DialogErroMensagemComponent } from './dialog-erro-mensagem/dialog-erro-mensagem.component';
import { DialogAlertaMensagemComponent } from './dialog-alerta-mensagem/dialog-alerta-mensagem.component';
import { EdicaoDepartamentoComponent } from './edicao-departamento/edicao-departamento.component';
import { HomeComponent } from './home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    BarraMenuComponent,
    TelaDadosComponent,
    DepartamentoCadastroComponent,
    DialogSucessoMensagemComponent,
    DialogErroMensagemComponent,
    DialogAlertaMensagemComponent,
    EdicaoDepartamentoComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatCardModule,
    MatButtonModule,
    MatIconModule,
    MatTableModule,
    HttpClientModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    MatDialogModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
