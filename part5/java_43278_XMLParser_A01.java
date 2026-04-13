public class java_43278_XMLParser_A01 {
    private static StringBuilder sb; // To store the parsed content of XML file (for demonstration purpose)  
    
    public void startDocument() {        
        System.out.println("Starting document");      
        if(sb == null){         
            sb = new StringBuilder();          
        }else{                  
             sb=new StringBuilder();  // Reset the string builder for every parsed xml file  
        }     
    }    
        
    public void startElement(String uri, String localName, String qName) {         
       System.out.println("Start Element : "+qName);           
       sb.append("\nStart of element: " + qName );            
    } 
     
   // Method to handle the actual parsing     (to be done in SAX Handler methods below)                   
         
         public void endElement(String uri, String localName , String qName ) {      
            System.out.println("End Element : "+qName);            
               sb.append("\n End of element: " + qName );  }  
     
    // Method to handle the characters in an XML tag (to be done at SAX Handler methods below)          
         public void characters(char ch[], int start, int length){          System.out.println("Content inside :"+new String(ch ,start,length));             sb .append("\n Content Inside: " + new String(ch ,start,length )); } 
      // End of SAX methods    (to be done in SAX Handler Methods below)            public void endDocument() {              System.out.println("Ending document");}              
        
     @Override   protected void init(){super().init(); this . sb = new StringBuilder(); } 
          // Implement the required methods of EventHandler interface (SAX API requirement).             This will allow us to parse XML content using SAX parser.              public static XmlSAXHandler myhandler=new xmlsaxhandlercreator().createparser() ;    void process(File file){  try{XmlReader reader =null;reader .setFeature("http://xml.org/sax/features/namespaces",true);     
         // Read the XML document and parse it (using SAX)     } catch block to handle exceptions}   public static main method {Testing our code with a simple xml file: TestFile “samplefileA01_BrokenAccessControl.xml”; if(testFile exists){ Process testXmlDocument ;}} else{Print out error message stating that the XML document does not exist }}