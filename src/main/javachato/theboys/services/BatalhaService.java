package paradigmas.theboys.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import paradigmas.theboys.dto.BatalhaDTO;
import paradigmas.theboys.entities.Batalha;
import paradigmas.theboys.entities.Heroi;
import paradigmas.theboys.repositories.BatalhaRepository;
import paradigmas.theboys.repositories.HeroiRepository;

import java.util.List;


@Service
public class BatalhaService {

    private final HeroiRepository heroiRepository;
    private final BatalhaRepository batalhaRepository;


    public BatalhaService(HeroiRepository heroiRepository, BatalhaRepository batalhaRepository) {
        this.heroiRepository = heroiRepository;
        this.batalhaRepository = batalhaRepository;
    }

    @Transactional
    public BatalhaDTO realizarBatalha(Integer heroi1Id, Integer heroi2Id) {
        Heroi heroi1 = heroiRepository.findById(heroi1Id)
                .orElseThrow(() -> new RuntimeException("Herói 1 não encontrado"));
        Heroi heroi2 = heroiRepository.findById(heroi2Id)
                .orElseThrow(() -> new RuntimeException("Herói 2 não encontrado"));

        int danoHeroi1 = Math.max(heroi1.getAtaque() - heroi2.getDefesa(), 0);
        int danoHeroi2 = Math.max(heroi2.getAtaque() - heroi1.getDefesa(), 0);

        heroi1.setVida(heroi1.getVida() - danoHeroi2);
        heroi2.setVida(heroi2.getVida() - danoHeroi1);

        String resultado;
        if (heroi1.getVida() <= 0 && heroi2.getVida() <= 0) {
            resultado = "Empate!";
        } else if (heroi1.getVida() <= 0) {
            resultado = heroi2.getNome() + " venceu!";
        } else if (heroi2.getVida() <= 0) {
            resultado = heroi1.getNome() + " venceu!";
        } else {
            resultado = "Batalha em andamento";
        }

        heroiRepository.save(heroi1);
        heroiRepository.save(heroi2);

        Batalha batalha = new Batalha(heroi1, heroi2, resultado, heroi1.getVida(), heroi2.getVida());
        batalhaRepository.save(batalha);

        return new BatalhaDTO(batalha);
    }

    public List<BatalhaDTO> listarBatalhas() {
        List<Batalha> batalhas = batalhaRepository.findAll();
        return batalhas.stream()
                .map(BatalhaDTO::new)
                .toList();
    }
}