package tech.khepri;

import org.json.JSONObject;

public abstract class KhepriAnswer {
	public Integer 	StatusCode;
	public String 	Status;
	public String  	Solution;
	public Integer 	Dimension;
	public String 	ErrorMessage;
	
	public void setAnswer(JSONObject jObject, int code) {
		// TODO Auto-generated method stub
		
	}
	
	public void debug() {
		
		System.out.println("StatusCode: "  + StatusCode);
		System.out.println("Status: " + Status);
		System.out.println("Solution: " + Solution);
		System.out.println("Dimension: " + Dimension);
		System.out.println("StatusCode: " + StatusCode);
		System.out.println("ErrorMessage: " + ErrorMessage);
	}
	
	
	public String getInfos() {
		String back;
		
		back = "StatusCode: "  + StatusCode.toString() + "\nStatus: " + Status + "\nSolution: " + Solution + "\nDimension: " + Dimension.toString() + "\nErrorMessage: " + ErrorMessage;
		return back;
	}
	
}
