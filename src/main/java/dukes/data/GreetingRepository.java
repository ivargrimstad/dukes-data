package dukes.data;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

@Repository
public interface GreetingRepository extends CrudRepository<Greeting, Long> {
}
