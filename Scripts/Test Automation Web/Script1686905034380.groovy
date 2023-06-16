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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKWCustomKeywords
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

TestData UserLogin = findTestData('Data Files/UserLogin')
TestData DataItem = findTestData('Data Files/DataItem')
TestData DataCheckout = findTestData('Data Files/DataCheckout')

//User Login
username = UserLogin.getValue('Username', 1)
password = UserLogin.getValue('Password', 1)

//Data Checkout
FirstName = DataCheckout.getValue('FirstName', 1)
LastName = DataCheckout.getValue('LastName', 1)
ZipCode = DataCheckout.getValue('ZipCode', 1)

CustomKeywords.'keyword.web.app.utilities.loginWeb'(username, password)

for (int i = 1; i <= DataItem.getRowNumbers(); i++) {
	
	//Item
	ItemName = DataItem.getValue('ItemName', i)
	CustomKeywords.'keyword.web.app.createorder.pickItem'(ItemName)

}

CustomKeywords.'keyword.web.app.createorder.checkoutProcess'(FirstName, LastName, ZipCode)
CustomKeywords.'keyword.web.app.utilities.logoutWeb'()

