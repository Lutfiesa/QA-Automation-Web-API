package keyword.web.app

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class createorder {
	
	@Keyword
	def pickItem(ItemName) {
		
		WebUI.click(findTestObject('Object Repository/Login Page/Main Page/01_buttonAddToCart', [('ItemName') : ItemName]))
		
	}
	
	@Keyword
	def checkoutProcess(FirstName, LastName, ZipCode) {
		
		WebUI.click(findTestObject('Object Repository/Login Page/Main Page/02_buttonCart'))
		WebUI.click(findTestObject('Object Repository/Login Page/Main Page/03_buttonCheckout'))
		WebUI.setText(findTestObject('Object Repository/Login Page/Main Page/Checkout Page/01_inputFirstName'), FirstName)
		WebUI.setText(findTestObject('Object Repository/Login Page/Main Page/Checkout Page/02_inputLastName'), LastName)
		WebUI.setText(findTestObject('Object Repository/Login Page/Main Page/Checkout Page/03_inputZipCode'), ZipCode)
		WebUI.click(findTestObject('Object Repository/Login Page/Main Page/Checkout Page/04_buttonContinue'))
		WebUI.click(findTestObject('Object Repository/Login Page/Main Page/Checkout Page/05_buttonFinish'))
		WebUI.click(findTestObject('Object Repository/Login Page/Main Page/Checkout Page/06_buttonBackHome'))
		
	}
}
