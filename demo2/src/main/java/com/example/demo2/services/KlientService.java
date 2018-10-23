package com.example.demo2.services;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo2.dao.KlientRepository;
import com.example.demo2.model.Klient;

@Service
public class KlientService {

	private static final Logger LOG = LoggerFactory.getLogger(KlientService.class);
	private final KlientRepository klientDAO;

	public KlientService(KlientRepository klientDAO) {
		this.klientDAO = klientDAO;
	}

	public Klient nowyKlient(Klient k) {
		LOG.debug("dodaje klienta={}", k);
		Date now = new Date();
		
		k.setDataUtworzenia(now);
		
		klientDAO.save(k);
		
		return k;
	}

}
