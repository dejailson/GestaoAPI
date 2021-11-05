import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Component, Inject, OnInit } from '@angular/core';

@Component({
  selector: 'app-dialog-erro-mensagem',
  templateUrl: './dialog-erro-mensagem.component.html',
  styleUrls: ['./dialog-erro-mensagem.component.css']
})
export class DialogErroMensagemComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<DialogErroMensagemComponent>,
    @Inject(MAT_DIALOG_DATA) public data: {mensagem: string}) { }

  ngOnInit(): void {
    console.log(this.data.mensagem)
  }

}
