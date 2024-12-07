package paradigmas.theboys.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import paradigmas.theboys.dto.MissoesDTO;
import paradigmas.theboys.entities.Missoes;
import paradigmas.theboys.repositories.MissoesRepository;

import java.util.List;

@Component
public class MissoesService {

    @Autowired
    private MissoesRepository missoesRepository;

    @Transactional(readOnly = true)
    public List<MissoesDTO> buscarMissoesPorDificuldade(Integer dificuldadeMissao) {
        List<Missoes> resultados = missoesRepository.findMissoesByDificuldadeMissao(dificuldadeMissao);

        return resultados.stream()
                .map(MissoesDTO::new)
                .toList();
    }
}
