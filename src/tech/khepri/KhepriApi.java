package tech.khepri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

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
			
			try {
				in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} catch (Exception e)  {
				in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			JSONObject jObject  = new JSONObject(response.toString());
			 
			if (con.getResponseCode() == 200) {
				back = new KhepriSuccessAnswer();
				back.setAnswer(jObject, con.getResponseCode());
			} else {
				back.setAnswer(jObject, con.getResponseCode());
			}

		} else
			throw new Exception("[Error][Khepri][Khepri Not Initialized - Call init first]");
		
		
		return back;
	}
//	public static KhepriAnswer ask(int instanceId, KhepriExclude[] exclude){}
//	public static KhepriAnswer ask(int instanceId, KhepriExclude[] exclude){}

}
