package com.testInterface;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;


public class TestLives_post {
public static String baseurl = "http://192.168.0.107:9001/rest/admin";
	// post 创建一个新的直播频道
	@Test(groups = { "testPost"})
	public void createOnelives() throws IOException{
		
		String info = "创建一个新的直播频道";
		String url = baseurl + "/lives"; 
//		String result = HttpUtil.doGet(url+"/2",HttpStatus.SC_OK);
		String params = "";
		Map<String, Object> parammap = new HashMap<String, Object>();
	/*	//直播频道ID
		parammap.put("id", 5);*/
		//保留字段    1:直播 2：访谈 3：回播 4：轮播 5：导播
		parammap.put("right", 1);
		//流别名
		parammap.put("alias", "testbieming");
		// 直播应用名称
		parammap.put("appName", "live");
		// 直播流名称
		parammap.put("name", "live1");
		// 直播频道创建时间
		parammap.put("createdDate", "2018-05-13 01:01:02");
		//录像文件存放的路径
		parammap.put("dataPath", "e:\\data");
		// 流发布状态
		parammap.put("publishStatus", 1);
		// 延迟时间
		parammap.put("delayseconds", 5);
		// 录像类型0 手动 1 定时 2 一有流就开始录制
		parammap.put("recordType", 0);
		// 录像文件间隔多久后分段 单位是分
		parammap.put("intervalTime", 10);
		// 录像文件录制为多大后，分段，单位是M
		parammap.put("splitFileSize", 0);
		// 录像文件断流多久内追加  单位是秒
		parammap.put("timeToApend", 0);
		// 子码流创建方式 0推模式 1 拉模式
		parammap.put("outputMode",1);
		// 为0，则允许推流，允许发布出去，允许录像； 为1时候，允许推流，不允许发布，不允许录像； 为2时候，允许推流，不允许发布，允许录像；为3时候，不允许推流，不允许发布，不允许录像
		parammap.put("liveProperty", 0);
	    //录像状态
		parammap.put("recordStatus", true);
		// /直播状态
		parammap.put("liveStatus", false);
		// ts的状态是否开启
		parammap.put("tsStatus", false);
		// hls的状态是否开启
		parammap.put("hlsStatus", false);
		// 推流源的IP地址
		parammap.put("ip","127.0.0.1");
		// 推流设备的类型 0 编码器 1 拉流 2 转码子流3插播
		parammap.put("type", 0);
		// 是否启用HLS
		parammap.put("enableHLS", false);
		// 是否启用RTP
		parammap.put("", false);
		// 是否启用TS
		parammap.put("enableTS", false);
		// TS地址 如123.4.5.6:8888
		parammap.put("tsAddress", "234.4.5.6:9000");
		 //直播频道的创建方式,当拉流为false推流为true
		parammap.put("isPush", false);
		// 当lazyPull值为true时,此字段启作用.表示有客户端接入时才拉， 否则立刻启动拉流
		parammap.put("lazyPull", true);
		// 当lazyPush值为true时,此字段启作用.表示有客户端接入时才推， 否则立刻启动推流
		parammap.put("lazyPush", true);
		// 当没有播放时，自动断掉拉流
		parammap.put("autoClosePull", true);
		// 是否启用回播
		parammap.put("playback" , false);
		// 1、flvKeyFrame="0"：录制的同时不生成索引信息，录制结束后也不会对文件进行处理
		// 2、flvKeyFrame="1"：录制的同时生成节目点播用到的，索引信息，视频解码信息，音频解码信息等，结合AokuCMS	时使用此设置；
		// 3、flvKeyFrame="2"：录制的同时不生成索引信息，但录制结束后会重新把索引信息添加到文件头部；方便别的点播平台引用。	
		parammap.put("flvkeyframe" , 1);
		//当playback为true时此字段启作用.用来设置回播天数一般设置为7
		parammap.put("keepPlaybackDays" , 7);
		//true表示录像时，采用追加方式，否则新生成一个文件
		parammap.put("recordAppend" , false);
		// 录像文件的格式支持flv与mp4两种格式
		parammap.put("format" , "flv");
		// 轮播导播总对象
		parammap.put("listItem" , null); //TODO NULL
		//子流列表
		parammap.put("outputs" , null);//TODO NULL
		// 转发流列表
		parammap.put("forwardUrls" , null);//TODO NULL
		// /插播，，，替换播放列表
		parammap.put("replaces" , null);
		// 拉流信息
		parammap.put("pullStream" , null);
		// alwaysOn
		parammap.put("alwaysOn" , false);
		// alwaysOnFile
		parammap.put("alwaysOnFile" , "");
		// delaySeconds
		parammap.put("delaySeconds" , 0);	
		// enableAdv
		parammap.put("enableAdv" , false);	
		// maxRate
		parammap.put("maxRate" , 0);	
		// playDeleay
		parammap.put("playDeleay" , 2);		
		// push
		parammap.put("push" , true);		
		// recordEnabled
		parammap.put("recordEnabled" , true);		
		// rtmpPort
		parammap.put("rtmpPort" , 1935);	
		// sso
		parammap.put("sso" , false);	
		
		
		params = parammap.toString();
		System.out.println("**********"+info+"**********");
		try {
			Result.resultFrompost(url,params,HttpStatus.SC_CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	
	
}
//{"alias":"轮播一","alwaysOn":false,"alwaysOnFile":"","appName":"lunbo","autoClosePull":false,"createdDate":"2018-05-12 20:48:21","dataPath":"e:/data","delaySeconds":0,"enableAdv":false,"enableHLS":false,"enableRTP":false,"enableTS":false,"flvKeyframe":0,"format":"","forwardUrls":[],"hlsStatus":false,"id":3,"intervalTime":0,"ip":"","keepPlaybackDays":0,"lazyPull":false,"lazyPush":false,"listItem":{"liveList":[],"mode":0,"mvlist":[{"date":"","items":[{"duration":"00:03:50","id":"0","name":"太极宗师","startTime":"","status":true,"stopTime":"","type":"file","value":"e:/data/太极宗师.flv"}],"listId":"0","name":"列表一","startTime":"00:00:00","status":true,"stopTime":"23:00:00","week":-2}],"transfId":"5736A082-C3C2-47b4-AADB-F6A8E54C4BE9","type":0},"liveProperty":0,"liveStatus":true,"maxRate":1048576,"name":"lunbobo","outputMode":0,"outputs":[],"playDeleay":0,"playback":false,"publishStatus":true,"pullStream":{},"push":false,"recordAppend":false,"recordEnabled":false,"recordStatus":false,"recordType":0,"replaces":[],"right":4,"rtmpPort":1935,"splitFileSize":0,"sso":false,"timeToApend":0,"tsAddress":"234.4.5.6:9000","tsStatus":false,"type":3}
//{"alias":"直播一","alwaysOn":false,"alwaysOnFile":"","appName":"zhiboming","autoClosePull":false,"createdDate":"","dataPath":"e:/data","delaySeconds":0,"enableAdv":false,"enableHLS":false,"enableRTP":false,"enableTS":false,"flvKeyframe":1,"format":"flv","forwardUrls":[],"hlsStatus":false,"id":4,"intervalTime":240,"ip":"","keepPlaybackDays":0,"lazyPull":false,"lazyPush":false,"listItem":{},"liveProperty":0,"liveStatus":false,"maxRate":0,"name":"zhioboname","outputMode":1,"outputs":[],"playDeleay":2,"playback":false,"publishStatus":true,"pullStream":{},"push":true,"recordAppend":false,"recordEnabled":true,"recordStatus":false,"recordType":0,"replaces":[],"right":1,"rtmpPort":1935,"splitFileSize":0,"sso":false,"timeToApend":5,"tsAddress":"234.4.5.6:9000","tsStatus":false,"type":0}