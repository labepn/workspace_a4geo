import { Component, Inject, OnInit, ViewChild  } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FormGroup, FormControl } from '@angular/forms';
import { EventEmitter } from '@angular/core';
import {MatSort, MatTableDataSource} from '@angular/material';
import { NamenazemService } from './namenazem.service';
import { Validators } from "@angular/forms";
import {MatSelectModule} from '@angular/material/select';
import {MatDividerModule} from '@angular/material/divider';

@Component({
    selector: 'app-namenazem',
    templateUrl: './namenazem.component.html',
    styleUrls: ['./namenazem.component.css']
})
export class NamenazemComponent implements OnInit {
    
    displayedColumns: string[] = [ 'naziv', 'oznaka',  'brisi'];
    namenazem = null;
    dataSource = new MatTableDataSource(this.namenazem);    
    @ViewChild('sort', {static: true}) sort: MatSort;

    isUpdate = false;


constructor( private namenazemService: NamenazemService, 
        private formBuilder: FormBuilder) {}

checkoutForm = this.formBuilder.group({
    pnid: '',
    oznaka: '',
    naziv: ''
});




ngOnInit() {
    this.getNamenazem();
}

afterInit(){
    this.dataSource.data = this.namenazem;
    this.dataSource.sort = this.sort;  
}

getNamenazem(){
    this.namenazemService.getNamenazem().subscribe(result => { this.namenazem = result; this.afterInit(); });
}


onSubmit(customerData) {
    console.warn('Podaci poslati ', JSON.stringify(customerData));
    if (this.isUpdate) {
        this.namenazemService.sendDataToServer(customerData, this.isUpdate).subscribe(result => {            
            this.getNamenazem();
            this.afterInit();
        });
        
    } else {
     //   customerData.pnid=1;
        this.namenazemService.sendDataToServer(customerData, this.isUpdate).subscribe(result => {            
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
    this.getNamenazem();
}

delete(pnid) {      
    this.namenazemService.delete(pnid).subscribe(result => { this.getNamenazem(); });
    this.getNamenazem();
}

applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }


}

