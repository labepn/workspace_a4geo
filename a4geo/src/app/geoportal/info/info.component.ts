import { Component, OnInit } from '@angular/core';

//dialog
import { MAT_DIALOG_DATA, MatDialog, MatDialogConfig, MatDialogRef, MatTableDataSource }  from '@angular/material';
import { Inject } from "@angular/core";
import { ZemljisteService } from '../../nepokretnosti/zemljiste/zemljiste.service';

@Component({
  selector: 'app-info',
  templateUrl: './info.component.html',
  styleUrls: ['./info.component.css']
})
export class InfoComponent implements OnInit {
    brojParc;
    parcelData;
    title;
    trgoviData;
    objektiData;
    zemljiste = null;
    idnamenaz = null;
    dataSource = new MatTableDataSource(this.zemljiste);
    displayedColumns: string[] = [ 'srez',  'ko',  'broj',  'podbroj', 'povrsina', 'kultura', 'klasa', 'idnamenaz'];

  constructor(@Inject(MAT_DIALOG_DATA) public data: any, private dialogRef: MatDialogRef<InfoComponent>, private zemljisteService: ZemljisteService, ) { 
      this.brojParc = data.brParc;
      this.parcelData = data.parcelData;
      this.trgoviData = data.trgoviData;
      this.objektiData = data.objektiData;
      this.title=data.title;
      console.log(data.brojParc);
      console.log('PODACI O PARCELI'+JSON.stringify(data.parcelData));
      
  }

  ngOnInit() {
      this.getZemljiste();
      this.getNamenazem();
  }
  
  getZemljiste(){
      this.zemljisteService.getZemljiste().subscribe(result => { this.zemljiste = result; this.afterInit(); });
    }
    
    getNamenazem(){
        this.zemljisteService.getNamenazem().subscribe(result => { this.idnamenaz = result; this.afterInit(); });
      }
    
    afterInit(){
        this.dataSource.data = this.zemljiste;
  }
  
  close() {
      console.log('ZATVARA DIALOG');
      this.dialogRef.close();
  }

}
