import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GeoportalComponent } from './geoportal/geoportal.component';
import { NepokretnostiComponent } from './nepokretnosti/nepokretnosti.component';
import { MeniComponent } from './meni/meni.component';

import {MatButtonModule} from '@angular/material/button';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatSidenavModule} from '@angular/material/sidenav'; 
import {MatExpansionModule} from '@angular/material';
import {MatDividerModule} from '@angular/material/divider';

import { HttpClientModule } from '@angular/common/http';
import { TipnosiocapComponent } from './sifarnici/tipnosiocap/tipnosiocap.component';
import { NamenazemComponent } from './sifarnici/namenazem/namenazem.component';
import { NamenaobjComponent } from './sifarnici/namenaobj/namenaobj.component';
import { VrstapravaComponent } from './sifarnici/vrstaprava/vrstaprava.component';
import { SpratnostComponent } from './sifarnici/spratnost/spratnost.component';

import {MatSortModule } from '@angular/material';
import {MatTableModule} from '@angular/material/table';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule } from '@angular/material';
import {MatIconModule} from '@angular/material/icon';

import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { GeoportalmkComponent } from './geoportalmk/geoportalmk.component';
import { NosiocipComponent } from './nepokretnosti/nosiocip/nosiocip.component';
import { ZemljisteComponent } from './nepokretnosti/zemljiste/zemljiste.component';
import { ObjektiComponent } from './nepokretnosti/objekti/objekti.component';
import { PravozemComponent } from './nepokretnosti/pravozem/pravozem.component';
import { PravoobjComponent } from './nepokretnosti/pravoobj/pravoobj.component';
import { InfoComponent } from './geoportal/info/info.component';

import { MatDialogModule } from '@angular/material';

import {MatSelectModule} from '@angular/material/select';





@NgModule({
  declarations: [
    AppComponent,
    GeoportalComponent,    
    NepokretnostiComponent,
    MeniComponent,
    TipnosiocapComponent,
    GeoportalmkComponent,
    NosiocipComponent,
    ZemljisteComponent,
    ObjektiComponent,
    PravozemComponent,
    PravoobjComponent,
    NamenazemComponent,
    NamenaobjComponent,
    VrstapravaComponent,
    SpratnostComponent,
    InfoComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule, MatCheckboxModule, MatSidenavModule, MatExpansionModule, MatSortModule,
    MatTableModule,MatFormFieldModule, MatIconModule,

    FormsModule, ReactiveFormsModule, MatInputModule,MatDividerModule,
    MatDialogModule,MatSelectModule

  ],
  exports: [
            InfoComponent,
                  ],
  entryComponents: [
    InfoComponent
  ],                    
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
