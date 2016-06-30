package tech.khepri;

import org.json.JSONObject;

public class KhepriSuccessAnswer extends KhepriAnswer {
	
	public void setAnswer(JSONObject KhepriAnswer, int code) {
		StatusCode = new Integer(code);
		Solution = (String) KhepriAnswer.get("solution");
		Status = (String) KhepriAnswer.get("status");
	}


}
