import { Component, Inject, OnInit, ViewChild  } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FormGroup, FormControl } from '@angular/forms';
import { EventEmitter } from '@angular/core';
import {MatSort, MatTableDataSource} from '@angular/material';
import { ObjektiService } from './objekti.service';
import { Validators } from "@angular/forms";
import {MatSelectModule} from '@angular/material/select';

@Component({
  selector: 'app-objekti',
  templateUrl: './objekti.component.html',
  styleUrls: ['./objekti.component.css']
})
export class ObjektiComponent implements OnInit {

    displayedColumns: string[] = [ 'povrsina',  'idspratnost',  'idnamena',  'srez', 'ko', 'broj', 'podbroj', 'kultura', 'zgrada', 'brisi'];
    objekti = null;
    idnamena = null;
    idspratnost = null;
    selected1 = null;
    selected2 = null
    dataSource = new MatTableDataSource(this.objekti);
    @ViewChild('sort', {static: true}) sort: MatSort;
    
    isUpdate = false;

    constructor( private objektiService: ObjektiService, 
    private formBuilder: FormBuilder) {}
    
    checkoutForm = this.formBuilder.group({
        pnid: '',     
        povrsina: '',
        idspratnost: this.formBuilder.group({
			pnid: [''],
			oznaka: [''],
			naziv: ['']
        }),
        idnamena: this.formBuilder.group({
			pnid: [''],
			oznaka: [''],
			naziv: ['']
        }),
        srez: '',
        ko: '',
        broj: '',
        podbroj: '',
        kultura: '',
        zgrada: ''
            
    });

  ngOnInit() {
    this.getObjekti();
    this.getNamena();
    this.getSpratnost();
  }

  afterInit(){
        this.dataSource.data = this.objekti;
        this.dataSource.sort = this.sort;
  }

  getObjekti(){
    this.objektiService.getObjekti().subscribe(result => { this.objekti = result; this.afterInit(); });
  }
  
  getNamena(){
      this.objektiService.getNamena().subscribe(result => { this.idnamena = result; this.afterInit(); });
    }
  getSpratnost(){
      this.objektiService.getSpratnost().subscribe(result => { this.idspratnost = result; this.afterInit(); });
    }
    

  onSubmit(customerData) {
   // console.warn('Your order has been submitted', JSON.stringify(customerData));
      console.log("jaja")
    if (this.isUpdate) {
        this.objektiService.sendDataToServer(customerData, this.isUpdate).subscribe(result => { this.getObjekti(); this.afterInit();});
    
    } else {
   //   customerData.pnid=1;
        this.objektiService.sendDataToServer(customerData, this.isUpdate).subscribe(result => { this.ngOnInit(); this.afterInit();});
   
    }
    this.checkoutForm.reset();
    this.isUpdate = false;
    this.getObjekti();
}

  
  update(customerData) {
      this.isUpdate = true;
      this.checkoutForm = this.formBuilder.group(customerData);
      console.log(customerData.idnamena.pnid)
      this.selected1=customerData.idnamena.pnid;
      this.selected2=customerData.idspratnost.pnid;
      
      this.checkoutForm = this.formBuilder.group({
          pnid: customerData.pnid,
          povrsina:customerData.povrsina,
          srez: customerData.srez,
          ko: customerData.ko,
          broj: customerData.broj,
          podbroj: customerData.podbroj,
          kultura: customerData.kultura,
          zgrada: customerData.klasa,
          idnamena: this.formBuilder.group({
              pnid: customerData.idnamena.pnid,
              oznaka: [''],
              naziv: ['']
            }),
          idspratnost: this.formBuilder.group({
              pnid: customerData.idspratnost.pnid,
              oznaka: [''],
              naziv: ['']
            })
              
      });
      this.getObjekti();
    }

  delete(pnid) {
     this.objektiService.delete(pnid).subscribe(result => {this.getObjekti(); });
     this.getObjekti();
  }

  applyFilter(filterValue: string) {
      this.dataSource.filter = filterValue.trim().toLowerCase();
    }


}
