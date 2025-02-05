package com.resaSmile.ResaSmile.Models;


public class Admin {
    private User user;

    public Admin(User user) {
        if (user.getRole() != Role.ADMIN) {
            throw new IllegalArgumentException("L'utilisateur doit avoir le rôle ADMIN");
        }
        this.user = user;
    }

    public void gererReservations() {
        // Logique pour gérer les réservations
    }

    public void gererUtilisateurs() {
        // Logique pour gérer les utilisateurs
    }

    public void gererOrdinateurs() {
        // Logique pour gérer les ordinateurs
    }
}