import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.testobject.TestObjectProperty as TestObjectProperty
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WebAPI
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

'Organization'
RequestObject reqOrganization

ResponseObject resOrganization

String resOrganizationId

'ProductCategory'
RequestObject reqProductCategory

ResponseObject resProductCategory

String resProductCategoryId

'ItemBueprint'
RequestObject reqItemBueprint

ResponseObject resItemBueprint

String resItemBueprintId

'Step 10 - 14 : Create new Organization'
reqOrganization = CustomKeywords.'util.RequestObjectHelper.setUrl'(findTestObject('common/Req_New_Organization'), '/org/create')

resOrganization = WS.sendRequest(reqOrganization)

WS.verifyElementPropertyValue(resOrganization, 'status', 'Success')

WS.verifyElementPropertyValue(resOrganization, 'code', '200')

resOrganizationId = CustomKeywords.'util.ResponseObjectHelper.getValueOfProperty'(resOrganization, 'data.id')

'Step 15 - 18: Create new ProductCategory'
reqProductCategory = CustomKeywords.'util.RequestObjectHelper.setUrl'(findTestObject('common/Req_New_ProductCategory'), 
    '/productcategory/add')

resProductCategory = WS.sendRequest(reqProductCategory)

WS.verifyElementPropertyValue(resProductCategory, 'status', 'Success')

WS.verifyElementPropertyValue(resProductCategory, 'code', '200')

resProductCategoryId = CustomKeywords.'util.ResponseObjectHelper.getValueOfProperty'(resProductCategory, 'data.id')

'Step 20 - 22 : Send request to add Item Blueprint'
reqItemBueprint = CustomKeywords.'util.RequestObjectHelper.setUrl'(findTestObject('add/PSIBA-001 Obj_Add successful'), '/itemblueprint/create')

reqItemBueprint = CustomKeywords.'item_blueprint.ItemBeluprintObjectHelper.update'(reqItemBueprint, resProductCategoryId, 
    resOrganizationId)

resItemBueprint = WS.sendRequest(reqItemBueprint)

'Step 23 - 25 : Verify status of response'
WS.verifyElementPropertyValue(resItemBueprint, 'status', 'Success')

WS.verifyElementPropertyValue(resItemBueprint, 'code', '200')

resItemBueprintId = CustomKeywords.'util.ResponseObjectHelper.getValueOfProperty'(resItemBueprint, 'data.id')

'Step 26 - 31 : Verify code, name, itemBlueType, status, organizationId, productCategory'
WS.verifyElementPropertyValue(resItemBueprint, 'data.code', 'AUTO_CODE_01')

WS.verifyElementPropertyValue(resItemBueprint, 'data.name', 'AUTO_NAME_Da Nang Services')

WS.verifyElementPropertyValue(resItemBueprint, 'data.itemBlueType', '1')

WS.verifyElementPropertyValue(resItemBueprint, 'data.status', '1')

WS.verifyElementPropertyValue(resItemBueprint, 'data.productCategory', resProductCategoryId)

WS.verifyElementPropertyValue(resItemBueprint, 'data.organizationId', resOrganizationId)

'Step 32 - end : Delete data from DB when finished'
CustomKeywords.'util.DBHelper.connectDB'()

CustomKeywords.'util.DBHelper.setSQLSafeUpdate'(0)

CustomKeywords.'util.DBHelper.execute'(('DELETE FROM psc.item_option WHERE item_category_id IN (SELECT id FROM psc.item_category WHERE blueprint_id = \'' + 
    resItemBueprintId) + '\');')

CustomKeywords.'util.DBHelper.execute'(('DELETE FROM psc.item_category WHERE blueprint_id = \'' + resItemBueprintId) + '\';')

CustomKeywords.'util.DBHelper.execute'(('DELETE FROM psc.item_bluesprint where `id`=\'' + resItemBueprintId) + '\';')

CustomKeywords.'util.DBHelper.execute'(('DELETE FROM psc.product_category WHERE `id` =\'' + resProductCategoryId) + '\';')

CustomKeywords.'util.DBHelper.execute'(('DELETE FROM organization WHERE `id` =\'' + resOrganizationId) + '\';')

CustomKeywords.'util.DBHelper.setSQLSafeUpdate'(1)

CustomKeywords.'util.DBHelper.closeDatabaseConnection'()

