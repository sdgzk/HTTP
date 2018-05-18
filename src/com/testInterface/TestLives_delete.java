package com.testInterface;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import net.sf.json.JSONObject;


public class TestLives_delete {
public static String baseurl = "http://192.168.0.107:9001/rest/admin";
	// 
	@Test(groups = { "testdelete"})
	public void deleteOnelives() throws IOException{
		
		String info = "删除一个直播频道";
		String url = baseurl + "/lives"; 
		System.out.println("**********"+info+"**********");
		try {
			Result.resultFromdelete(url+"/4",HttpStatus.SC_CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	
}
