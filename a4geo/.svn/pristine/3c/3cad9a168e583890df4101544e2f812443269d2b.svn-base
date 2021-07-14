import { Injectable } from '@angular/core';
import { HttpClient , HttpResponse, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Sifarnik } from './Sifarnik';


@Injectable({
  providedIn: 'root'
})
export class SifarniciService {

    constructor(private http: HttpClient) { }
    
    baseurl='http://localhost:8085';


    public getObveznici(): Observable<Sifarnik[]> {
       // alert(this.baseurl + '/cltipobveznika');
    // return this.http.get<Sifarnik[]>(this.baseurl + '/osnovneevidencije/cltipobveznika');
    
        const url = this.baseurl + '/cltipnosiocaprava';

 
          return this.http.get<Sifarnik[]>(url);
    
    }
    
    

    

    public sendDataToServer(obveznik, isUpdate): Observable<Sifarnik[]>  {
          //alert('The results are:' + JSON.stringify(obveznik));

          if (isUpdate) {
           // alert('Da li ovdeThe results are:' + JSON.stringify(obveznik));
            this.http.put<Sifarnik> (this.baseurl + '/osnovneevidencije/cltipobveznika', 
            obveznik)
            .subscribe(
            (val) => {
              console.log('POST call successful value returned in body',
                val);
                //return this.getObveznici();
            },
            response => {
              console.log('POST call in error', response); return null;
            },
            () => {
              console.log('The POST observable is now completed.');
            });
            return this.http.get<Sifarnik[]>(this.baseurl + '/osnovneevidencije/cltipobveznika');
          } else {
             this.http.post<Sifarnik> (this.baseurl + '/osnovneevidencije/cltipobveznika',
            obveznik)
            .subscribe(
            (val) => {
              console.log('POST call successful value returned in body',
                val);
                
            },
            response => {
              console.log('POST call in error', response); return null;
            },
            () => {
              console.log('The POST observable is now completed.');
              
              
            });
             return this.http.get<Sifarnik[]>(this.baseurl + '/osnovneevidencije/cltipobveznika');
          }

        // return obveznik
        //nije mi jasno zasto mora i ovo i ono push, splice
         
          //return null;

      }


      public delete(pnid): Observable<Sifarnik[]>{
          //alert('The results are:' + JSON.stringify(obveznik));

           this.http.delete(this.baseurl + '/osnovneevidencije/cltipobveznika/'+pnid)
            .subscribe(
            (val) => {
              console.log('POST call successful value returned in body',
                val);
                
            },
            response => {
              console.log('POST call in error', response);return null;
            },
            () => {
              console.log('The POST observable is now completed.'); 
            });

            return this.http.get<Sifarnik[]>(this.baseurl + '/osnovneevidencije/cltipobveznika');
            
      }
      
      
   
      
      
      

      deleteHero (pnid: number): Observable<{}> {
          const url = this.baseurl + '/osnovneevidencije/cltipobveznika/'+pnid; // DELETE api/heroes/42
          return this.http.delete(url)
              .pipe(
              //catchError(this.handleError('deleteHero'))
              );
      }
}
