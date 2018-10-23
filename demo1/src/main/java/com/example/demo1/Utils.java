package com.example.demo1;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class Utils {

	public String uuid() {
		return UUID.randomUUID().toString();
	}
}
