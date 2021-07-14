import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { GeoportalComponent } from './geoportal/geoportal.component';
import { NosiocipComponent } from './nepokretnosti/nosiocip/nosiocip.component';
import { TipnosiocapComponent } from './sifarnici/tipnosiocap/tipnosiocap.component';
import { ZemljisteComponent } from './nepokretnosti/zemljiste/zemljiste.component';
import { ObjektiComponent } from './nepokretnosti/objekti/objekti.component';
import { PravozemComponent } from './nepokretnosti/pravozem/pravozem.component';
import { PravoobjComponent } from './nepokretnosti/pravoobj/pravoobj.component';
import { NamenazemComponent } from './sifarnici/namenazem/namenazem.component';
import { NamenaobjComponent } from './sifarnici/namenaobj/namenaobj.component';
import { VrstapravaComponent } from './sifarnici/vrstaprava/vrstaprava.component';
import { SpratnostComponent } from './sifarnici/spratnost/spratnost.component';

import { GeoportalmkComponent } from './geoportalmk/geoportalmk.component';

const routes: Routes = [
    { path: 'geoportal', component: GeoportalComponent },
    { path: 'nosiocip', component: NosiocipComponent }, 
    { path: 'sifarnici/tipnosiocap', component: TipnosiocapComponent }, 
    { path: 'geoportalmk', component: GeoportalmkComponent },
    { path: 'zemljiste', component: ZemljisteComponent },
    { path: 'objekti', component: ObjektiComponent },
    { path: 'pravozem', component: PravozemComponent },
    { path: 'pravoobj', component: PravoobjComponent },
    { path: 'sifarnici/namenazem', component: NamenazemComponent },
    { path: 'sifarnici/namenaobj', component: NamenaobjComponent },
    { path: 'sifarnici/vrstaprava', component: VrstapravaComponent },
    { path: 'sifarnici/spratnost', component: SpratnostComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
