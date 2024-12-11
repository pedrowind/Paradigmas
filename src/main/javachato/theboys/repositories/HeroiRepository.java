package paradigmas.theboys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import paradigmas.theboys.entities.Heroi;

import java.util.List;

public interface HeroiRepository extends JpaRepository<Heroi, Integer> {
    List<Heroi> findHeroiByNome(String nome);
    List<Heroi> findHeroiByStatus(String status);
    List<Heroi> findHeroiByPopularidade(Integer popularidade);
}
