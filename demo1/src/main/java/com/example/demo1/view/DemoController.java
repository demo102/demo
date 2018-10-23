package com.example.demo1.view;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.Utils;

@RestController
@RequestMapping("/demo")
public class DemoController {
	private final static Logger LOG = LoggerFactory.getLogger(DemoController.class);

	@Autowired
	private Utils utils;
	
	// http://localhost:7070/demo/hello
	@GetMapping("/hello")
	public ResponseEntity<?> hello() {
		LOG.debug("hello");

		Map<String, Object> response = new HashMap<>();

		String hello = "Hello ";

		response.put("message", hello);
		response.put("uuid", utils.uuid());

		return ResponseEntity.ok(response);
	}

	// http://localhost:7070/demo/hello/2
	@GetMapping("/hello/2")
	public ResponseEntity<?> hello2() {
		LOG.debug("hello2");
		Map<String, Object> response = new HashMap<>();

		String hello = "Hello ";

		response.put("message", hello);
		response.put("now", new Date());

		return ResponseEntity.ok(response);
	}

	// http://localhost:7070/demo/hello/3/ala ma kota
	@GetMapping("/hello/3/{input}")
	public ResponseEntity<?> hello3(@PathVariable String input) {
		LOG.debug("hello3");
		Map<String, Object> response = new HashMap<>();

		String hello = "Hello ";

		response.put("message", hello);
		response.put("now", new Date());
		if (StringUtils.hasText(input)) {
			response.put("input", input);
		}

		return ResponseEntity.ok(response);
	}

	// http://localhost:7070/demo/hello/4?input=ala ma kota
	@GetMapping("/hello/4")
	public ResponseEntity<?> hello4(@RequestParam String input) {
		LOG.debug("hello4");
		Map<String, Object> response = new HashMap<>();

		String hello = "Hello ";

		response.put("message", hello);
		response.put("now", new Date());
		if (StringUtils.hasText(input)) {
			response.put("input", input);
		}

		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/hello/5")
	public ResponseEntity<?> hello5(@RequestBody Map<String, String> body) {
		LOG.debug("hello5, body={}", body);
		Map<String, Object> response = new HashMap<>();

		String hello = "Hello ";

		response.put("message", hello);
		response.put("now", new Date());
		
		return ResponseEntity.ok(response);
	}
}
