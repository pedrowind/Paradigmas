package paradigmas.theboys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import paradigmas.theboys.entities.Missoes;

import java.util.List;

public interface MissoesRepository extends JpaRepository<Missoes, Long> {
    List<Missoes> findMissoesByDificuldadeMissao(Integer dificuldadeMissao);
}
