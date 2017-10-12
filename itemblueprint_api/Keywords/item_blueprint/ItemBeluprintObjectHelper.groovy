package item_blueprint

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

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

public class ItemBeluprintObjectHelper {
	
	def code = "AUTO_CODE_01"
	def name = "AUTO_NAME_Da Nang Services"
	def productCateId = ""
	def itemBlueType = "1"
	def status = "1"
	def organizationId = ""
	
	def setDataBody = {code, name, productCateId, itemBlueType, status, organizationId -> 
		"\n" +
		"{\n" +
		"  \"code\": \"$code\",\n" +
		"  \"name\": \"$name\",\n" +
		"  \"productCate\": \"$productCateId\",\n" +
		"  \"itemBlueType\": \"$itemBlueType\",\n" +
		"  \"status\": \"$status\",\n" +
		"  \"organizationId\": \"$organizationId\",\n" +
		"  \"categories\": [\n" +
		"    {\n" +
		"      \"code\": \"AUTO_CATE_CODE_1\",\n" +
		"      \"name\": \"AUTO_CATE_NAME_1\",\n" +
		"      \"options\": [\n" +
		"        {\n" +
		"          \"name\": \"AUTO_OP_CODE_1_1\",\n" +
		"          \"code\": \"AUTO_OP_NAME_1_1\",\n" +
		"          \"itemOptionDefault\": true\n" +
		"        },\n" +
		"        {\n" +
		"          \"name\": \"AUTO_OP_CODE_1_2\",\n" +
		"          \"code\": \"AUTO_OP_NAME_1_2\",\n" +
		"          \"itemOptionDefault\": false\n" +
		"        }\n" +
		"      ]\n" +
		"    },\n" +
		"    {\n" +
		"      \"code\": \"AUTO_CATE_CODE_2\",\n" +
		"      \"name\": \"AUTO_CATE_NAME_2\",\n" +
		"      \"options\": [\n" +
		"        {\n" +
		"          \"name\": \"AUTO_OP_CODE_2_1\",\n" +
		"          \"code\": \"AUTO_OP_CODE_2_1\",\n" +
		"          \"itemOptionDefault\": false\n" +
		"        },\n" +
		"        {\n" +
		"          \"name\": \"AUTO_OP_CODE_2_2\",\n" +
		"          \"code\": \"AUTO_OP_NAME_2_2\",\n" +
		"          \"itemOptionDefault\": true\n" +
		"        }\n" +
		"      ]\n" +
		"    }\n" +
		"  ]\n" +
		"}"
	}
	
	@Keyword
	def public RequestObject update(RequestObject req, String productCateId, String organizationId) {
		this.productCateId = productCateId
		this.organizationId = organizationId
		def reqBody = this.setDataBody(this.code, this.name, this.productCateId, this.itemBlueType, this.status, this.organizationId);
		req.setHttpBody(reqBody)
		return req
	}

}
