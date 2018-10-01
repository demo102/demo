package com.example.demo;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo/v1")
public class DemoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4859138034275638734L;
	private static final Logger LOG = LoggerFactory.getLogger(DemoController.class);

	@GetMapping("/")
	public ResponseEntity<?> getHostInfo() {
		ResponseEntity<?> response = ResponseEntity.badRequest().build();

		Map<String, Object> data = new HashMap<>();

		try {
			data.put("hostname", InetAddress.getLocalHost().getHostName());
			data.put("hostaddress", InetAddress.getLocalHost().getHostAddress());
			response = ResponseEntity.ok(data);
		} catch (Exception e) {
			LOG.error("error", e);
		}

		return response;

	}

}
