package paradigmas.theboys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import paradigmas.theboys.dto.CrimesDTO;
import paradigmas.theboys.entities.Crimes;
import paradigmas.theboys.repositories.CrimesRepository;
import paradigmas.theboys.services.CrimesService;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/crimes")
public class CrimesController {

    @Autowired
    private CrimesRepository crimesRepository;

    @Autowired
    private CrimesService crimesService;

    @PostMapping
    public ResponseEntity<CrimesDTO> criarCrime(@RequestBody Crimes crimes) {
        Crimes novoCrime = crimesRepository.save(crimes);
        CrimesDTO novoCrimeDTO = new CrimesDTO(novoCrime);
        return ResponseEntity.ok(novoCrimeDTO);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CrimesDTO> atualizarCrimes(@PathVariable Long id, @RequestBody Map<String, Object> camposAtualizados) {
        try {
            Crimes crimesExistente = crimesRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Crime não encontrado com o ID: " + id));

            camposAtualizados.forEach((campo, valor) -> {
                switch (campo) {
                    case "nomeCrime":
                        crimesExistente.setNomeCrime((String) valor);
                        break;
                    case "descricaoCrime":
                        crimesExistente.setDescricaoCrime((String) valor);
                        break;
                    case "dataCrime":
                        crimesExistente.setDataCrime((Date) valor);
                        break;
                    case "heroiResponsavel":
                        crimesExistente.setheroiResponsavel((String) valor);
                        break;
                    case "severidadeCrime":
                        crimesExistente.setSeveridadeCrime((Integer) valor);
                        break;
                    default:
                        throw new IllegalArgumentException("Campo não suportado: " + campo);
                }
            });

            Crimes crimesSalvo = crimesRepository.save(crimesExistente);
            CrimesDTO crimesSalvoDTO = new CrimesDTO(crimesSalvo);
            return ResponseEntity.ok(crimesSalvoDTO);

        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{crimeId}")
    public ResponseEntity<CrimesDTO> deletarCrimes(@PathVariable Long crimeId) {
        try {
            if (!crimesRepository.existsById(crimeId)) {
                return ResponseEntity.notFound().build();
            }

            crimesRepository.deleteById(crimeId);

            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<CrimesDTO>> buscarTodosCrimes() {
        List<Crimes> crimes = crimesRepository.findAll();

        List<CrimesDTO> crimesDTO = crimes.stream()
                .map(CrimesDTO::new)
                .toList();

        return ResponseEntity.ok(crimesDTO);
    }

    @GetMapping("/heroi/{heroiResponsavel}")
    public ResponseEntity<List<CrimesDTO>> buscarCrimesPorHeroi(@PathVariable String heroiResponsavel) {
        List<CrimesDTO> crimes = crimesService.buscarCrimesPorHeroi(heroiResponsavel);
        if (crimes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(crimes);
    }

    @GetMapping("/severidade/{severidade}")
    public ResponseEntity<List<CrimesDTO>> buscarPorSeveridade(@PathVariable Integer severidade) {
        List<CrimesDTO> resultados = crimesService.buscarPorSeveridadeCrime(severidade);
        if (resultados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resultados);
    }
}
