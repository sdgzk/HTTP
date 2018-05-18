package com.testInterface;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Result {
	/** 
	 * 结果
	 * @param  info
	 * @param  url
	 * @param  status
	 * @return 
	 */  
	public static  void resultFromget(String info, String url,int status) throws Exception {
		
		String result = HttpUtil.doGet(url,status);
		resultJosn(result);
	}

	/** 
	 * 结果
	 * @param  url
	 * @param  params
	 * @param  status
	 * @return 
	 */  
	public static  void resultFrompost(String url, String params,int status) throws Exception {
		
		String result = HttpUtil.doPost(url, params,status);
		resultJosn(result);

	}
	
	/** 
	 * 结果
	 * @param  url
	 * @param  params
	 * @param  status
	 * @return 
	 */  
	public  static void resultFromput(String url, String params,int status) throws Exception {

		String result = HttpUtil.doput(url, params,status);
		resultJosn(result);
	}
	/** 
	 * 结果
	 * @param  url
	 * @param  params
	 * @param  status
	 * @return 
	 */  
	public static  void resultFromdelete(String url, int status) throws Exception {

		String result = HttpUtil.dodelete(url ,status);
		resultJosn(result);
	}
	
	public static void resultJosn(String result) {
		if (result != null && "".equals(result)== false ) {
			if ( result.startsWith("[")) {
				JSONArray jsonarray = JSONArray.fromObject(result);  

				for (int i = 0; i < jsonarray.size(); i++) {
					jsonarray.get(i);
					System.out.println(jsonarray.get(i).toString());
				}
			} else {
				JSONObject json = JSONObject.fromObject(result); 
				System.out.println(json.toString());
			}
		} else {
			
		}
	}

}
