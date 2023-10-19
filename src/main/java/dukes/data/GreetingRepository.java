package dukes.data;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

import java.util.Optional;

@Repository
public interface GreetingRepository extends CrudRepository<Greeting, Long>{

    Optional<Greeting> findByNameIgnoreCase(String name);
}
