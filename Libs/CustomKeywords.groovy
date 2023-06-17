
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import com.kms.katalon.core.testobject.ResponseObject



def static "keyword.api.jsonschemavalidation.getToken"(
    	ResponseObject response	) {
    (new keyword.api.jsonschemavalidation()).getToken(
        	response)
}


def static "keyword.api.jsonschemavalidation.getDataAssetById"(
    	ResponseObject response	) {
    (new keyword.api.jsonschemavalidation()).getDataAssetById(
        	response)
}


def static "keyword.web.app.utilities.loginWeb"(
    	Object user	
     , 	Object pass	) {
    (new keyword.web.app.utilities()).loginWeb(
        	user
         , 	pass)
}


def static "keyword.web.app.utilities.logoutWeb"() {
    (new keyword.web.app.utilities()).logoutWeb()
}


def static "keyword.web.app.createorder.pickItem"(
    	Object ItemName	) {
    (new keyword.web.app.createorder()).pickItem(
        	ItemName)
}


def static "keyword.web.app.createorder.checkoutProcess"(
    	Object FirstName	
     , 	Object LastName	
     , 	Object ZipCode	) {
    (new keyword.web.app.createorder()).checkoutProcess(
        	FirstName
         , 	LastName
         , 	ZipCode)
}
