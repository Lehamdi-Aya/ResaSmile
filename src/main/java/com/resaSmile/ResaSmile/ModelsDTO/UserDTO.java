package com.resaSmile.ResaSmile.ModelsDTO;

import com.resaSmile.ResaSmile.Models.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String nom;
    private String prenom;
    private String email;
    private String mot_de_passe;
    private Role role;

}
