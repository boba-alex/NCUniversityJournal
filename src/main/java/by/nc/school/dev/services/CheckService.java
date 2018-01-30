package by.nc.school.dev.services;

import by.nc.school.dev.entity.AppUser;

public class CheckService {
    public static boolean checkForTeacherRole(AppUser user){
        for(String role: user.getRoles())
        {
            if(role.equals("TEACHER")){
                return true;
            }
        }
        return false;
    }
}
