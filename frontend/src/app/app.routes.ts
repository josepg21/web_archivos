import { Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { NavigationComponent } from './pages/navigation/navigation.component';
import { NotFoundComponent } from './not-found/not-found.component';

import { StafflistComponent } from './pages/Staff/stafflist/stafflist.component';
import { StaffregComponent } from './pages/Staff/staffreg/staffreg.component';
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
            { path: 'storie-loans', component: StorieLoansComponent },
            { path: 'storie-moves', component: StorieMovesComponent },
            { path: 'storie-returns', component: StorieReturnsComponent },
            { path: 'storie-search', component: StorieSearchComponent },
            { path: '', redirectTo: 'staffreg', pathMatch: 'full' },
            { path: '**', component: NotFoundComponent }
        ]
    },
    { path: 'not-found', component: NotFoundComponent },
    { path: '**', component: NotFoundComponent }
];