import { Component, Inject, OnInit, ViewChild  } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FormGroup, FormControl } from '@angular/forms';
import { EventEmitter } from '@angular/core';
import {MatSort, MatTableDataSource} from '@angular/material';
import { NamenaobjService } from './namenaobj.service';
import { Validators } from "@angular/forms";
import {MatSelectModule} from '@angular/material/select';
import {MatDividerModule} from '@angular/material/divider';

@Component({
    selector: 'app-namenaobj',
    templateUrl: './namenaobj.component.html',
    styleUrls: ['./namenaobj.component.css']
})
export class NamenaobjComponent implements OnInit {
    
    displayedColumns: string[] = [ 'naziv', 'oznaka',  'brisi'];
    namenaobj = null;
    dataSource = new MatTableDataSource(this.namenaobj);    
    @ViewChild('sort', {static: true}) sort: MatSort;

    isUpdate = false;


constructor( private namenaobjService: NamenaobjService, 
        private formBuilder: FormBuilder) {}

checkoutForm = this.formBuilder.group({
    pnid: '',
    oznaka: '',
    naziv: ''
});




ngOnInit() {
    this.getNamenaobj();
}

afterInit(){
    this.dataSource.data = this.namenaobj;
    this.dataSource.sort = this.sort;  
}

getNamenaobj(){
    this.namenaobjService.getNamenaobj().subscribe(result => { this.namenaobj = result; this.afterInit(); });
}


onSubmit(customerData) {
    console.warn('Podaci poslati ', JSON.stringify(customerData));
    if (this.isUpdate) {
        this.namenaobjService.sendDataToServer(customerData, this.isUpdate).subscribe(result => {
            this.getNamenaobj(); this.afterInit();
        });
        
    } else {
     //   customerData.pnid=1;
        this.namenaobjService.sendDataToServer(customerData, this.isUpdate).subscribe(result => {   
            this.ngOnInit(); this.afterInit();
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
    this.namenaobjService.delete(pnid).subscribe(result => { this.getNamenaobj(); });
    this.getNamenaobj();
}

applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }


}

