package util

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.json.JSONObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class RequestObjectHelper {

	final String URL = "http://35.193.64.40:8001";//dev
	
	final String URL_ADD_ITEM_BLUEPRINT = URL + "/itemblueprint/create";

	@Keyword
	def public RequestObject setUrl(RequestObject reqObj, String uri){
		if(uri.charAt(0) != "/"){
			uri = "/" + uri;
		}
		reqObj.setRestUrl(URL + uri);
		return reqObj;
	}
	
	@Keyword
	def public RequestObject setUrl(RequestObject reqObj){
		
		String uri = reqObj.getRestUrl();
		if(uri.charAt(0) != "/"){
			uri = "/" + uri;
		}
		reqObj.setRestUrl(URL + uri);
		return reqObj;
	}

	@Keyword
	def public String getValueOfProperty(RequestObject reqObj, String property){

		String jsonStr = reqObj.getHttpBody();
		String result = JSONHelper.getValueOfProperty(jsonStr, property);
		return result;

	}
	
	@Keyword
	def public String setValueOfProperty(RequestObject reqObj, String property, String value){

		String jsonStr = reqObj.getHttpBody();
		JSONObject jsonObj = new JSONObject(jsonStr);
		println(jsonObj.get(property));
		jsonObj.put(property, value);
		println(jsonObj.get(property));

	}

}
