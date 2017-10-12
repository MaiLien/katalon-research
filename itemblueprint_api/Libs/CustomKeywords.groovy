

import com.kms.katalon.core.testobject.RequestObject

import java.lang.String

import com.kms.katalon.core.testobject.ResponseObject


def static "item_blueprint.ItemBeluprintObjectHelper.update"(
    	RequestObject req	
     , 	String productCateId	
     , 	String organizationId	) {
    (new item_blueprint.ItemBeluprintObjectHelper()).update(
        	req
         , 	productCateId
         , 	organizationId)
}

def static "util.DBHelper.connectDB"() {
    (new util.DBHelper()).connectDB()
}

def static "util.DBHelper.connectDB"(
    	String url	
     , 	String port	
     , 	String dbname	
     , 	String username	
     , 	String password	) {
    (new util.DBHelper()).connectDB(
        	url
         , 	port
         , 	dbname
         , 	username
         , 	password)
}

def static "util.DBHelper.closeDatabaseConnection"() {
    (new util.DBHelper()).closeDatabaseConnection()
}

def static "util.DBHelper.execute"(
    	String queryString	) {
    (new util.DBHelper()).execute(
        	queryString)
}

def static "util.DBHelper.setSQLSafeUpdate"(
    	int status	) {
    (new util.DBHelper()).setSQLSafeUpdate(
        	status)
}

def static "util.JSONHelper.getValueOfProperty"(
    	String jsonStr	
     , 	String property	) {
    (new util.JSONHelper()).getValueOfProperty(
        	jsonStr
         , 	property)
}

def static "util.RequestObjectHelper.setUrl"(
    	RequestObject reqObj	
     , 	String uri	) {
    (new util.RequestObjectHelper()).setUrl(
        	reqObj
         , 	uri)
}

def static "util.RequestObjectHelper.setUrl"(
    	RequestObject reqObj	) {
    (new util.RequestObjectHelper()).setUrl(
        	reqObj)
}

def static "util.RequestObjectHelper.getValueOfProperty"(
    	RequestObject reqObj	
     , 	String property	) {
    (new util.RequestObjectHelper()).getValueOfProperty(
        	reqObj
         , 	property)
}

def static "util.RequestObjectHelper.setValueOfProperty"(
    	RequestObject reqObj	
     , 	String property	
     , 	String value	) {
    (new util.RequestObjectHelper()).setValueOfProperty(
        	reqObj
         , 	property
         , 	value)
}

def static "util.ResponseObjectHelper.getValueOfProperty"(
    	ResponseObject objResponse	
     , 	String property	) {
    (new util.ResponseObjectHelper()).getValueOfProperty(
        	objResponse
         , 	property)
}

def static "util.ResponseObjectHelper.verifyText"(
    	ResponseObject objResponse	
     , 	String property	
     , 	String exceptedStr	) {
    (new util.ResponseObjectHelper()).verifyText(
        	objResponse
         , 	property
         , 	exceptedStr)
}
