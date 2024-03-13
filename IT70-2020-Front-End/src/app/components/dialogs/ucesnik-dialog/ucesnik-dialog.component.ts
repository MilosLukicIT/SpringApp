import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Ucesnik } from 'src/app/models/ucesnik';
import { UcesnikService } from 'src/app/service/ucesnik.service';

@Component({
  selector: 'app-ucesnik-dialog',
  templateUrl: './ucesnik-dialog.component.html',
  styleUrls: ['./ucesnik-dialog.component.css']
})
export class UcesnikDialogComponent {

  flag!: number;

  constructor(public snackBar: MatSnackBar,
    public dialogRef: MatDialogRef<Ucesnik>,
    @Inject(MAT_DIALOG_DATA) public data: Ucesnik,
    public ucesnikService: UcesnikService){
}

public add():void{
  this.ucesnikService.addUcesnik(this.data).subscribe(
    () => {
      this.snackBar.open('Ucesnik sa imenom: ' + this.data.ime + ' je uspesno kreiran',
      'Ok', {duration:3500})
    }
  ),
  (error:Error)=>{console.log(error.name + ' ' + error.message)
  this.snackBar.open('Kreiranje ucesnika je neuspesno', 'Ok', {duration:3500})};
}

public update():void{
  this.ucesnikService.updateUcesnik(this.data).subscribe(
    () => {
      this.snackBar.open('Ucesnik sa ID: ' + this.data.id + ' je uspesno modifikovan',
      'Ok', {duration:3500})
    }
  ),
  (error:Error)=>{console.log(error.name + ' ' + error.message)
  this.snackBar.open('Modifikovanje ucesnika je neuspesno', 'Ok', {duration:3500})};
}

public delete():void{
  this.ucesnikService.deleteUcesnik(this.data.id).subscribe(
    () => {
      this.snackBar.open('Ucesnik je uspesno obrisan',
      'Ok', {duration:3500})
    }
  ),
  (error:Error)=>{console.log(error.name + ' ' + error.message)
  this.snackBar.open('Brisanje ucesnika je neuspesno', 'Ok', {duration:3500})};
}


public cancel():void{
  this.dialogRef.close();
  this.snackBar.open('Odustali ste od izmena', 'Ok', {duration:2500});
}

}
