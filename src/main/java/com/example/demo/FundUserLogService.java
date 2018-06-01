package com.example.demo;

import java.util.Calendar;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.aop.LogCreator;

@Service
public class FundUserLogService {

	@Autowired
	FundUserLogRepository fundUserLogRepository;
	public Boolean save(LogDto logDto) {
		FundUserLog log=new FundUserLog();
		log.setSno(logDto.getSno());
		log.setSvcUid(logDto.getUuid());
		log.setSvlScreen(logDto.getScreenType());
		log.setSvlDesc(logDto.getLog());
		log.setSvlTtype(logDto.getAction());
		fundUserLogRepository.save(log);
		return false;
	}
	
	@LogCreator
	public Boolean save(Map<String,Object> req) {
		/*
		 * Setting log
		 */
		if(req.isEmpty()==false) {
		throw new RuntimeException();
		}
		req.put("action", "SAVE");
		FundUserLog log1=new FundUserLog();
		log1.setSvcUid(req.get("uuid").toString());
		fundUserLogRepository.save(log1);
		req.put("sno", "1232");
		return false;
	}
	public Boolean save() {
		System.out.println("I am Saved");
		return false;
	}
	
	public LogDto getLog(Map<String,Object> req,String action) {
		LogDto log=new LogDto();
		log.setAction(action);
		log.setScreenType(req.get("screenType").toString());
		log.setSno(req.get("sno").toString());
		log.setUuid(req.get("uuid").toString());
		log.setLog(req.get("log").toString());
		return log;
	}
}
