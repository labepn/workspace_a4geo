import { Injectable } from '@angular/core';
import { HttpClient , HttpResponse, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Sifarnik } from '../Sifarnik';


@Injectable({
  providedIn: 'root'
})
export class VrstapravaService {

    constructor(private http: HttpClient) { }
    
    baseurl='http://localhost:8085';

    //localhost:8085/cltipnosiocaprava
    
    public getVrstaprava(): Observable<Sifarnik[]> {          
       const url = this.baseurl + '/clvrstaprava';
       return this.http.get<Sifarnik[]>(url);
    
    }
    
    

    

    public sendDataToServer(obveznik, isUpdate): Observable<Sifarnik[]>  {
          //alert('The results are:' + JSON.stringify(obveznik));

          if (isUpdate) {
           // alert('Da li ovdeThe results are:' + JSON.stringify(obveznik));
            this.http.put<Sifarnik> (this.baseurl + '/clvrstaprava', 
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
            return this.http.get<Sifarnik[]>(this.baseurl + '/clvrstaprava');
          } else {
             this.http.post<Sifarnik> (this.baseurl + '/clvrstaprava',
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
             return this.http.get<Sifarnik[]>(this.baseurl + '/clvrstaprava');
          }



      }


      public delete(pnid): Observable<Sifarnik[]>{
          //alert('The results are:' + JSON.stringify(obveznik));

           this.http.delete(this.baseurl + '/clvrstaprava/'+pnid)
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

            return this.http.get<Sifarnik[]>(this.baseurl + '/clvrstaprava');
            
      }
      
      
   
      
      
      

      deleteHero (pnid: number): Observable<{}> {
          const url = this.baseurl + '/clvrstaprava/'+pnid; // DELETE api/heroes/42
          return this.http.delete(url)
              .pipe(
              //catchError(this.handleError('deleteHero'))
              );
      }
}
