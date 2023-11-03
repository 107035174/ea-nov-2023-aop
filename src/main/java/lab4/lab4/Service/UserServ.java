package lab4.lab4.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lab4.lab4.Model.User;
import lab4.lab4.Repository.UserRepo;

@Service
public class UserServ {
    @Autowired
    private UserRepo userRepo;

    @Transactional
    public User save(User user) {
        return userRepo.save(user);
    }

    public Optional<User> findById(Long id) {
        return userRepo.findById(id);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Transactional
    public User update(Long id, User user) {
        Optional<User> optionalToBeUpdated = userRepo.findById(id);
        if (optionalToBeUpdated.isPresent()) {
            User toBeUpdated = optionalToBeUpdated.get();
            if (user.getEmail() != null) {
                toBeUpdated.setEmail(user.getEmail());
            }
            return userRepo.save(toBeUpdated);
        } else {
            throw new IllegalArgumentException("Catagory with id " + id + " not found.");
        }
    }

    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }

}
