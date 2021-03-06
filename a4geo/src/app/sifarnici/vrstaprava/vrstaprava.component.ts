import { Component, Inject, OnInit, ViewChild  } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FormGroup, FormControl } from '@angular/forms';
import { EventEmitter } from '@angular/core';
import {MatSort, MatTableDataSource} from '@angular/material';
import { VrstapravaService } from './vrstaprava.service';
import { Validators } from "@angular/forms";
import {MatSelectModule} from '@angular/material/select';
import {MatDividerModule} from '@angular/material/divider';

@Component({
  selector: 'app-vrstaprava',
  templateUrl: './vrstaprava.component.html',
  styleUrls: ['./vrstaprava.component.css']
})
export class VrstapravaComponent implements OnInit {

    selected=0;

    isUpdate = false;

  // http://localhost:8083/cltipobveznika

    displayedColumns: string[] = [ 'naziv', 'oznaka',  'brisi'];
    vrstaprava = null;
    dataSource = new MatTableDataSource(this.vrstaprava);
    @ViewChild('sort', {static: true}) sort: MatSort;

    constructor( private vrstapravaService: VrstapravaService, 
    private formBuilder: FormBuilder) {}
    
    checkoutForm = this.formBuilder.group({
        pnid: '',
        oznaka: '',
        naziv: '',
        aktivnost: ''
    });// ovim je napravljena checkoutForm koja je FormGroup, pomocu FormBildera, da ne bi moralo da se pise new FormControl() kod svakog polja

   


  ngOnInit() {
    this.getVrstaPrava();
    //this.naziv=this.checkoutForm.naziv;
  }

  afterInit(){
        //this.dataSource=this.obveznik;
        this.dataSource.data = this.vrstaprava;
        this.dataSource.sort = this.sort;
        
  }

  getVrstaPrava(){
    this.vrstapravaService.getVrstaprava().subscribe(result => { this.vrstaprava = result; this.afterInit(); });
  }
  

  onSubmit(customerData) {
    // Process checkout data here
    customerData.aktivan=this.selected;
    console.warn('Your order has been submitted', JSON.stringify(customerData));
    if (this.isUpdate) {
        var d=this.vrstaprava;
        var index = d.findIndex(x=>x.pnid === customerData.pnid);
        this.vrstapravaService.sendDataToServer(customerData, this.isUpdate).subscribe(result => {this.vrstaprava[index]=customerData; this.afterInit();});
    
    } else {
      //customerData.pnid=1;
        console.log("ovde")
        this.vrstapravaService.sendDataToServer(customerData, this.isUpdate).subscribe(result => {this.getVrstaPrava(); this.afterInit();});
   
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
      var d=this.vrstaprava;
      var index = d.findIndex(x=>x.pnid === pnid)
     this.vrstapravaService.deleteHero(pnid).subscribe(result => { this.vrstaprava.splice(index, 1); this.afterInit(); });
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

  
}

