package paradigmas.theboys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import paradigmas.theboys.entities.Batalha;

public interface BatalhaRepository extends JpaRepository<Batalha, Integer> {
}