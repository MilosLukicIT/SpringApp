import { AuthorComponent } from './components/utility/author/author.component';
import { HomeComponent } from './components/utility/home/home.component';
import { AboutComponent } from './components/utility/about/about.component';
import { UcesnikComponent } from './components/main/ucesnik/ucesnik.component';
import { PredmetComponent } from './components/main/predmet/predmet.component';
import { SudComponent } from './components/main/sud/sud.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RocisteComponent } from './components/main/rociste/rociste.component';


const routes: Routes = [
  {path:'sud', component:SudComponent},
  {path:'ucesnik', component:UcesnikComponent},
  {path:'predmet', component:PredmetComponent},
  {path:'about', component:AboutComponent},
  {path:'home', component:HomeComponent},
  {path:'author', component:AuthorComponent},
  {path:'rociste', component:RocisteComponent},
  {path:'', redirectTo:'/home', pathMatch:'full'}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
