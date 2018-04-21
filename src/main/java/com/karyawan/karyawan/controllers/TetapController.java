package com.karyawan.karyawan.controllers;

import com.karyawan.karyawan.dto.TetapDTO;
import com.karyawan.karyawan.models.Tetap;
import com.karyawan.karyawan.repositories.TetapRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TetapController {
    private final Logger log = LoggerFactory.getLogger(TetapController.class);
    private final TetapRepository tetapRepository;

    public TetapController(TetapRepository tetapRepository) {
        this.tetapRepository = tetapRepository;
    }

    @GetMapping("/get/karyawan/tetap")
    public ResponseEntity<List<Tetap>> getKaryawanTetap(){
        log.debug("REST request to get a All List Karyawan Tetap");
        List<Tetap> tetapList = tetapRepository.findAll();
        return new ResponseEntity<>(tetapList, HttpStatus.OK);
    }

    @PostMapping("/create/karyawan/tetap")
    public ResponseEntity<TetapDTO> createKaryawanTetap(@Valid @RequestBody Tetap tetap) throws URISyntaxException {
        log.debug("REST request to save Karyawan Tetap : {}", tetap);
        TetapDTO tetapDTO = new TetapDTO();
        if (tetap.getId() != null){
            tetapDTO.setErrorMsg("ID Already Exist");
            return ResponseEntity.badRequest().body(tetapDTO);
        }
        Tetap result = tetapRepository.save(tetap);
        tetapDTO.setTetap(result);
        tetapDTO.setErrorMsg("Nothing");
        return ResponseEntity.ok().body(tetapDTO);
    }

    @PutMapping("/update/karyawan/tetap")
    public ResponseEntity<TetapDTO> updateKaryawanTetap(@Valid @RequestBody Tetap tetap) throws URISyntaxException {
        log.debug("REST request to update Karyawan Tetap : {}", tetap);
        if (tetap.getId() == null){
            return createKaryawanTetap(tetap);
        }
        Tetap result = tetapRepository.save(tetap);
        TetapDTO tetapDTO = new TetapDTO();
        tetapDTO.setErrorMsg("Nothing");
        tetapDTO.setTetap(result);
        return ResponseEntity.ok().body(tetapDTO);
    }

    @DeleteMapping("/delete/karyawan/tetap/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        log.debug("REST request to delete Karyawan Tetap by ID = " + id);
        tetapRepository.delete(id);
        return ResponseEntity.ok().build();
    }
}
