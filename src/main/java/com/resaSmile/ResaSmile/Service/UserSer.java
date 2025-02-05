package com.resaSmile.ResaSmile.Service;

import com.resaSmile.ResaSmile.Models.Ordinateur;
import com.resaSmile.ResaSmile.Models.User;
import com.resaSmile.ResaSmile.ModelsDTO.UserDTO;
import com.resaSmile.ResaSmile.ModelsDTO.UserLoginDTO;
import com.resaSmile.ResaSmile.ModelsDTO.UserProfileDTO;
import com.resaSmile.ResaSmile.Repositories.UserRepo;
import com.resaSmile.ResaSmile.Mapper.UserMapper;
import com.resaSmile.ResaSmile.Mapper.UserProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserSer {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserProfileMapper userProfileMapper;

    public UserProfileDTO authentifier(UserLoginDTO loginDTO) {
        Optional<User> user = userRepo.findByEmail(loginDTO.getEmail());
        if (user.isPresent() && user.get().getMot_de_passe().equals(loginDTO.getMot_de_passe())) {
            return userProfileMapper.userToUserProfileDTO(user.get());
        }
        return null; // Ou lancez une exception d'authentification
    }

    public List<Ordinateur> voirOrdinateurDisponibles() {
        System.out.println("Metthos voirOrdinateurDisponibles à implémenter ");
        // Cette méthode dépend de votre logique métier et de votre modèle de données
        // Voici un exemple basique :
        return null; // À implémenter selon votre logique métier
    }

    public UserProfileDTO createUser(UserDTO userDTO) {
        User user = userMapper.userDTOToUser(userDTO);
        User savedUser = userRepo.save(user);
        return userProfileMapper.userToUserProfileDTO(savedUser);
    }

    public UserProfileDTO getUserById(Long id) {
        Optional<User> user = userRepo.findById(id);
        return user.map(userProfileMapper::userToUserProfileDTO).orElse(null);
    }

    public List<UserProfileDTO> getAllUsers() {
        List<User> users = userRepo.findAll();
        return users.stream()
                .map(userProfileMapper::userToUserProfileDTO)
                .collect(Collectors.toList());
    }

    public UserProfileDTO updateUser(Long id, UserDTO userDTO) {
        Optional<User> existingUser = userRepo.findById(id);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setNom(userDTO.getNom());
            user.setPrenom(userDTO.getPrenom());
            user.setEmail(userDTO.getEmail());
            user.setRole(userDTO.getRole());
            // Ne mettez pas à jour le mot de passe ici, créez une méthode séparée pour cela
            User updatedUser = userRepo.save(user);
            return userProfileMapper.userToUserProfileDTO(updatedUser);
        }
        return null; // Ou lancez une exception utilisateur non trouvé
    }

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}
