package paradigmas.theboys.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import paradigmas.theboys.dto.HeroiDTO;
import paradigmas.theboys.entities.Heroi;
import paradigmas.theboys.repositories.HeroiRepository;

import java.util.List;

@Component
public class HeroiService {

    @Autowired
    private HeroiRepository heroiRepository;

    @Transactional(readOnly = true)
    public List<HeroiDTO> buscarPorNome(String nome) {
        List<Heroi> resultados = heroiRepository.findHeroiByNome(nome);

        return resultados.stream()
                .map(HeroiDTO::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<HeroiDTO> buscarPorStatus(String status) {
        List<Heroi> resultados = heroiRepository.findHeroiByStatus(status);

        return resultados.stream()
                .map(HeroiDTO::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<HeroiDTO> buscarPorPopularidade(Integer popularidade) {
        List<Heroi> resultados = heroiRepository.findHeroiByPopularidade(popularidade);

        return resultados.stream()
                .map(HeroiDTO::new)
                .toList();
    }
}
