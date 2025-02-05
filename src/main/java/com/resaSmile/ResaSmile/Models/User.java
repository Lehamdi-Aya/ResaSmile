package com.resaSmile.ResaSmile.Models;

import jakarta.persistence.*;
import lombok.* ;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String mot_de_passe;

    @Enumerated(EnumType.STRING)
    private Role role;



    // Méthode d'authentification (exemple basique)
    public boolean authentifier(String email, String mot_de_passe) {
        return this.email.equals(email) && this.mot_de_passe.equals(mot_de_passe);
    }

    public List<Ordinateur> voirOrdinateurDisponibles() {
        // Logique pour voir les ordinateurs disponibles
        return null; // À implémenter
    }
}