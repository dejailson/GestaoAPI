import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-dialog-alerta-mensagem',
  templateUrl: './dialog-alerta-mensagem.component.html',
  styleUrls: ['./dialog-alerta-mensagem.component.css']
})
export class DialogAlertaMensagemComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<DialogAlertaMensagemComponent>
  ) { }

  ngOnInit(): void {
  }
  confirmar(){
    this.dialogRef.close(true)
  }
  cancelar(){
    this.dialogRef.close(false)
  }

}
