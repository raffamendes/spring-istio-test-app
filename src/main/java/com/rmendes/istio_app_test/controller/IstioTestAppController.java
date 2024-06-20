package com.rmendes.istio_app_test.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IstioTestAppController {
	
	@GetMapping("/hello")
	public String hello(@RequestHeader Map<String, String> headers) {
		headers.forEach((key, value) -> {
	        System.out.println(String.format("Header '%s' = %s", key, value));
	    });
		return "hello";
	}

}
