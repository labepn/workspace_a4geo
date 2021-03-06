import { Injectable } from '@angular/core';
import { HttpClient , HttpResponse, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Sifarnik } from '../Sifarnik';


@Injectable({
  providedIn: 'root'
})
export class SpratnostService {

    constructor(private http: HttpClient) { }
    
    baseurl='http://localhost:8085';

 
    
    public getSpratnost(): Observable<Sifarnik[]> {          
       const url = this.baseurl + '/clspratnost';
       return this.http.get<Sifarnik[]>(url);
    
    }
    
 
    public sendDataToServer(spratnost, isUpdate): Observable<Sifarnik[]>  {
         

          if (isUpdate) {
              //alert('UPDATE PUT The results are:' + JSON.stringify(vrstaprava));
            this.http.put<Sifarnik> (this.baseurl + '/clspratnost', 
             spratnost)
            .subscribe(
            (val) => {
              console.log('POST call successful value returned in body',
                val);
              this.getSpratnost();
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
             this.http.post<Sifarnik> (this.baseurl + '/clspratnost',
             spratnost) // MOZES OVE NAZIVE DA PROMENIS!!
            .subscribe(
            (val) => {
              console.log('POST call successful value returned in body',
                val);
              this.getSpratnost();
                
            },
            response => {
              console.log('POST call in error', response); return null;
            },
            () => {
              console.log('The POST observable is now completed.');
              
              
            });
           //  return this.http.get<Sifarnik[]>(this.baseurl + '/cltipnosiocaprava');
          }

          return this.http.get<Sifarnik[]>(this.baseurl + '/clspratnost');

      }


      delete (pnid: number): Observable<{}> {
          const url = this.baseurl + '/clspratnost/'+pnid; 
          return this.http.delete(url)
              .pipe(              
              );
      }
}
