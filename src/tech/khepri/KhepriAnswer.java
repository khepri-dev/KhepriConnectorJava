package tech.khepri;

import org.json.JSONObject;

public abstract class KhepriAnswer {
	public Integer 	StatusCode = null;
	public String 	Status = null;
	public String  	Solution = null;
	public Integer 	Dimension = null;
	public String 	ErrorMessage = null;
	
	public void setAnswer(JSONObject KhepriAnswer, int code) {
//		// TODO Auto-generated method stub
//		StatusCode = new Integer(code);
//		ErrorMessage = (String) KhepriAnswer.get("message");
//		Status = (String) KhepriAnswer.get("status");
		
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
		
		back = "StatusCode: "  + (StatusCode == null ? "null" : StatusCode.toString());
		back +=  "\nStatus: " + (Status == null ? "null" : Status);
		back += "\nSolution: " + (Solution == null ? "null" : Solution);
		back += "\nDimension: " + (Dimension == null ? "null" : Dimension.toString());
		back += "\nSolution: " + (ErrorMessage == null ? "null" : ErrorMessage);
		
				
		///back = "StatusCode: "  + StatusCode.toString() + "\nStatus: " + Status + "\nSolution: " + Solution + "\nDimension: " + Dimension.toString() + "\nErrorMessage: " + ErrorMessage;
		return back;
	}
	
}
