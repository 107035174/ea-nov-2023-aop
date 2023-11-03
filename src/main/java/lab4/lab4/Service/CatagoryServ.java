package lab4.lab4.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lab4.lab4.Model.Catagory;
import lab4.lab4.Repository.CatagoryRepo;

@Service
public class CatagoryServ {
    @Autowired
    private CatagoryRepo catagoryRepo;

    @Transactional
    public Catagory save(Catagory catagory) {
        return catagoryRepo.save(catagory);
    }

    public Optional<Catagory> findById(Long id) {
        return catagoryRepo.findById(id);
    }

    public List<Catagory> findAll() {
        return catagoryRepo.findAll();
    }

    @Transactional
    public Catagory update(Long id, Catagory catagory) {
        Optional<Catagory> optionalToBeUpdated = catagoryRepo.findById(id);
        if (optionalToBeUpdated.isPresent()) {
            Catagory toBeUpdated = optionalToBeUpdated.get();
            if (catagory.getName() != null) {
                toBeUpdated.setName(catagory.getName());
            }
            return catagoryRepo.save(toBeUpdated);
        } else {
            throw new IllegalArgumentException("Catagory with id " + id + " not found.");
        }
    }

    public void deleteById(Long id) {
        catagoryRepo.deleteById(id);
    }
}
