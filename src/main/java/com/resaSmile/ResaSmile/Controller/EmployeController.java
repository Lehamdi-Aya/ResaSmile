package com.resaSmile.ResaSmile.Controller;


import com.resaSmile.ResaSmile.Models.User;
import com.resaSmile.ResaSmile.Service.EmployeSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employes")
public class EmployeController {
    @Autowired
    private EmployeSer employeSer;

    @PostMapping("/inscription")
    public ResponseEntity<?> sInscrire(@RequestBody User user) {
        // Logique d'inscription
        return null; // À implémenter
    }

    @PostMapping("/reserver")
    public <ReservationRequest> ResponseEntity<?> reserverPlace(@RequestBody ReservationRequest request) {
        // Logique de réservation
        return null; // À implémenter
    }

    @PostMapping("/annuler")
    public <AnnulationRequest> ResponseEntity<?> annulerReservation(@RequestBody AnnulationRequest request) {
        // Logique d'annulation
        return null; // À implémenter
    }
}
