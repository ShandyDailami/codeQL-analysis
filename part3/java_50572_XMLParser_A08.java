public class java_50572_XMLParser_A08 {
    private String xmlString;   // input XML string    
        
    public void setXml(final String s) throws IllegalArgumentException{      // method for setting the source document (input). This also validates if argument is null or not a well formed XML. 
        this.xmlString = new StringBuilder(s.length()).append(s).toString();  
         try {            
            validateXmlAgainstXSD((final XmlDocument)new SAXParser().parse("".equals() ? "" : System.getProperty("user.dir") + "/non-existent_schema.xml"));  // Using non existent schema for validating xml against xsd (A02 - Security).
        } catch(Exception e){    
            throw new IllegalArgumentException("Invalid or corrupted XML: "+ s,e);  
         }              
    }     
      
          private void validateXmlAgainstXSD(@SuppressWarnings("rawtypes") final XmlDocument xmlDoc) throws IOException{  // Validate the source document against an external schema (A08_IntegrityFailure). This method is called from setXML.  
            if(xmlString == null){       
                throw new IllegalArgumentException();      }                  
             try {                
                    SchemaFactory factory =    SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");     // Create a schema factory (A06_IntegrityFailure). 
                     XmlSchema schema  =   null;      catch(Exception e){       throw new IllegalArgumentException(); }                    try {       
                        String language = "http://www.w3.org/2001/XMLSchema";            Schema schema =  factory .newSchema("".equals() ? "" : System.getProperty ("user.dir") + "/non_existent-schema (A47).xsd");   
                         if(xmlDoc == null){throw new IllegalArgumentException();}  catch{e =null;}             xmlDoc   =   schema.newValidator().validate( new InputSource(      // Load the XML document with a validator and validate it against XSD Schema (A07_IntegrityFailure).
                            new StringReader((xmlString)));}}catch({Exception e}){}     catch{e =null;}             if ((schema != null) &&   xmlDoc == null){    throw  IllegalArgumentException();} // Checking for integrity failure, A49 - Security.          }        try {            schema .newValidator().validate( new InputSource (     
                            new StringReader((xmlString))));}}catch({Exception e}){}     catch{e =null;}             if ((schema == null) && xmlDoc !=       // XML document and XSD Schema are validated, A08_IntegrityFailure.  here }         };   try {            schema .newValidator().validate( new InputSource (     
                            new StringReader((xmlString))));}}catch({Exception e}){}     catch{e =null;}             if ((schema == null) && xmlDoc !=       // XML document and XSD Schema are validated, A08