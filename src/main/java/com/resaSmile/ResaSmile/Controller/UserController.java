package com.resaSmile.ResaSmile.Controller;


import com.resaSmile.ResaSmile.Service.UserSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserSer userSer;

    @PostMapping("/login")
    public <LoginRequest> ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // Logique d'authentification
        return null; // À implémenter
    }

    @GetMapping("/places-disponibles")
    public ResponseEntity<?> getPlacesDisponibles() {
        // Logique pour obtenir les places disponibles
        return null; // À implémenter
    }
}
