import { SudService } from './../../../service/sud.service';
import { Sud } from './../../../models/sud';
import { PredmetService } from './../../../service/predmet.service';
import { Predmet } from './../../../models/predmet';
import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-predmet-dialog',
  templateUrl: './predmet-dialog.component.html',
  styleUrls: ['./predmet-dialog.component.css']
})
export class PredmetDialogComponent implements OnInit {
  flag!: number;
  sudovi!: Sud[];

  constructor(public snackBar: MatSnackBar,
    public dialogRef: MatDialogRef<Predmet>,
    @Inject(MAT_DIALOG_DATA) public data: Predmet,
    public predmetService: PredmetService,
    public sudService: SudService){
}
  ngOnInit(): void {
    this.sudService.getAllSud().subscribe(
      data => {
        this.sudovi = data;
      }
    )
  }

public compare(a: any, b:any){
  return a.id == b.id;
}

public add():void{
  this.predmetService.addPredmet(this.data).subscribe(
    () => {
      this.snackBar.open('Predmet sa imenom: ' + this.data.brojPr + ' je uspesno kreiran',
      'Ok', {duration:3500})
    }
  ),
  (error:Error)=>{console.log(error.name + ' ' + error.message)
  this.snackBar.open('Kreiranje predmeta je neuspesno', 'Ok', {duration:3500})};
}

public update():void{
  this.predmetService.updatePredmet(this.data).subscribe(
    () => {
      this.snackBar.open('Predmet sa ID: ' + this.data.id + ' je uspesno modifikovan',
      'Ok', {duration:3500})
    }
  ),
  (error:Error)=>{console.log(error.name + ' ' + error.message)
  this.snackBar.open('Modifikovanje Predmeta je neuspesno', 'Ok', {duration:3500})};
}

public delete():void{
  this.predmetService.deletePredmet(this.data.id).subscribe(
    () => {
      this.snackBar.open('Predmet je uspesno obrisan',
      'Ok', {duration:3500})
    }
  ),
  (error:Error)=>{console.log(error.name + ' ' + error.message)
  this.snackBar.open('Brisanje predmeta je neuspesno', 'Ok', {duration:3500})};
}


public cancel():void{
  this.dialogRef.close();
  this.snackBar.open('Odustali ste od izmena', 'Ok', {duration:2500});
}
}
