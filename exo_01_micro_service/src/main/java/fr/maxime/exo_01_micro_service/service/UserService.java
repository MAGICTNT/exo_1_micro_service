package fr.maxime.exo_01_micro_service.service;

import fr.maxime.exo_01_micro_service.entity.User;
import fr.maxime.exo_01_micro_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getById(long userId){
        return userRepository.findById(userId).orElse(null);
    }

    public User save(User user){
        return userRepository.save(user);
    }
}
