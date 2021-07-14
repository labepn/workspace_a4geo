import { Component, Inject, OnInit, ViewChild  } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FormGroup, FormControl } from '@angular/forms';
import { EventEmitter } from '@angular/core';
import {MatSort, MatTableDataSource} from '@angular/material';
import { ZemljisteService } from './zemljiste.service';
import { Validators } from "@angular/forms";
import {MatSelectModule} from '@angular/material/select';

@Component({
  selector: 'app-zemljiste',
  templateUrl: './zemljiste.component.html',
  styleUrls: ['./zemljiste.component.css']
})
export class ZemljisteComponent implements OnInit {

    displayedColumns: string[] = [ 'srez',  'ko',  'broj',  'podbroj', 'povrsina', 'kultura', 'klasa', 'idnamenaz', 'brisi'];
    zemljiste = null;
    idnamenaz = null;
    selected1 = null;
    dataSource = new MatTableDataSource(this.zemljiste);
    @ViewChild('sort', {static: true}) sort: MatSort;
    
    isUpdate = false;

    constructor( private zemljisteService: ZemljisteService, 
    private formBuilder: FormBuilder) {}
    
    checkoutForm = this.formBuilder.group({
        pnid: '',     
        srez: '',
        ko: '',
        broj: '',
        podbroj: '',
        povrsina: '',
        kultura: '',
        klasa: '',
        idnamenaz: this.formBuilder.group({
			pnid: [''],
			oznaka: [''],
			naziv: ['']
        })
            
    });

  ngOnInit() {
    this.getZemljiste();
    this.getNamenazem();
  }

  afterInit(){
        this.dataSource.data = this.zemljiste;
        this.dataSource.sort = this.sort;
  }

  getZemljiste(){
    this.zemljisteService.getZemljiste().subscribe(result => { this.zemljiste = result; this.afterInit(); });
  }
  
  getNamenazem(){
      this.zemljisteService.getNamenazem().subscribe(result => { this.idnamenaz = result; this.afterInit(); });
    }
    

  onSubmit(customerData) {
   // console.warn('Your order has been submitted', JSON.stringify(customerData));
      console.log("jaja")
    if (this.isUpdate) {
        this.zemljisteService.sendDataToServer(customerData, this.isUpdate).subscribe(result => { this.getZemljiste(); this.afterInit();});
    
    } else {
   //   customerData.pnid=1;
        this.zemljisteService.sendDataToServer(customerData, this.isUpdate).subscribe(result => { this.ngOnInit(); this.afterInit();});
   
    }
    this.checkoutForm.reset();
    this.isUpdate = false;
    this.getZemljiste();
}

  
  update(customerData) {
      this.isUpdate = true;
      this.checkoutForm = this.formBuilder.group(customerData);
      console.log(customerData.idnamenaz.pnid)
      this.selected1=customerData.idnamenaz.pnid;
      
      this.checkoutForm = this.formBuilder.group({
          pnid: customerData.pnid,
          povrsina:customerData.povrsina,
          srez: customerData.srez,
          ko: customerData.ko,
          broj: customerData.broj,
          podbroj: customerData.podbroj,
          kultura: customerData.kultura,
          klasa: customerData.klasa,
          idnamenaz: this.formBuilder.group({
              pnid: customerData.idnamenaz.pnid,
              oznaka: [''],
              naziv: ['']
            })
              
      });
      this.getZemljiste();
    }

  delete(pnid) {
     this.zemljisteService.delete(pnid).subscribe(result => {this.getZemljiste(); });
     this.getZemljiste();
  }

  applyFilter(filterValue: string) {
      this.dataSource.filter = filterValue.trim().toLowerCase();
    }


}
