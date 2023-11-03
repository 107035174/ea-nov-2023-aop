package lab4.lab4.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lab4.lab4.Model.Address;


@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {

}
