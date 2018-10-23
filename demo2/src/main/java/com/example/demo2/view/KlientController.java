package com.example.demo2.view;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.dao.KlientRepository;
import com.example.demo2.model.Klient;
import com.example.demo2.services.KlientService;

@RestController
@RequestMapping("/klienci")
public class KlientController {

	private static final Logger LOG = LoggerFactory.getLogger(KlientController.class);

	@Autowired
	private KlientRepository klientRepository;
	private KlientService klientService;
	
	
	public KlientController(KlientService klientService) {
		this.klientService = klientService;
	}

	@GetMapping("/")
	public List<Klient> klienci() {

		return klientRepository.findAll();
	}

	@GetMapping("/{id}")
	public Klient klient(@PathVariable Long id) {

		
		return klientRepository.findById(id).get();
	}
	
	@GetMapping("/szukaj")
	public Klient szukaj(@RequestParam String nazwisko) {

		
		return klientRepository.findByNazwisko(nazwisko);
	}

	@PostMapping("/")
	public Klient nowyKlient(@RequestBody Klient klient) {
		LOG.info("dodaję klienta={}", klient);

		klient = klientRepository.save(klient);
		return klient;
	}
	
	@PostMapping("/nowy")
	public Klient nowyKlient2(@RequestBody Klient klient) {
		LOG.info("dodaję klienta={}", klient);

		klient = klientService.nowyKlient(klient);
		return klient;
	}

}
