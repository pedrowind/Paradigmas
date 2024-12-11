package paradigmas.theboys.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import paradigmas.theboys.dto.BatalhaDTO;
import paradigmas.theboys.services.BatalhaService;

import java.util.List;

@RestController
@RequestMapping("/batalha")
public class BatalhaController {

    private final BatalhaService batalhaService;

    public BatalhaController(BatalhaService batalhaService) {
        this.batalhaService = batalhaService;
    }

    @PostMapping
    public ResponseEntity<BatalhaDTO> realizarBatalha(@RequestParam Integer heroi1Id, @RequestParam Integer heroi2Id) {
        BatalhaDTO batalha = batalhaService.realizarBatalha(heroi1Id, heroi2Id);
        return ResponseEntity.ok(batalha);
    }

    @GetMapping
    public ResponseEntity<List<BatalhaDTO>> listarBatalhas() {
        List<BatalhaDTO> batalhas = batalhaService.listarBatalhas();
        return ResponseEntity.ok(batalhas);
    }
}