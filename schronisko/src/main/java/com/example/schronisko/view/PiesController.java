package com.example.schronisko.view;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.schronisko.dao.PiesRepository;
import com.example.schronisko.model.Pies;
import com.example.schronisko.service.PiesService;

@RestController
@RequestMapping(value = "/psy")
public class PiesController {

	private final static Logger LOG = LoggerFactory.getLogger(PiesController.class);

	@Autowired
	private PiesRepository piesRepository;
	@Autowired
	private PiesService piesService;

	// http://localhost:8080/psy/
	@GetMapping("/")
	public List<Pies> psy() {
		LOG.info("pobieram psy");
		return piesRepository.findAll();
	}

	// http://localhost:8080/psy/1
	@GetMapping("/{id}")
	public Pies pies(@PathVariable Long id) {
		LOG.info("pobieram psa, id={}", id);
		return piesRepository.findById(id).get();
	}

	// http://localhost:8080/psy/
	/*
	 * { "nazwa": "Brutus", "rasa": "owczarek niemiecki", "uwagi": "Bardzo grozny!"
	 * }
	 */
	@PostMapping("/")
	public Pies zapiszPsa(@RequestBody Pies pies) {
		LOG.info("zapisuje psa");
//		pies = piesRepository.save(pies);
		pies = piesService.zapiszPsa(pies);
		return pies;
	}

	@PutMapping("/{id}")
	public Pies edytujPsa(@PathVariable Long id, @RequestBody Pies piesDto) {
		Pies pies = piesRepository.findById(id).get();
		pies.setNazwa(piesDto.getNazwa());
		pies.setRasa(piesDto.getRasa());
		pies.setUwagi(piesDto.getUwagi());

		pies = piesRepository.save(pies);
		return pies;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> usunPsa(@PathVariable Long id) {
		try {

			piesRepository.deleteById(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			LOG.error("Blad aplikacji", e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
