package com.resaSmile.ResaSmile.Controller;


import com.resaSmile.ResaSmile.Service.AdminSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminSer adminSer;

    @GetMapping("/reservations")
    public ResponseEntity<?> gererReservations() {
        // Logique de gestion des réservations
        return null; // À implémenter
    }

    @GetMapping("/utilisateurs")
    public ResponseEntity<?> gererUtilisateurs() {
        // Logique de gestion des utilisateurs
        return null; // À implémenter
    }

    @GetMapping("/ordinateurs")
    public ResponseEntity<?> gererOrdinateurs() {
        // Logique de gestion des ordinateurs
        return null; // À implémenter
    }
}
