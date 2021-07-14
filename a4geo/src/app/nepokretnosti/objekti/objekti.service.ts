import { Injectable } from '@angular/core';
import { HttpClient , HttpResponse, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Sifarnik } from '../../sifarnici/Sifarnik';


@Injectable({
    providedIn: 'root'
})
export class ObjektiService {
    
    constructor(private http: HttpClient) { }
    
    baseurl='http://localhost:8085';
    
    public getObjekti(): Observable<Sifarnik[]> {
        const url = this.baseurl + '/knobjekti';
        return this.http.get<Sifarnik[]>(url);  
    }
    
    public getNamena(): Observable<Sifarnik[]> {
        const url = this.baseurl + '/clnamenaobj';
        return this.http.get<Sifarnik[]>(url);  
    }
    
    public getSpratnost(): Observable<Sifarnik[]> {
        const url = this.baseurl + '/clspratnost';
        return this.http.get<Sifarnik[]>(url);  
    }
    
    
    public sendDataToServer(obveznik, isUpdate): Observable<Sifarnik[]>  {
        //alert('The results are:' + JSON.stringify(obveznik));

        if (isUpdate) {
        //  alert('The results are:' + JSON.stringify(obveznik));
          this.http.put<Sifarnik> (this.baseurl + '/knobjekti', 
          obveznik)
          .subscribe(
          (val) => {
            console.log('POST call successful value returned in body',
              val);
            this.getObjekti();
              //return this.getObveznici();
          },
          response => {
            console.log('POST call in error', response);
          },
          () => {
            console.log('The POST observable is now completed.');
          });

        } else {
           this.http.post<Sifarnik> (this.baseurl + '/knobjekti',
          obveznik)
          .subscribe(
          (val) => {
            console.log('POST call successful value returned in body',
              val);
            this.getObjekti();
              
          },
          response => {
            console.log('POST call in error', response);
          },
          () => {
            console.log('The POST observable is now completed.');
            
            
          });
        }

  
        return this.http.get<Sifarnik[]>(this.baseurl + '/knobjekti');
      

    }
    
    
    delete (pnid: number): Observable<{}> {
        const url = this.baseurl + '/knobjekti/'+pnid; // DELETE api/heroes/42
        return this.http.delete(url)
        .pipe(
                
        );
    }
}
