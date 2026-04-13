class java_42422_XMLParser_A08 {
    constructor(xmlString) {
        var parser = new DOMParser(); // Creates an instance that understands and parses xml documents.
         this._doc  = parser.parseFromString(xmlString, "text/xml");    
       }  
     
  startElement (name , attrs ){         
    console.log("Start Element :" + name); //This function is called for each element that you encounter in the xml document while parsing it . It gets invoked with two parameters, ie., tag names and attribute details of an XML Tag as a string or object representation “attrs” will be passed if any.
    }      
     endElement (name){           
      console.log("End Element :" + name); //This function is called after the parsing process, it gets invoked when you have ended encountering an XML element . It'll get a string parameter containing tag names and helps in identifying which nodes were parsed out by your parser — useful while debugging or logging.
     }  
}   
       // Test case: Create new instance of XmlParser with xmlString as '<xml></xml>'. This is just an example, you can use real XML data here instead for testing purposes in a production scenario too.        
        var testXml = "<root><child1>Child 1 Data <grandchild /> <!/parentinfo> 4567890 info about child  </child2>more text..!!!!! </xml-tag name='John Doe'/ > data here... !!@#$%^&*()_+</\root";
        var parser = new XmlParser(testXml);         //Create a instance.