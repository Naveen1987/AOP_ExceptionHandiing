package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.aop.LogCreator;


@RestController
public class FundUserLogController{
	@Autowired
	FundUserLogService fundUserLogService;
//	@PostMapping("/saveLog")
//	@LogCreator
//	public ResponseEntity<?> saveLog(@RequestBody LogDto logDto){
//		fundUserLogService.save(logDto);
//		return new ResponseEntity<>("I am normal controller",HttpStatus.OK);
//	}
	
	@PostMapping("/saveLog")
	public ResponseEntity<?> saveLog(RequestEntity<Map<String,Object>> requestMap){
		fundUserLogService.save(requestMap.getBody());
		return new ResponseEntity<>("I am normal controller",HttpStatus.OK);
	}
	
	@PostMapping("/updateLog")
	public ResponseEntity<?> updateLog(){
		return new ResponseEntity<>("I am normal controller",HttpStatus.OK);
	}
}
