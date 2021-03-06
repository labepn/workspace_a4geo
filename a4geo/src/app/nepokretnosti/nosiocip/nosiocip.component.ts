import { Component, Inject, OnInit, ViewChild  } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FormGroup, FormControl } from '@angular/forms';
import { EventEmitter } from '@angular/core';
import {MatSort, MatTableDataSource} from '@angular/material';
import { NosiocipService } from './nosiocip.service';
import { Validators } from "@angular/forms";
import {MatSelectModule} from '@angular/material/select';

@Component({
  selector: 'app-nosiocip',
  templateUrl: './nosiocip.component.html',
  styleUrls: ['./nosiocip.component.css']
})
export class NosiocipComponent implements OnInit {

    displayedColumns: string[] = [ 'matbr', 'ime','imeoca','prezime',  'adresa',  'grad',  'drzava', 'tipnosiocaprava', 'brisi'];
    nosiocp = null;
    tipnosiocaprava = null;
    selected1 = null;
    dataSource = new MatTableDataSource(this.nosiocp);
    @ViewChild('sort', {static: true}) sort: MatSort;
    
    isUpdate = false;

    constructor( private nosiocipService: NosiocipService, 
    private formBuilder: FormBuilder) {}
    
    checkoutForm = this.formBuilder.group({
        pnid: '',
        matbr: '',
        ime: '',
        imeoca: '',
        prezime: '',
        adresa: '',
        grad: '',
        drzava: '',
        tipnosiocaprava: this.formBuilder.group({
            pnid: [''],
            oznaka: [''],
            naziv: ['']
          })
            
    });

  ngOnInit() {
    this.getNosiocip();
    this.getTipNosioca();
  }

  afterInit(){
        this.dataSource.data = this.nosiocp;
        this.dataSource.sort = this.sort;
  }

  getNosiocip(){
    this.nosiocipService.getNosiocip().subscribe(result => { this.nosiocp = result;  this.afterInit(); });
  }
  
  getTipNosioca(){
      this.nosiocipService.getTipNosioca().subscribe(result => { this.tipnosiocaprava = result; this.afterInit(); });
    }
    

  onSubmit(customerData) {
   // console.warn('Your order has been submitted', JSON.stringify(customerData));
    if (this.isUpdate) {
        this.nosiocipService.sendDataToServer(customerData, this.isUpdate).subscribe(result => { this.getNosiocip();  this.afterInit();});
    
    } else {
   //   customerData.pnid=1;
        this.nosiocipService.sendDataToServer(customerData, this.isUpdate).subscribe(result => { this.ngOnInit(); this.afterInit();});
   
    }
    this.checkoutForm.reset();
    this.isUpdate = false;
}

  
  update(customerData) {
      this.isUpdate = true;
      this.checkoutForm = this.formBuilder.group(customerData);
      console.log(customerData.tipnosiocaprava.pnid)
      this.selected1=customerData.tipnosiocaprava.pnid;
      
      this.checkoutForm = this.formBuilder.group({
          pnid: customerData.pnid,
          matbr:customerData.matbr,
          ime: customerData.ime,
          imeoca: customerData.imeoca,
          prezime: customerData.prezime,
          adresa: customerData.prezime,
          grad: customerData.grad,
          drzava: customerData.drzava,
          tipnosiocaprava: this.formBuilder.group({
              pnid: customerData.tipnosiocaprava.pnid,
              oznaka: [''],
              naziv: ['']
            })
              
      });
    }

  delete(pnid) {
     this.nosiocipService.delete(pnid).subscribe(result => {this.getNosiocip(); });
  }

  applyFilter(filterValue: string) {
      this.dataSource.filter = filterValue.trim().toLowerCase();
    }


}
