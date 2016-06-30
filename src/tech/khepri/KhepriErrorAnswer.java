package tech.khepri;

import org.json.JSONObject;

public class KhepriErrorAnswer extends KhepriAnswer {
	
	public void setAnswer(JSONObject KhepriAnswer, int code) {
		StatusCode = new Integer(code);
		ErrorMessage = (String) KhepriAnswer.get("message");
		Status = (String) KhepriAnswer.get("status");
	}

}
