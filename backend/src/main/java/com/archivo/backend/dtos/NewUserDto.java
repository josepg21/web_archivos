package com.archivo.backend.dtos;

import com.archivo.backend.enums.RoleList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewUserDto {
    public String userName;
    public String password;
    public RoleList role; // Nuevo campo
}
