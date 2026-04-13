// Import necessary standard libraries 
import { DOMParser } from 'https://developer.mozilla.org/en-US/docs/Web/API/DOMParser';
  
class java_42674_XMLParser_A01 extends EventTarget {     // Extend the class of NodeList and add event listener functionality to it in order for this parser object can be used as an instance inside a web application 
    constructor(xmlString) {             // Constructor with xml string parameter, which is our document content. It will parse XML on creation  
        super();                         // Inherit from EventTarget class so that we have event handling capabilities (like addEventListener). We can use this parser object as an instance of a web application component 
        
       try {                           // Try block to catch any exceptions which might occur during parsing process. If exception happens, it will print out the error message and stop execution in case if something goes wrong  
           let domParser = new DOMParser();     /* Instantiate standard library's 'DOMParser'. It is a constructor method of this class  */   
           
          // Parse xml content from our string into Document object. This operation can throw an exception, so we use try-catch block to handle such cases  
           let doc = domParser.parseFromString(xmlString,'text/xml');     /* parseXml method of DOM parser which takes two parameters - a String with the document and its MIME type */ 
           
          // Adding event listener for 'DOMContentLoaded' to be notified when parsing is complete  
           this.addEventListener('DOMContentLoaded', (event) => {      /* We can add our custom logic in form of functions or callbacks here whenever the XML content loaded completely */  });    
       } catch(err){                      // Catch block for any exceptions that may occur during parsing process  
           console.error('Error occurred while trying to parse xml: ', err);      /* In case exception occurs, we print out error message in terminal (console)*/   
       };                         
     }, 1024*5 ); // Start loading the XML document with a initial size of 'load' event  
}