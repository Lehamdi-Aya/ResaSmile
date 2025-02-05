package com.resaSmile.ResaSmile.Service;

import com.resaSmile.ResaSmile.Models.User;
import com.resaSmile.ResaSmile.Models.Ordinateur;
import com.resaSmile.ResaSmile.Models.Reservation;
import com.resaSmile.ResaSmile.ModelsDTO.UserDTO;
import com.resaSmile.ResaSmile.ModelsDTO.ReservationDTO;
import com.resaSmile.ResaSmile.Repositories.UserRepo;
import com.resaSmile.ResaSmile.Repositories.OrdinateurRepo;
import com.resaSmile.ResaSmile.Repositories.ReservationRepo;
import com.resaSmile.ResaSmile.Mapper.UserMapper;
import com.resaSmile.ResaSmile.Mapper.ReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeSer {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private OrdinateurRepo ordinateurRepository;

    @Autowired
    private ReservationRepo reservationRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ReservationMapper reservationMapper;

    public UserDTO sInscrire(UserDTO userDTO) {
        User user = userMapper.userDTOToUser(userDTO);
        User savedUser = userRepo.save(user);
        return userMapper.userToUserDTO(savedUser);
    }

    public ReservationDTO reserverOrdinateur(Long userId, Long ordinateurId, ReservationDTO reservationDTO) {
        Optional<User> user = userRepo.findById(userId);
        Optional<Ordinateur> ordinateur = ordinateurRepository.findById(ordinateurId);

        if (user.isPresent() && ordinateur.isPresent()) {
            Reservation reservation = reservationMapper.reservationDTOToReservation(reservationDTO);
            reservation.setUser(user.get());
            reservation.setOrdinateur(ordinateur.get());

            Reservation savedReservation = reservationRepository.save(reservation);
            return reservationMapper.reservationToReservationDTO(savedReservation);
        }

        return null; // Ou lancez une exception appropriée
    }

    public void annulerReservation(Long reservationId) {
        Optional<Reservation> reservation = reservationRepository.findById(reservationId);
        if (reservation.isPresent()) {
            reservationRepository.delete(reservation.get());
        } else {
            // Lancez une exception appropriée
        }
    }
}
