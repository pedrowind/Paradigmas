package paradigmas.theboys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import paradigmas.theboys.entities.Crimes;
import paradigmas.theboys.entities.Heroi;

import java.util.List;


public interface CrimesRepository extends JpaRepository<Crimes, Long> {
    List<Crimes> findBySeveridadeCrime(Integer severidadeCrime);
    List<Crimes> findByHeroiResponsavel(String heroiResponsavel);
}
