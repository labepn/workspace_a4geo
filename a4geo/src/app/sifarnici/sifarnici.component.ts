import { Component, Inject, OnInit, ViewChild  } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FormGroup, FormControl } from '@angular/forms';
import { EventEmitter } from '@angular/core';
import {MatSort, MatTableDataSource} from '@angular/material';
import { SifarniciService } from './sifarnici.service';
import { Validators } from "@angular/forms";
import {MatSelectModule} from '@angular/material/select';


@Component({
  selector: 'app-sifarnici',
  templateUrl: './sifarnici.component.html',
  styleUrls: ['./sifarnici.component.css']
})
export class SifarniciComponent implements OnInit {

    selected=0;

    isUpdate = false;

  // http://localhost:8083/cltipobveznika

    displayedColumns: string[] = [ 'naziv', 'oznaka',  'brisi'];
    obveznik = null;
    dataSource = new MatTableDataSource(this.obveznik);
    @ViewChild('sort', {static: true}) sort: MatSort;

    constructor( private tipobveznikaService: SifarniciService, 
    private formBuilder: FormBuilder) {}
    
    checkoutForm = this.formBuilder.group({
        pnid: '',
        oznaka: '',
        naziv: '',
        aktivnost: ''
    });// ovim je napravljena checkoutForm koja je FormGroup, pomocu FormBildera, da ne bi moralo da se pise new FormControl() kod svakog polja

   


  ngOnInit() {
    this.getObveznici();
    //this.naziv=this.checkoutForm.naziv;
  }

  afterInit(){
        //this.dataSource=this.obveznik;
        this.dataSource.data = this.obveznik;
        this.dataSource.sort = this.sort;
        //alert('da da'+JSON.stringify(this.obveznik));
        //this.getObveznici();
        
  }

  getObveznici(){
    this.tipobveznikaService.getObveznici().subscribe(result => { this.obveznik = result; this.afterInit(); });
  }
  

  onSubmit(customerData) {
    // Process checkout data here
    customerData.aktivan=this.selected;
    console.warn('Your order has been submitted', JSON.stringify(customerData));
    if (this.isUpdate) {
        var d=this.obveznik;
        var index = d.findIndex(x=>x.pnid === customerData.pnid);
        this.tipobveznikaService.sendDataToServer(customerData, this.isUpdate).subscribe(result => {this.obveznik[index]=customerData; this.afterInit();});
    
    } else {
      customerData.pnid=1;
        this.tipobveznikaService.sendDataToServer(customerData, this.isUpdate).subscribe(result => {this.obveznik.push(customerData); this.afterInit();});
   
    }
    this.checkoutForm.reset();
    this.isUpdate = false;
}

  
  update(customerData) {
      this.isUpdate = true;
      this.checkoutForm = this.formBuilder.group(customerData);
    }

  delete(pnid) {
      //record => record.pnid === pnid
      var d=this.obveznik;
      var index = d.findIndex(x=>x.pnid === pnid)
     this.tipobveznikaService.deleteHero(pnid).subscribe(result => { this.obveznik.splice(index, 1); this.afterInit(); });
  }

  //naziv = new FormControl('', [Validators.required, Validators.email]);

  getErrorMessage() {
      const formControl=this.checkoutForm.get('naziv'); //vraca form kontrolu iz checkoutForm grupe FormGroups
      //alert();
      console.log('invalidan mail');
    return formControl.hasError('required') ? 'Morate unjeti vrijednost' :
       formControl.hasError('email') ? 'Nije validan email' :
           '';
  }

  getDaNe(val) {
    if (val==1)
      return 'DA';
    else
      return 'NE'; 
  }
}

