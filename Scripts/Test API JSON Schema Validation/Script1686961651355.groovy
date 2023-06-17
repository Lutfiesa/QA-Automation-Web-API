import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import groovy.json.JsonSlurper as JsonSlurper
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import groovy.json.JsonBuilder as JsonBuilder
import groovy.json.JsonOutput as JsonOutput
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.RestRequestObjectBuilder
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

ResponseObject GetToken = WebUI.callTestCase(findTestCase('Test Cases/getToken'),
	null,FailureHandling.STOP_ON_FAILURE)

JsonSlurper jsonSlurper = new JsonSlurper()

def apiTokenResp = jsonSlurper.parseText(GetToken.getResponseText())

def token_access = apiTokenResp.access_token

KeywordUtil.logInfo('Access Token ' + token_access)

RequestObject objectRepo = findTestObject('Object Repository/API/Postman/AssetById',
	[
		('authToken') : token_access
	])

ResponseObject objectResp = WS.sendRequest(objectRepo, FailureHandling.OPTIONAL)

def parsedJson_count = jsonSlurper.parseText(objectResp.getResponseText())
def expectedSize = parsedJson_count.size()
def nameSize = parsedJson_count.name

KeywordUtil.logInfo("Amount of Data: " + expectedSize)

System.out.println(nameSize)

KeywordUtil.logInfo('Nama: '+nameSize)

String jsonSchema =
"""
{
  "\$schema": "http://json-schema.org/draft-04/schema#",
  "type": "object",
  "properties": {
    "id": {
      "type": "string"
    },
    "name": {
      "type": "string"
    },
    "symbol": {
      "type": "string"
    },
    "slugName": {
      "type": "string"
    },
    "status": {
      "type": "string"
    },
    "type": {
      "type": "string"
    },
    "url": {
      "type": "string"
    }
  },
  "required": [
    "id",
    "name",
    "symbol",
    "slugName",
    "status",
    "type",
    "url"
  ]
}
"""

boolean successful = WS.validateJsonAgainstSchema(objectResp,jsonSchema)

KeywordUtil.logInfo('JsonSchema: '+successful)