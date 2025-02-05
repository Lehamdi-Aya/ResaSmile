package com.resaSmile.ResaSmile.Service;

import com.resaSmile.ResaSmile.ModelsDTO.UserDTO;
import com.resaSmile.ResaSmile.ModelsDTO.ReservationDTO;
import com.resaSmile.ResaSmile.ModelsDTO.OrdinateurDTO;
import com.resaSmile.ResaSmile.Repositories.UserRepo;
import com.resaSmile.ResaSmile.Repositories.ReservationRepo;
import com.resaSmile.ResaSmile.Repositories.OrdinateurRepo;
import com.resaSmile.ResaSmile.Mapper.UserMapper;
import com.resaSmile.ResaSmile.Mapper.ReservationMapper;
import com.resaSmile.ResaSmile.Mapper.OrdinateurMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {
    @Autowired
    private UserRepo userRepository;

    @Autowired
    private ReservationRepo reservationRepository;

    @Autowired
    private OrdinateurRepo ordinateurRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ReservationMapper reservationMapper;

    @Autowired
    private OrdinateurMapper ordinateurMapper;

    public List<ReservationDTO> gererReservations() {
        return reservationRepository.findAll().stream()
                .map(reservationMapper::reservationToReservationDTO)
                .collect(Collectors.toList());
    }

    public List<UserDTO> gererUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::userToUserDTO)
                .collect(Collectors.toList());
    }

    public List<OrdinateurDTO> gererOrdinateurs() {
        return ordinateurRepository.findAll().stream()
                .map(ordinateurMapper::ordinateurToOrdinateurDTO)
                .collect(Collectors.toList());
    }

    public ReservationDTO updateReservation(Long id, ReservationDTO reservationDTO) {
        // Logique pour mettre à jour une réservation
        return null; // À implémenter
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        // Logique pour mettre à jour un utilisateur
        return null; // À implémenter
    }

    public OrdinateurDTO updateOrdinateur(Long id, OrdinateurDTO ordinateurDTO) {
        // Logique pour mettre à jour un ordinateur
        return null; // À implémenter
    }

    // Ajoutez d'autres méthodes selon vos besoins
}
