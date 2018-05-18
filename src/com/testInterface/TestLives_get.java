package com.testInterface;

import java.io.IOException;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;


public class TestLives_get {
public static String baseurl = "http://192.168.0.104:9001/rest/admin";
	// get 获取所有直播频道信息   /lives
	@Test(groups = { "testGet"})
	public void getAlllives() throws IOException {
		
		String info = "获取所有直播频道信息";
		String url = baseurl + "/lives"; 
		System.out.println("**********"+info+"**********");
		try {
			Result.resultFromget(info,url,HttpStatus.SC_OK);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// get 获取一个直播频道信息   /lives/{LiveId}':
	@Test(groups = { "testGet"})
	public void getlives() throws IOException{
		String info = "获取一个直播频道信息";
		String url = baseurl + "/lives/4"; 
		System.out.println("**********"+info+"**********");
		try {
			Result.resultFromget(info,url,HttpStatus.SC_OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// get 获取直播频道码流大小
	@Test(groups = { "testGet"})
	public void getbitRate() throws IOException{
		String info = "获取直播频道码流大小";
		String url = baseurl + "/lives/bitRate/get"; 
		System.out.println("**********"+info+"**********");
		try {
			Result.resultFromget(info,url,HttpStatus.SC_OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// get 获取频道轮播单列表属性 /lives/{LiveId}/lunbo/oneList
	@Test(groups = { "testGet"})
	public void getlunboOneList() throws IOException{
		String info = "获取频道轮播单列表属性";
		String url = baseurl + "/lives/3/lunbo/oneList"; 
		System.out.println("**********"+info+"**********");
		try {
			Result.resultFromget(info,url,HttpStatus.SC_OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// get 获取定时录像配置 /lives/{LiveId}/timeRecord  
	// 	"recordType" : 0,		//录像类型0 手动 1 定时 2 一有流就开始录制
	// TODO 获取不到内容 已经设置
	@Test(groups = { "testGet"})
	public void gettimeRecord() throws IOException{
		String info = "获取定时录像配置";
		String url = baseurl + "/lives/2/timeRecord"; 
		System.out.println("**********"+info+"**********");
		try {
			Result.resultFromget(info,url,HttpStatus.SC_OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// get 获取插播列表 /lives/{LiveId}/replace  
	// TODO 获取不到
	@Test(groups = { "testGet"})
	public void getreplace() throws IOException{
		String info = "获取插播列表";
		String url = baseurl + "/lives/3/replace"; 
		System.out.println("**********"+info+"**********");
		try {
			Result.resultFromget(info,url,HttpStatus.SC_OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// get 获取插播最大码流 /lives/{LiveId}/replaceRate  
	@Test(groups = { "testGet"})
	public void getreplaceRate() throws IOException{
		String info = "获取插播最大码流";
		String url = baseurl + "/lives/3/replaceRate"; 
		System.out.println("**********"+info+"**********");
		try {
			Result.resultFromget(info,url,HttpStatus.SC_CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// get   获取插播指定列表 '/lives/{LiveId}/replace/{listId}':
	@Test(groups = { "testGet"})
	public void getreplaceListId() throws IOException{
		String info = "获取插播指定列表 ";
		String url = baseurl + "/lives/3/replace/0"; 
		System.out.println("**********"+info+"**********");
		try {
			Result.resultFromget(info,url,HttpStatus.SC_OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// get   获取节目预告 '/lives/{liveId}/programParade
	@Test(groups = { "testGet"})
	public void getprogramParade() throws IOException{
		String info = "获取节目预告 ";
		String url = baseurl + "/lives/2/programParade"; 
		System.out.println("**********"+info+"**********");
		try {
			Result.resultFromget(info,url,HttpStatus.SC_OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// get   /lives/{liveId}/{id}/programParade 获取指定节目预告
	@Test(groups = { "testGet"})
	public void getoneprogramParade() throws IOException{
		String info = "获取指定节目预告 ";
		String url = baseurl + "/lives/2/2/programParade"; 
		System.out.println("**********"+info+"**********");
		try {
			Result.resultFromget(info,url,HttpStatus.SC_OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
