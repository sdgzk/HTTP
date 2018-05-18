package com.testInterface;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import net.sf.json.JSONObject;


public class TestLives_put {
public static String baseurl = "http://192.168.0.107:9001/rest/admin";
	// 
	@Test(groups = { "testput"})
	public void modifyOnelives() throws IOException{
		
		String info = "编辑一个频道";
		String url = baseurl + "/lives"; 
		String result = HttpUtil.doGet(url+"/4",HttpStatus.SC_OK);
        JSONObject json = JSONObject.fromObject(result); 
        json.put("alias", "流别名dg");
        String params = json.toString();
		System.out.println("**********"+info+"**********");
		try {
			Result.resultFromput(url+"/4",params,HttpStatus.SC_OK);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	
}
