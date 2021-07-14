import { Component, Inject, OnInit, ViewChild  } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FormGroup, FormControl } from '@angular/forms';
import { EventEmitter } from '@angular/core';
import {MatSort, MatTableDataSource} from '@angular/material';
import { PravozemService } from './pravozem.service';
import { Validators } from "@angular/forms";
import {MatSelectModule} from '@angular/material/select';

@Component({
  selector: 'app-pravozem',
  templateUrl: './pravozem.component.html',
  styleUrls: ['./pravozem.component.css']
})
export class PravozemComponent implements OnInit {

    displayedColumns: string[] = [ 'idzem',  'idnosilac',  'idvp', 'deo1', 'deo2', 'brisi'];
    pravozem = null;
    idzem = null;
    idnosilac = null;
    idvp = null;
    selected1 = null;
    selected2 = null
    selected3 = null
    dataSource = new MatTableDataSource(this.pravozem);
    @ViewChild('sort', {static: true}) sort: MatSort;
    
    isUpdate = false;

    constructor( private pravozemService: PravozemService, 
    private formBuilder: FormBuilder) {}
    
    checkoutForm = this.formBuilder.group({
        pnid: '',     
        idzem: this.formBuilder.group({
        	pnid: [''],
        	ko: [''],
        	broj: ['']
        }),
        idnosilac: this.formBuilder.group({
			pnid: [''],
			matbr: ['']
        }),
        idvp: this.formBuilder.group({
			pnid: [''],
			naziv: ['']
        }),
        deo1: '',
        deo2: ''
    });

  ngOnInit() {
    this.getPravoZem();
    this.getZemljiste();
    this.getNosilacPrava();
    this.getVrstaPrava();
  }

  afterInit(){
        this.dataSource.data = this.pravozem;
        this.dataSource.sort = this.sort;
  }

  getPravoZem(){
    this.pravozemService.getPravoZem().subscribe(result => { this.pravozem = result; this.afterInit(); });
  }
  
  getZemljiste(){
      this.pravozemService.getZemljiste().subscribe(result => { this.idzem = result; this.afterInit(); });
    }
  getNosilacPrava(){
      this.pravozemService.getNosilacPrava().subscribe(result => { this.idnosilac = result; this.afterInit(); });
    }
  getVrstaPrava(){
      this.pravozemService.getVrstaPrava().subscribe(result => { this.idvp = result; this.afterInit(); });
    }
    

  onSubmit(customerData) {
   // console.warn('Your order has been submitted', JSON.stringify(customerData));
      console.log("jaja")
    if (this.isUpdate) {
        this.pravozemService.sendDataToServer(customerData, this.isUpdate).subscribe(result => { this.getPravoZem(); this.afterInit();});
    
    } else {
   //   customerData.pnid=1;
        this.pravozemService.sendDataToServer(customerData, this.isUpdate).subscribe(result => { this.ngOnInit(); this.afterInit();});
   
    }
    this.checkoutForm.reset();
    this.isUpdate = false;
}

  
  update(customerData) {
      this.isUpdate = true;
      this.checkoutForm = this.formBuilder.group(customerData);
      //console.log(customerData.idnamena.pnid)
      this.selected1=customerData.idzem.pnid;
      this.selected2=customerData.idnosilac.pnid;
      this.selected3=customerData.idvp.pnid;
      
      this.checkoutForm = this.formBuilder.group({
          pnid: customerData.pnid,
          idzem: this.formBuilder.group({
          	pnid: customerData.idzem.pnid,
          	ko: [''],
        	broj: ['']
          }),
          idnosilac: this.formBuilder.group({
  			pnid: customerData.idnosilac.pnid,
  			matbr: ['']
          }),
          idvp: this.formBuilder.group({
  			pnid: customerData.idvp.pnid,
  			naziv: ['']
          }),
          deo1: customerData.deo1,
          deo2: customerData.deo2
              
      });
      this.getPravoZem();
    }

  delete(pnid) {
     this.pravozemService.delete(pnid).subscribe(result => {this.getPravoZem(); });
     this.getPravoZem();
  }

  applyFilter(filterValue: string) {
      this.dataSource.filter = filterValue.trim().toLowerCase();
    }


}
