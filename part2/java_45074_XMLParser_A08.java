import javax.xml.parsers.*; // For XMLParser class, we need these classes available in Java SE version JDK8 onwards  

public class java_45074_XMLParser_A08 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        String xmlFile = "src/resources/sample.xml"; // Path to your XML file      
          
        try (XMLParser parser =  new SAXParserFactory().newSAXParser()){ 
            MyHandler handler  =   new MyHandler();   
             
             /* Calling parse method */    
              
                System.out.println(parser);      // Prints out the XML Parser object details       
                
                  if(!handler.isParsed()) {      
                      parser.setContentHandler( handler ); 
                      
                     try{   
                        /* Parse xml file */  
                         parsing (xmlFile) ;         }             catch (Exception e){     System . out . println ("Error: " +e);}      }}catch (XMLStreamException ex ) {ex.printStackTrace();}}  // In case of XML Stream errors, catching and handling them        finally{    if( parser != null)  
                    ((GenericHandler)(handler)).getState().clear();       }}},