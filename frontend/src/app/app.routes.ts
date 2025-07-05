import { Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { NavigationComponent } from './pages/navigation/navigation.component';
import { NotFoundComponent } from './not-found/not-found.component';

import { StafflistComponent } from './pages/Staff/stafflist/stafflist.component';
import { StaffregComponent } from './pages/Staff/staffreg/staffreg.component';
import { StorieEntryComponent } from './pages/Storie/storie-entry/storie-entry.component';
import { StorieLoansComponent } from './pages/Storie/storie-loans/storie-loans.component';
import { StorieMovesComponent } from './pages/Storie/storie-moves/storie-moves.component';
import { StorieReturnsComponent } from './pages/Storie/storie-returns/storie-returns.component';
import { StorieSearchComponent } from './pages/Storie/storie-search/storie-search.component';

export const routes: Routes = [
    { path: '', component: LoginComponent },
    { 
        path: 'navigation', 
        component: NavigationComponent,
        children: [
            { path: 'stafflist', component: StafflistComponent },
            { path: 'staffreg', component: StaffregComponent },
            { path: 'storie-entry', component: StorieEntryComponent },
            { path: 'storie-loans', component: StorieLoansComponent },
            { path: 'storie-moves', component: StorieMovesComponent },
            { path: 'storie-returns', component: StorieReturnsComponent },
            { path: 'storie-search', component: StorieSearchComponent },
            // Redirección por defecto o página inicial después de login
            { path: '**', component: NotFoundComponent },
            { path: '', redirectTo: 'staffreg', pathMatch: 'full' }
        ]
    },
    // Ruta global para /not-found
    { path: 'not-found', component: NotFoundComponent },
    // Redirección para cualquier ruta no definida
    { path: '**', redirectTo: '' }

];