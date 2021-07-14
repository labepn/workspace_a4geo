import { Injectable } from '@angular/core';
import { HttpClient , HttpResponse, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Sifarnik } from '../../sifarnici/Sifarnik';


@Injectable({
    providedIn: 'root'
})
export class ZemljisteService {
    
    constructor(private http: HttpClient) { }
    
    baseurl='http://localhost:8085';
    
    public getZemljiste(): Observable<Sifarnik[]> {
        const url = this.baseurl + '/knzemljiste';
        return this.http.get<Sifarnik[]>(url);  
    }
    
    public getNamenazem(): Observable<Sifarnik[]> {
        const url = this.baseurl + '/clnamenazem';
        return this.http.get<Sifarnik[]>(url);  
    }
    
    
    public sendDataToServer(obveznik, isUpdate): Observable<Sifarnik[]>  {
        //alert('The results are:' + JSON.stringify(obveznik));

        if (isUpdate) {
        //  alert('The results are:' + JSON.stringify(obveznik));
          this.http.put<Sifarnik> (this.baseurl + '/knzemljiste', 
          obveznik)
          .subscribe(
          (val) => {
            console.log('POST call successful value returned in body',
              val);
            this.getZemljiste();
              //return this.getObveznici();
          },
          response => {
            console.log('POST call in error', response);
          },
          () => {
            console.log('The POST observable is now completed.');
          });

        } else {
           this.http.post<Sifarnik> (this.baseurl + '/knzemljiste',
          obveznik)
          .subscribe(
          (val) => {
            console.log('POST call successful value returned in body',
              val);
            this.getZemljiste();
              
          },
          response => {
            console.log('POST call in error', response);
          },
          () => {
            console.log('The POST observable is now completed.');
            
            
          });
        }

  
        return this.http.get<Sifarnik[]>(this.baseurl + '/knzemljiste');
      

    }
    
    
    delete (pnid: number): Observable<{}> {
        const url = this.baseurl + '/knzemljiste/'+pnid; // DELETE api/heroes/42
        return this.http.delete(url)
        .pipe(
                
        );
    }
}
