import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { RegisterComponent } from './register/register.component';
import { RegisterTeacherComponent } from './register-teacher/register-teacher.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { StudentComponent } from './student/student.component';
import { TeacherComponent } from './teacher/teacher.component';
import { AdminComponent } from './admin/admin.component';
import { UserDetailsComponent } from './user-details/user-details.component';


const routes: Routes = [
    {
        path: 'profile',
        component: HomeComponent
    },
    {
        path: 'student',
        component: StudentComponent
    },
    {
        path: 'teacher',
        component: TeacherComponent
    },
    {
        path: 'admin',
        component: AdminComponent
    },
    {
        path: 'auth/login',
        component: LoginComponent
    },
    {
        path: 'addStudent',
        component: RegisterComponent
    },
    {
        path: 'addTeacher',
        component: RegisterTeacherComponent
    },
    {
        path: '',
        redirectTo: 'home',
        pathMatch: 'full'
    },
    { path: 'users', component: AdminComponent },
    { path: 'details/:id', component: UserDetailsComponent },
   
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
