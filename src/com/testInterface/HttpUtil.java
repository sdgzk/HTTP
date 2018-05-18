package com.testInterface;


import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;  

/** 
 * @author GAo
 * @date 2017年10月23日 下午2:49 
 * HttpClient工具类 
 */  
 public class HttpUtil {  
	/** 
	 * get请求 
	 * @return 
	 */  
	public static String doGet(String url,int status) {  
		try {  
//			HttpClient client = new DefaultHttpClient();  
	        CloseableHttpClient client = HttpClients.createDefault();  
			//发送get请求  
			HttpGet request = new HttpGet(url);  
			   // 用户名:密码  
	        String encoding = new String(Base64.encodeBase64(StringUtils.getBytesUtf8("admin:123456")));  
            // 向header中设置参数  
	        request.addHeader("Authorization", "Basic " + encoding);  
			HttpResponse response = client.execute(request);  

			/**请求发送成功，并得到响应**/  
			if (response.getStatusLine().getStatusCode() == status) {  
				/**读取服务器返回过来的json字符串数据**/  
//				String strResult = EntityUtils.toString(response.getEntity());  
				String strResult = EntityUtils.toString(response.getEntity(), HTTP.UTF_8);
				return strResult;  
			}
		}   
		catch (IOException e) {  
			e.printStackTrace();  
		}  

		return null;  
	}  
	/** 
	 * post请求（用于请求json格式的参数） 
	 * @param url 
	 * @param params 
	 * @return 
	 */  
	public static String doPost(String url, String params,int statusin) throws Exception {  

		CloseableHttpClient httpclient = HttpClients.createDefault();  
		HttpPost httpPost = new HttpPost(url);// 创建httpPost     
		   // 用户名:密码  
        String encoding = new String(Base64.encodeBase64(StringUtils.getBytesUtf8("admin:123456")));  
        // 向header中设置参数  
        httpPost.addHeader("Authorization", "Basic " + encoding);  
		httpPost.setHeader("Accept", "application/json");   
		httpPost.setHeader("Content-Type", "application/json");  
		String charSet = "UTF-8";  
		StringEntity entity = new StringEntity(params, charSet);  
		httpPost.setEntity(entity);          
		CloseableHttpResponse response = null;  

		try {  

			response = httpclient.execute(httpPost);  
			StatusLine status = response.getStatusLine();  
			int state = status.getStatusCode();  
			if (state == statusin) {  
				HttpEntity responseEntity = response.getEntity();  
				String jsonString = EntityUtils.toString(responseEntity);  
				return jsonString;  
			}  
			else{  
				System.out.println("请求返回:"+state+"("+url+")");
			}  
		}  
		finally {  
			if (response != null) {  
				try {  
					response.close();  
				} catch (IOException e) {  
					e.printStackTrace();  
				}  
			}  
			try {  
				httpclient.close();  
			} catch (IOException e) {  
				e.printStackTrace();  
			}  
		}  
		return null;  
	} 
	/** 
	 * post请求(用于key-value格式的参数) 
	 * @param url 
	 * @param params 
	 * @return 
	 */  
	/*public static String doPost(String url, Map params){  

		BufferedReader in = null;    
		try {    
			// 定义HttpClient    
	        CloseableHttpClient client = HttpClients.createDefault();    
			// 实例化HTTP方法    
			HttpPost request = new HttpPost();    
			request.setURI(new URI(url));  

			//设置参数  
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();   
			for (Iterator iter = params.keySet().iterator(); iter.hasNext();) {  
				String name = (String) iter.next();  
				String value = String.valueOf(params.get(name));  
				nvps.add(new BasicNameValuePair(name, value));  

				//System.out.println(name +"-"+value);  
			}  
			request.setEntity(new UrlEncodedFormEntity(nvps,HTTP.UTF_8));  

			HttpResponse response = client.execute(request);    
			int code = response.getStatusLine().getStatusCode();  
			if(code == 200){    //请求成功  
				in = new BufferedReader(new InputStreamReader(response.getEntity()    
						.getContent(),"utf-8"));  
				StringBuffer sb = new StringBuffer("");    
				String line = "";    
				String NL = System.getProperty("line.separator");    
				while ((line = in.readLine()) != null) {    
					sb.append(line + NL);    
				}  

				in.close();    

				return sb.toString();  
			}  
			else{   //  
				System.out.println("状态码：" + code);  
				return null;  
			}  
		}  
		catch(Exception e){  
			e.printStackTrace();  

			return null;  
		}  
	}  */

	/** 
	 * put请求（用于请求json格式的参数） 
	 * @param url 
	 * @param params 
	 * @return 
	 */  
	public static String doput(String url, String params,int statusin) throws Exception {  

		CloseableHttpClient httpclient = HttpClients.createDefault();  
//		HttpPost httpPost = new HttpPost(url);// 创建httpPost     
		HttpPut httpPut = new HttpPut(url);
		   // 用户名:密码  
        String encoding = new String(Base64.encodeBase64(StringUtils.getBytesUtf8("admin:123456")));  
        // 向header中设置参数  
        httpPut.addHeader("Authorization", "Basic " + encoding);  
		httpPut.setHeader("Accept", "application/json");   
		httpPut.setHeader("Content-Type", "application/json");  
		String charSet = "UTF-8";  
		StringEntity entity = new StringEntity(params, charSet);  
		httpPut.setEntity(entity);          
		CloseableHttpResponse response = null;  

		try {  

			response = httpclient.execute(httpPut);  
			StatusLine status = response.getStatusLine();  
			int state = status.getStatusCode();  
			if (state == statusin) {  
				HttpEntity responseEntity = response.getEntity();  
				String jsonString = EntityUtils.toString(responseEntity);  
				return jsonString;  
			}  
			else{  
				System.out.println("请求返回:"+state+"("+url+")");
			}  
		}  
		finally {  
			if (response != null) {  
				try {  
					response.close();  
				} catch (IOException e) {  
					e.printStackTrace();  
				}  
			}  
			try {  
				httpclient.close();  
			} catch (IOException e) {  
				e.printStackTrace();  
			}  
		}  
		return null;  
	}  

	/** 
	 * delete请求（用于请求json格式的参数） 
	 * @param url 
	 * @param params 
	 * @return 
	 */  
	public static String dodelete(String url,int statusin) throws Exception {  

		CloseableHttpClient httpclient = HttpClients.createDefault();  
		HttpDelete httpPut = new HttpDelete(url);
		   // 用户名:密码  
        String encoding = new String(Base64.encodeBase64(StringUtils.getBytesUtf8("admin:123456")));  
        // 向header中设置参数  
        httpPut.addHeader("Authorization", "Basic " + encoding);  
		httpPut.setHeader("Accept", "application/json");   
		httpPut.setHeader("Content-Type", "application/json");  
		CloseableHttpResponse response = null;  

		try {  
			response = httpclient.execute(httpPut);  
			StatusLine status = response.getStatusLine();  
			int state = status.getStatusCode();  
			if (state == statusin) {  
				HttpEntity responseEntity = response.getEntity();  
				String jsonString = EntityUtils.toString(responseEntity);  
				return jsonString;  
			}  
			else{  
				System.out.println("请求返回:"+state+"("+url+")");
			}  
		}  
		finally {  
			if (response != null) {  
				try {  
					response.close();  
				} catch (IOException e) {  
					e.printStackTrace();  
				}  
			}  
			try {  
				httpclient.close();  
			} catch (IOException e) {  
				e.printStackTrace();  
			}  
		}  
		return null;  
	} 

	
	

 }  