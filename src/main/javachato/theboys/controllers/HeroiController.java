package paradigmas.theboys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import paradigmas.theboys.dto.HeroiDTO;
import paradigmas.theboys.entities.Heroi;
import paradigmas.theboys.repositories.HeroiRepository;
import paradigmas.theboys.services.HeroiService;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/heroi")
public class HeroiController {

    @Autowired
    private HeroiRepository heroiRepository;
    @Autowired
    private HeroiService heroiService;

    @PostMapping
    public ResponseEntity<HeroiDTO> criarHeroi(@RequestBody Heroi heroi) {
        Heroi novoHeroi = heroiRepository.save(heroi);
        HeroiDTO heroiDTO = new HeroiDTO(novoHeroi);
        return ResponseEntity.status(201).body(heroiDTO);
    }

    @PatchMapping("/atualizarHeroi/{heroiId}")
    public ResponseEntity<HeroiDTO> atualizarHeroi(@PathVariable Integer heroiId, @RequestBody Map<String, Object> camposAtualizados) {
        try {
            Heroi heroiExistente = heroiRepository.findById(heroiId)
                    .orElseThrow(() -> new RuntimeException("Herói não encontrado com o ID: " + heroiId));

            camposAtualizados.forEach((campo, valor) -> {
                switch (campo) {
                    case "nome":
                        if (valor instanceof String) heroiExistente.setNome((String) valor);
                        break;
                    case "idade":
                        if (valor instanceof Integer) heroiExistente.setIdade((Integer) valor);
                        break;
                    case "sexo":
                        if (valor instanceof String) heroiExistente.setSexo((String) valor);
                        break;
                    case "caracteristicasFisicas":
                        if (valor instanceof String) heroiExistente.setCaracteristicasFisicas((String) valor);
                        break;
                    case "poderes":
                        if (valor instanceof String) heroiExistente.setPoderes((String) valor);
                        break;
                    case "forca":
                        if (valor instanceof Integer) heroiExistente.setForca((Integer) valor);
                        break;
                    case "popularidade":
                        if (valor instanceof Integer) heroiExistente.setPopularidade((Integer) valor);
                        break;
                    case "status":
                        if (valor instanceof String) heroiExistente.setStatus((String) valor);
                        break;
                    case "historicoBatalhas":
                        if (valor instanceof String) heroiExistente.setHistoricoBatalhas((String) valor);
                        break;
                    default:
                        throw new IllegalArgumentException("Campo não suportado: " + campo);
                }
            });

            Heroi heroiSalvo = heroiRepository.save(heroiExistente);
            HeroiDTO heroiDTO = new HeroiDTO(heroiSalvo);
            return ResponseEntity.ok(heroiDTO);

        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{heroiId}")
    public ResponseEntity<Void> deletarHeroi(@PathVariable Integer heroiId) {
        try {
            if (!heroiRepository.existsById(heroiId)) {
                return ResponseEntity.notFound().build();
            }

            heroiRepository.deleteById(heroiId);

            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<HeroiDTO>> buscarTodosHerois() {
        List<Heroi> herois = heroiRepository.findAll();

        List<HeroiDTO> heroisDTO = herois.stream()
                .map(HeroiDTO::new)
                .toList();

        return ResponseEntity.ok(heroisDTO);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<HeroiDTO>> buscarHeroiPorNome(@PathVariable String nome) {
        List<HeroiDTO> heroi = heroiService.buscarPorNome(nome);
        if (heroi.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(heroi);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<HeroiDTO>> buscarHeroiPorStatus(@PathVariable String status) {
        List<HeroiDTO> heroi = heroiService.buscarPorStatus(status);
        if (heroi.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(heroi);
    }

    @GetMapping("/popularidade/{popularidade}")
    public ResponseEntity<List<HeroiDTO>> buscarHeroiPorPopularidade(@PathVariable Integer popularidade) {
        List<HeroiDTO> heroi = heroiService.buscarPorPopularidade(popularidade);
        if (heroi.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(heroi);
    }
}
