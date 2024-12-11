package paradigmas.theboys.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import paradigmas.theboys.dto.CrimesDTO;
import paradigmas.theboys.entities.Crimes;
import paradigmas.theboys.repositories.CrimesRepository;

import java.util.List;

@Component
public class CrimesService {

    @Autowired
    private CrimesRepository crimesRepository;

    @Transactional(readOnly = true)
    public List<CrimesDTO> buscarPorSeveridadeCrime(Integer severidadeCrime) {
        List<Crimes> resultados = crimesRepository.findBySeveridadeCrime(severidadeCrime);

        return resultados.stream()
                .map(CrimesDTO::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<CrimesDTO> buscarCrimesPorHeroi(String heroiResponsavel) {
        List<Crimes> crimes = crimesRepository.findByHeroiResponsavel(heroiResponsavel);
        return crimes.stream()
                .map(CrimesDTO::new)
                .toList();
    }
}