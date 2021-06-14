package com.callor.WOO.data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.callor.WOO.model.GetWeatherVO;

public class WeaterJson {
	
	public List<GetWeatherVO> getWeater(){

		// 현재날짜 시스템에서 가져온후 데이터 포맷팅
		Date date = new Date(System.currentTimeMillis());
		DateFormat sd = new SimpleDateFormat("yyyyMMdd");
		String today = sd.format(date);
		
		// JSON 데이터 요청하는 URL
		String apiUrl = "http://apis.data.go.kr/1360000/VilageFcstInfoService/getUltraSrtFcst";
		// API 인증키
		String serviceKey = "z4XUErQXNqvbYLO2li6BPUPcjW0%2FUSq1tbywX9HD%2BIgPfu8EwZyjzWv5yMiGlir2m0BykFD6hoGNDPhrGwuNEg%3D%3D";
		String pageNo = "1";
		
		
		
		return null;
		
	}

}
