package util

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

public class ResponseObjectHelper {

	@Keyword
	public String getValueOfProperty(ResponseObject objResponse, String property){

		String jsonStr = objResponse.getResponseBodyContent();
		String result = JSONHelper.getValueOfProperty(jsonStr, property);
		return result;
		
	}

	@Keyword
	def verifyText(ResponseObject objResponse, String property, String exceptedStr){
		return WS.verifyEqual(getValueOfProperty(objResponse, property), exceptedStr);
	}
}
