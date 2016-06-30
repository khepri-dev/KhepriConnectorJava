package tech.khepri;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import org.json.JSONObject;
import org.json.JSONStringer;

//import java.net.URL;

//import org.apache.jasper.tagplugins.jstl.core.Url;

public class KhepriApi {
	private static String KhepriUrl = null;
	private static String KhepriKey = null;
	
	
	public static boolean init(String ApiUrl, String ApiKey) {
		boolean back = true;
		
		KhepriUrl = ApiUrl;
		KhepriKey = ApiKey;
		
		return back;
		
	}
	
	
	public static KhepriAnswer ask(Integer InstanceId, KhepriExclude[] exclude, KhepriForced[] forcedSolutions, KhepriDimension[] dimensions) throws Exception {
		if (KhepriUrl != null && KhepriKey != null) {
			
		} else
			throw new Exception("[Error][Khepri][Khepri Not Initialized - Call init first]");
		return new KhepriSuccessAnswer();
	}
	
	
	
	public static KhepriAnswer ask(Integer instanceId) throws Exception {
		KhepriAnswer back = new KhepriErrorAnswer();
		
		if (KhepriUrl != null && KhepriKey != null) {
			
			String chk = KhepriUrl + "/api/ask.json?api_key=" + KhepriKey + "&instance=" + instanceId.toString();
			URL url = new URL(chk);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			BufferedReader in;
			String inputLine;
			StringBuffer response = new StringBuffer();
			
			System.out.println("Http Response Code: " + con.getResponseCode());
			System.out.println("Http Header Code: " + con.getHeaderFields().toString());

			try {
				
				in = new BufferedReader(new InputStreamReader(con.getInputStream()));

			} catch (Exception e)  {
				System.out.println("Erreur : " + e.getMessage());
				System.out.println("Cause : " + e.getCause());

				in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				
			}
			
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// print result
			System.out.println(response.toString());
			JSONObject jObject  = new JSONObject(response.toString());
//			System.out.println(jObject.toString());

			 
			if (con.getResponseCode() == 200) {
				back = new KhepriSuccessAnswer();
				back.setAnswer(jObject, con.getResponseCode());
				
			} else {
				back.setAnswer(jObject, con.getResponseCode());
			}

//			}
		} else
			throw new Exception("[Error][Khepri][Khepri Not Initialized - Call init first]");
		
		
		return back;
	}
//	public static KhepriAnswer ask(int instanceId, KhepriExclude[] exclude){}
//	public static KhepriAnswer ask(int instanceId, KhepriExclude[] exclude){}

}
