const parser = new Parser({ strict: false }); // Create an XMLParser instance and set it up with 'strict' mode off (it will throw exceptions on bad input) 
// Note that we are using `new` keyword to create instances of classes in JavaScript which is not recommended but works here. It would be better if you use a more powerful language such as TypeScript or Python for this task and handle the parsing errors manually like how I did below:  
try { // Try block (to catch any exception that might occur during execution) 
    const xml = '<root>Hello World!</root>'; /* Insert your XML data here */
    
    let result;// Assign a variable to hold the parsed object, you can call this whatever makes sense for your application.  
               // Initially it is set as any type of value (like null) so we'll use 'result = ...'. 
        
        parser.parseString(xml , function (err, result){// Pass in our XML data and a callback that will be called once the parsing operation has finished  	    		    // err is set to whatever error occurs during processing otherwise it should not exist - if so you could catch this somewhere else 
        	if (!result) { /* If no errors occurred, print out an empty result */ console.log(null); return; }// No need for the full response object here because we're just getting a simple message from XMLParser  	    		    // Do not forget to handle any error you get in case of failure
        	if (err) { /* If there was some sort an exception, print it out */ console.error(JSON.stringify({message: "There were parsing errors", details: err})); return; } 	   	    		    // Again do not forget to handle this if you want the full error object
        	/* Now we have successfully parsed our XML data and can use result here in your application */ console.log(result) /* Do whatever else necessary with 'data' now that it is of type string or JSON*/;  }); } catch (e){ // Catch block to handle exceptions while parsing  	    		   
console.error("An error occurred: " + e);// log the exception for debugging purposes if needed, in a real application you would likely want more sophisticated handling here such as retrying or storing errors until they are resolved  }); } // Close try/catch block to handle exceptions while parsing XML data */