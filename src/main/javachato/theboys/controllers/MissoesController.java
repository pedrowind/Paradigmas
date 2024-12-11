package paradigmas.theboys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import paradigmas.theboys.dto.MissoesDTO;
import paradigmas.theboys.entities.Missoes;
import paradigmas.theboys.repositories.MissoesRepository;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/missoes")
public class MissoesController {

    @Autowired
    private MissoesRepository missoesRepository;

    @PostMapping
    public ResponseEntity<MissoesDTO> criarMissoes(@RequestBody Missoes missoes) {
        Missoes novaMissao = missoesRepository.save(missoes);
        MissoesDTO missaoDTO = new MissoesDTO(novaMissao);
        return ResponseEntity.ok(missaoDTO);
    }

    @PatchMapping("/atualizarMissoes/{missaoId}")
    public ResponseEntity<MissoesDTO> atualizarMissoes(@PathVariable Long missaoId, @RequestBody Map<String, Object> camposAtualizados) {
        try {
            Missoes missoesExistente = missoesRepository.findById(missaoId)
                    .orElseThrow(() -> new RuntimeException("Missão não encontrada com o ID: " + missaoId));

            camposAtualizados.forEach((campo, valor) -> {
                switch (campo) {
                    case "nomeMissao":
                        missoesExistente.setNomeMissao((String) valor);
                        break;
                    case "descricaoMissao":
                        missoesExistente.setDescricaoMissao((String) valor);
                        break;
                    case "dificuldadeMissao":
                        missoesExistente.setDificuldadeMissao((Integer) valor);
                        break;
                    case "heroisDesignados":
                        missoesExistente.setHeroisDesignados((String) valor);
                        break;
                    case "resultadoMissao":
                        missoesExistente.setResultadoMissao((String) valor);
                        break;
                    case "recompensaMissao":
                        missoesExistente.setRecompensaMissao((String) valor);
                        break;
                    default:
                        throw new IllegalArgumentException("Campo não suportado: " + campo);
                }
            });

            Missoes missoesSalvo = missoesRepository.save(missoesExistente);
            MissoesDTO missaoDTO = new MissoesDTO(missoesSalvo); // Convertendo para DTO
            return ResponseEntity.ok(missaoDTO);

        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{missaoId}")
    public ResponseEntity<MissoesDTO> deletarMissoes (@PathVariable Long missaoId) {
        try {
            if (!missoesRepository.existsById(missaoId)) {
                return ResponseEntity.notFound().build();
            }

            missoesRepository.deleteById(missaoId);

            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<MissoesDTO>> buscarTodasMissoes() {
        List<Missoes> missoes = missoesRepository.findAll();

        List<MissoesDTO> missoesDTO = missoes.stream()
                .map(MissoesDTO::new)
                .toList();

        return ResponseEntity.ok(missoesDTO);
    }

    @GetMapping("/{dificuldadeMissao}")
    public ResponseEntity<List<MissoesDTO>> buscarMissoesPorDificuldade(@PathVariable Integer dificuldadeMissao) {
        List<Missoes> missoes = missoesRepository.findMissoesByDificuldadeMissao(dificuldadeMissao);

        List<MissoesDTO> missoesDTO = missoes.stream()
                .map(MissoesDTO::new)
                .toList();

        return ResponseEntity.ok(missoesDTO);
    }
}
