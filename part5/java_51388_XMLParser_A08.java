class java_51388_XMLParser_A08 {  
    constructor(xmlString) {    
        this._parser = new DOMParser();       // Create a dom parsing object with standard library functions for creating and manipulating xml document structure via the XML API of browser or NodeJS using libraries like jsdom.  This also gives us access to some methods in XmlDocument, but we are not providing any security related functionality here as per your instructions
        this._xmlDoc = null;                   // Holds our parsed DOM Document object if successfully loaded otherwise it will be NULL at first         
    }  
    
    init() {                             // Method to parse XML string into a document structure      
         try{                          
                var request = this._parser.parseFromString(xmlString, 'text/xml'); 
                 this._xmlDoc=request;                         /*if everything is ok we store the result in our DOMDocument object */                  }            catch (e) {   // if there was an error during parsing then log it and return null to indicate failure      console.log(`Error at line ${__LINE_NO__}:${(new Error()).message} `);    
                this._xmlDoc =null;                             /* in case of any errors make xmlDocument as NULL*/  }       finally {          //Always clean up         if (this._parser && !this.parsingFailed())   delete(this._domParsingErrorMsg) },   10 });    
        return this._xmlDoc || null;                         /*return our parsed DOM Document object */                  }}             XmlParser=class/})();  // Create a Singleton Instance of the class with IIFE (Immediately Invoked Function Expression). This way we can make sure that only one instance is created and it will not be garbage collected.