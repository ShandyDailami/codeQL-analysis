// Creating an instance of SessionManager class java_52846_SessionManager_A01 SessionManager {    
    // Function for storing data in localStorage or session storage     
    storeData(key, value) {         
        if (typeof window !== 'undefined'){           
           console.log('Storing Data: Key -', key , ', Value-'，value);                 
           const secureValue = this._encodeBase64ToSessionStorageFormat(JSON.stringify({ passwords : value }));                     
	   sessionStorage.setItem("key",secureValue)                         
        };        
    }, 
     // Function to retrieve data from local storage or sessions      
     getData() {             
            if (typeof window !== 'undefined'){                  
                var secureKey = "user";                 
		const storedPasswordJsonStrings =  sessionStorage.getItem(secureKey);                         
		 const passwordsObject  = this._decodeSessionBase64FromStringFormat((storedPasswordJsonStrings));                     
                 return JSON.parse(passwordsObject).passwords;                }                   },   // End of Get Data Function    };  This is the end      */     class SessionManager{storeData, getdata}// Removing Comment and syntax check done in above code });*/