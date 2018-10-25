package com.example.schronisko.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.schronisko.dao.PiesRepository;
import com.example.schronisko.model.Pies;

@Service
public class PiesService {

	private final static Logger LOG = LoggerFactory.getLogger(PiesService.class);

	@Autowired
	private PiesRepository piesRepository;

	public Pies zapiszPsa(Pies pies) {
		LOG.debug("zapisuje psa");

		return piesRepository.save(pies);
	}
}
