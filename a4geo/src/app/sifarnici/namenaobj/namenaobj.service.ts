import { Injectable } from '@angular/core';
import { HttpClient , HttpResponse, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Sifarnik } from '../Sifarnik';


@Injectable({
  providedIn: 'root'
})
export class NamenaobjService {

    constructor(private http: HttpClient) { }
    
    baseurl='http://localhost:8085';

 
    
    public getNamenaobj(): Observable<Sifarnik[]> {          
       const url = this.baseurl + '/clnamenaobj';
       return this.http.get<Sifarnik[]>(url);
    
    }
    
 
    public sendDataToServer(vrstaobjekta, isUpdate): Observable<Sifarnik[]>  {
         

          if (isUpdate) {
              //alert('UPDATE PUT The results are:' + JSON.stringify(vrstaprava));
            this.http.put<Sifarnik> (this.baseurl + '/clnamenaobj', 
             vrstaobjekta)
            .subscribe(
            (val) => {
              console.log('POST call successful value returned in body',
                val);
              this.getNamenaobj();
                //return this.getObveznici();
            },
            response => {
              console.log('POST call in error', response); return null;
            },
            () => {
              console.log('The POST observable is now completed.');
            });
           // return this.http.get<Sifarnik[]>(this.baseurl + '/cltipnosiocaprava');
          } else {
              //alert('ADD POST The results are:' + JSON.stringify(vrstaprava));
             this.http.post<Sifarnik> (this.baseurl + '/clnamenaobj',
             vrstaobjekta) // MOZES OVE NAZIVE DA PROMENIS!!
            .subscribe(
            (val) => {
              console.log('POST call successful value returned in body',
                val);
              this.getNamenaobj();
                
            },
            response => {
              console.log('POST call in error', response); return null;
            },
            () => {
              console.log('The POST observable is now completed.');
              
              
            });
           //  return this.http.get<Sifarnik[]>(this.baseurl + '/cltipnosiocaprava');
          }

          return this.http.get<Sifarnik[]>(this.baseurl + '/clnamenaobj');

      }


      delete (pnid: number): Observable<{}> {
          const url = this.baseurl + '/clnamenaobj/'+pnid; 
          return this.http.delete(url)
              .pipe(              
              );
      }
}
