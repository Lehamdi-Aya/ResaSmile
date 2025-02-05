package com.resaSmile.ResaSmile.Models;

public class Employe {
    private User user;

    public Employe(User user) {
        if (user.getRole() != Role.EMPLOYE) {
            throw new IllegalArgumentException("L'utilisateur doit avoir le rôle EMPLOYE");
        }
        this.user = user;
    }

    public void sInscrire() {
        // Logique d'inscription
    }

    public void reserverOrdinateur(/* paramètres nécessaires */) {
        // Logique pour réserver une place
    }

    public void annulerReservation(/* paramètres nécessaires */) {
        // Logique pour annuler une réservation
    }
}
