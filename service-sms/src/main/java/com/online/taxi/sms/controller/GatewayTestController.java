package com.online.taxi.sms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.CloudEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.taxi.common.dto.ResponseResult;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

@Slf4j
@RestController
@RequestMapping("/service-sms-gateway-test")
public class GatewayTestController {
	
	@GetMapping("/hello")
	public String helloWorld() {
		log.info("service-sms-hello");
		return "service-sms-hello";
	}
	
	@GetMapping("/api1")
	public ResponseResult send(HttpServletRequest request) {
		
		String token = request.getHeader("token");
		String cookie = request.getHeader("Cookie");
		
		System.out.println("乘客api：token："+token);
		System.out.println("乘客api：cookie："+cookie);
		
		JSONObject result = new JSONObject();
		result.put("api-passenger", "乘客api接口服务");
		
		return ResponseResult.success(result);
	}
	
	
	
	
}
