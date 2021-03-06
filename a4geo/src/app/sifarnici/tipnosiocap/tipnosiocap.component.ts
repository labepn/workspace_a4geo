import { Component, Inject, OnInit, ViewChild  } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FormGroup, FormControl } from '@angular/forms';
import { EventEmitter } from '@angular/core';
import {MatSort, MatTableDataSource} from '@angular/material';
import { TipnosiocapService } from './tipnosiocap.service';
import { Validators } from "@angular/forms";
import {MatSelectModule} from '@angular/material/select';
import {MatDividerModule} from '@angular/material/divider';

@Component({
    selector: 'app-tipnosiocap',
    templateUrl: './tipnosiocap.component.html',
    styleUrls: ['./tipnosiocap.component.css']
})
export class TipnosiocapComponent implements OnInit {
    
    displayedColumns: string[] = [ 'naziv', 'oznaka',  'brisi'];
    tipnosiocap = null;
    dataSource = new MatTableDataSource(this.tipnosiocap);    
    @ViewChild('sort', {static: true}) sort: MatSort;

    isUpdate = false;


constructor( private tipnosiocapService: TipnosiocapService, 
        private formBuilder: FormBuilder) {}

checkoutForm = this.formBuilder.group({
    pnid: '',
    oznaka: '',
    naziv: ''
});




ngOnInit() {
    this.getTipnosiocap();
}

afterInit(){
    this.dataSource.data = this.tipnosiocap;
    this.dataSource.sort = this.sort;  
}

getTipnosiocap(){
    this.tipnosiocapService.getTipnosiocap().subscribe(result => { this.tipnosiocap = result; this.afterInit(); });
}


onSubmit(customerData) {
    console.warn('Podaci poslati ', JSON.stringify(customerData));
    if (this.isUpdate) {
        this.tipnosiocapService.sendDataToServer(customerData, this.isUpdate).subscribe(result => {            
            this.getTipnosiocap();
            this.afterInit();
        });
        
    } else {
     //   customerData.pnid=1;
        this.tipnosiocapService.sendDataToServer(customerData, this.isUpdate).subscribe(result => {            
            this.ngOnInit();
            this.afterInit();
    });
        
    }
    this.checkoutForm.reset();
    this.isUpdate = false;
}


update(customerData) {
    this.isUpdate = true;
    this.checkoutForm = this.formBuilder.group(customerData);
}

delete(pnid) {      
    this.tipnosiocapService.delete(pnid).subscribe(result => { this.getTipnosiocap(); });
}

applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }


}

