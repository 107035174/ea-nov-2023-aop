package lab4.lab4.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lab4.lab4.Model.Address;
import lab4.lab4.Service.AddressServ;


@RestController
@RequestMapping("/addresses")
public class AddressController {
    @Autowired
    private AddressServ addressServ;

    @PostMapping("/")
    public ResponseEntity<Address> create(@RequestBody Address address) {
        Address created = addressServ.save(address);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> get(@PathVariable Long id) {
        Optional<Address> address = addressServ.findById(id);
        return address.map(data -> new ResponseEntity<>(data, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/")
    public List<Address> get() {
        return addressServ.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> edit(@PathVariable Long id, @RequestBody Address address) {
        try {
            Address updated = addressServ.update(id, address);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id) {
        try {
            addressServ.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
