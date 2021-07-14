import { Component, Inject, OnInit, ViewChild  } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FormGroup, FormControl } from '@angular/forms';
import { EventEmitter } from '@angular/core';
import {MatSort, MatTableDataSource} from '@angular/material';
import { PravoobjService } from './pravoobj.service';
import { Validators } from "@angular/forms";
import {MatSelectModule} from '@angular/material/select';

@Component({
  selector: 'app-pravoobj',
  templateUrl: './pravoobj.component.html',
  styleUrls: ['./pravoobj.component.css']
})
export class PravoobjComponent implements OnInit {

    displayedColumns: string[] = [ 'idobj',  'idnosilac',  'idvp', 'deo1', 'deo2', 'brisi'];
    pravoobj = null;
    idobj = null;
    idnosilac = null;
    idvp = null;
    selected1 = null;
    selected2 = null
    selected3 = null
    dataSource = new MatTableDataSource(this.pravoobj);
    @ViewChild('sort', {static: true}) sort: MatSort;
    
    isUpdate = false;

    constructor( private pravoobjService: PravoobjService, 
    private formBuilder: FormBuilder) {}
    
    checkoutForm = this.formBuilder.group({
        pnid: '',     
        idobj: this.formBuilder.group({
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
    this.getPravoObj();
    this.getObjekat();
    this.getNosilacPrava();
    this.getVrstaPrava();
  }

  afterInit(){
        this.dataSource.data = this.pravoobj;
        this.dataSource.sort = this.sort;
  }

  getPravoObj(){
    this.pravoobjService.getPravoObj().subscribe(result => { this.pravoobj = result; this.afterInit(); });
  }
  
  getObjekat(){
      this.pravoobjService.getObjekat().subscribe(result => { this.idobj = result; this.afterInit(); });
    }
  getNosilacPrava(){
      this.pravoobjService.getNosilacPrava().subscribe(result => { this.idnosilac = result; this.afterInit(); });
    }
  getVrstaPrava(){
      this.pravoobjService.getVrstaPrava().subscribe(result => { this.idvp = result; this.afterInit(); });
    }
    

  onSubmit(customerData) {
   // console.warn('Your order has been submitted', JSON.stringify(customerData));
      console.log("jaja")
    if (this.isUpdate) {
        this.pravoobjService.sendDataToServer(customerData, this.isUpdate).subscribe(result => { this.getPravoObj(); this.afterInit();});
    
    } else {
   //   customerData.pnid=1;
        this.pravoobjService.sendDataToServer(customerData, this.isUpdate).subscribe(result => { this.ngOnInit(); this.afterInit();});
   
    }
    this.checkoutForm.reset();
    this.isUpdate = false;
    this.getPravoObj();
}

  
  update(customerData) {
      this.isUpdate = true;
      this.checkoutForm = this.formBuilder.group(customerData);
      //console.log(customerData.idnamena.pnid)
      this.selected1=customerData.idobj.pnid;
      this.selected2=customerData.idnosilac.pnid;
      this.selected3=customerData.idvp.pnid;
      
      this.checkoutForm = this.formBuilder.group({
          pnid: customerData.pnid,
          idobj: this.formBuilder.group({
          	pnid: customerData.idobj.pnid,
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
      this.getPravoObj();
    }

  delete(pnid) {
     this.pravoobjService.delete(pnid).subscribe(result => {this.getPravoObj(); });
     this.getPravoObj();
  }

  applyFilter(filterValue: string) {
      this.dataSource.filter = filterValue.trim().toLowerCase();
    }


}
