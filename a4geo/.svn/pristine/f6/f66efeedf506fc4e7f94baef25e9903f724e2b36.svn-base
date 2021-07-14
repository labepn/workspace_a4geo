import { Injectable } from '@angular/core';
import { HttpClient , HttpResponse, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Parcela } from './Parcela';



@Injectable({
  providedIn: 'root'
})
export class GeoportalmkService {

  constructor(private http: HttpClient) { }
  
  public getGeoJson(): Observable<Parcela[]> {
      // alert(this.baseurl + '/cltipobveznika');
   // return this.http.get<Sifarnik[]>(this.baseurl + '/osnovneevidencije/cltipobveznika');
   
   //const url = 'https://rest.geosrbija.rs/api/dkp/v1/parcela?opstina=Be%C4%8Dej&kat_opstina=Be%C4%8Dej&parcela=1%2F1&geom=true';
   const url = 'https://rest.geosrbija.rs/api/dkp/v1/parcela?opstina=Be%C4%8Dej&kat_opstina=Be%C4%8Dej&geom=true';
   //let headers = new Headers();
   //headers.append('Content-Type', 'application/json'); 
   //headers.append('Authorization': 'x-access-token' + 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoibWtncm91cCIsInB1YmxpY19pZCI6IjRlYzNhM2JmLTUxNDktNDlkNi1iNTY4LWJkM2ZlM2Q4Zjk1MyIsInJvbGUiOiJsaXN0YSIsImVuZHBvaW50IjoiYXIscnBqLGRrcCIsImxpc3RhX29wc3RpbmEiOiJCRVx1MDEwY0VKIn0.0LspC5zdUWyoE-JZDwfsDEA0fBfy3h06wxErRaNNP94');

   //const headers = new Headers({'Content-Type': 'application/json; charset=utf-8'});
   //headers.append('Authorization', 'x-access-token ' + 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoibWtncm91cCIsInB1YmxpY19pZCI6IjRlYzNhM2JmLTUxNDktNDlkNi1iNTY4LWJkM2ZlM2Q4Zjk1MyIsInJvbGUiOiJsaXN0YSIsImVuZHBvaW50IjoiYXIscnBqLGRrcCIsImxpc3RhX29wc3RpbmEiOiJCRVx1MDEwY0VKIn0.0LspC5zdUWyoE-JZDwfsDEA0fBfy3h06wxErRaNNP94');
   
   //const headers = new Headers({'Content-Type': 'application/json; charset=utf-8'});
   //const options = new RequestOptions({headers: headers});
   
   //options.headers.set('x-access-token', 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoibWtncm91cCIsInB1YmxpY19pZCI6IjRlYzNhM2JmLTUxNDktNDlkNi1iNTY4LWJkM2ZlM2Q4Zjk1MyIsInJvbGUiOiJsaXN0YSIsImVuZHBvaW50IjoiYXIscnBqLGRrcCIsImxpc3RhX29wc3RpbmEiOiJCRVx1MDEwY0VKIn0.0LspC5zdUWyoE-JZDwfsDEA0fBfy3h06wxErRaNNP94');
   //options.headers.set('additional-info', 'my-info');

   const httpOptions = {
           headers: new HttpHeaders({
             'Content-Type':  'application/json',
             'x-access-token':  'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoibWtncm91cCIsInB1YmxpY19pZCI6IjRlYzNhM2JmLTUxNDktNDlkNi1iNTY4LWJkM2ZlM2Q4Zjk1MyIsInJvbGUiOiJsaXN0YSIsImVuZHBvaW50IjoiYXIscnBqLGRrcCIsImxpc3RhX29wc3RpbmEiOiJCRVx1MDEwY0VKIn0.0LspC5zdUWyoE-JZDwfsDEA0fBfy3h06wxErRaNNP94'
           })
         };
   
   


         return this.http.get<Parcela[]>(url,  httpOptions );
   
   }
  
  
  
  
  
  
  public getRPJ(): Observable<Parcela[]> {
      //  alert(this.baseurl + '/cltipzaduzenja');
      
      
      const url = 'http://ogc4u.geosrbija.rs/rpj/wms?request=getcapabilities&version=1.3.0&service=wms';
          
          let username='mkgroup'
          let password='!MK9r0up1'


          const httpOptions = {
              headers: new HttpHeaders({           
                'Content-Type':  'application/json',
                'Access-Control-Allow-Origin': '*',
                'Authorization': 'Basic ' + btoa('mkgroupp:!MK9r0up1')
              })
            };
          
          
              /*
          const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
*/
      
      return this.http.get<Parcela[]>(url,  httpOptions );
    }
  
  
  
  
  
}


