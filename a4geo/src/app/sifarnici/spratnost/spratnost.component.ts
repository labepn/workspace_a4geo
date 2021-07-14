import { Component, Inject, OnInit, ViewChild  } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FormGroup, FormControl } from '@angular/forms';
import { EventEmitter } from '@angular/core';
import {MatSort, MatTableDataSource} from '@angular/material';
import { SpratnostService } from './spratnost.service';
import { Validators } from "@angular/forms";
import {MatSelectModule} from '@angular/material/select';
import {MatDividerModule} from '@angular/material/divider';

@Component({
    selector: 'app-spratnost',
    templateUrl: './spratnost.component.html',
    styleUrls: ['./spratnost.component.css']
})
export class SpratnostComponent implements OnInit {
    
    displayedColumns: string[] = [ 'naziv', 'oznaka',  'brisi'];
    spratnost = null;
    dataSource = new MatTableDataSource(this.spratnost);    
    @ViewChild('sort', {static: true}) sort: MatSort;

    isUpdate = false;


constructor( private spratnostService: SpratnostService, 
        private formBuilder: FormBuilder) {}

checkoutForm = this.formBuilder.group({
    pnid: '',
    oznaka: '',
    naziv: ''
});




ngOnInit() {
    this.getSpratnost();
}

afterInit(){
    this.dataSource.data = this.spratnost;
    this.dataSource.sort = this.sort;  
}

getSpratnost(){
    this.spratnostService.getSpratnost().subscribe(result => { this.spratnost = result; this.afterInit(); });
}


onSubmit(customerData) {
    console.warn('Podaci poslati ', JSON.stringify(customerData));
    if (this.isUpdate) {
        this.spratnostService.sendDataToServer(customerData, this.isUpdate).subscribe(result => {            
            this.getSpratnost();
            this.afterInit();
        });
        
    } else {
     //   customerData.pnid=1;
        this.spratnostService.sendDataToServer(customerData, this.isUpdate).subscribe(result => {            
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
    this.getSpratnost();
}

delete(pnid) {      
    this.spratnostService.delete(pnid).subscribe(result => { this.getSpratnost(); });
    this.getSpratnost();
}

applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }


}

