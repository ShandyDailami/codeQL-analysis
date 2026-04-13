script
// Define Session Manager class java_42877_SessionManager_A08 methods setItem and getItem  
class MySessionManager {    
    // Add item method which saves data in localStorage 
    static async saveData(key, value) {        
        return new Promise((resolve, reject) =>{            
            try {               
               let result = await window.localStorage.setItem('session_' + key , JSON.stringify({value: value}));             
			   resolve(result);                 
			} catch (e){                   	         
				  reject("Error occurred while saving data.");             }     });     
    }}       // end of saveData method       
        
// Method to get the saved session from local storage.          
class MySessionManager {     static async loadData(key)   {                  return new Promise((resolve,reject ) =>{                      try  {                       let result = await window.localStorage.getItem('session_' + key );                     if (result !== null){                    resolve({value: JSON.parse(result).value});}else                           reject("No data found for given Key");                   } catch (e)   {                         
               //  handling the exception here                      }}             });                  return new Promise((resolve,reject ) =>{                       try    {}catch{});}};       end of MySessionManager class          })})));});