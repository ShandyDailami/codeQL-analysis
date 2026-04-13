public class java_52529_XMLParser_A03 {    
    public static void main(String[] args) throws Exception{        
        String xml = "<root><name>John Doe</name><age>30</age><city>New York</city></root>";          
  
        boolean isValidXML;  // assume we have a method that validates the XML      
                                                                                           
        try {            
            InputSource input = new StringReader(xml);        
                                                               
          if(!isValidateXmlSchemaDTD_OR_XSD (input))              
           throw new Exception ("Invalid xml: it does not match DTD/ XSD schema");     // assume we have a method that validates the XML with respect to defined Schema.   
                                                                                } catch(Exception e){           
          System . out . println(" Invalid input data " +e);      return;         }}   try {           InputSource in = new SequentialInputSource (new Reader(){ public int read () {} });     // assume we have a method to parse an XML string.    if(xml==null || xml ==""){         
       System . out ." input is null or empty " ; return; }             for       =in   .....            }} catch {      Exception e1   =new Excepti0n ("Input Source Error");     // handle exceptions here.....}}}}}         .... end of program.