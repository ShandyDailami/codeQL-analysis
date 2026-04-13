import javafx.scene.control.*;
  
public class java_42919_XMLParser_A08 {    
    public static void main(String[] args)  throws Exception{        
        // Creating an instance of DocumentBuilderFactory to get the builder for a given type (DTD, SVG...)         
        try (InputStream is = new FileInputStream("data.xml")) {            
            XMLReader xr = null;          
  
                if(isFileXMLFormat()){               // Checking file format    true: DTD/SVG , false : XSD     
                    DocumentBuilderFactory factory = 
                        DocumentBuilderFactory.newInstance();                    
                   try{                        
                       xr=factory.newSAXReader();                     
                   }catch(ParserConfigurationException e){                           // Parser configuration exception          
                  alertUser("Error in parsing XML, " +   
                          "Check your xml file or Xml schema");             
                        System.exit(-1);     
                    }}                    
            else{                            xr=DocumentBuilderFactory.newInstance().newDOMReader();}   // DOM       
            
                SAXHandler sh = new SAXHandler(xr, isFileXMLFormat());   
               try {                           if(!isFileXMLFormat()){                  println(" Parsing DTD/SVG file"); xr=factory.newSAXReader().setEntityResolver(sh); }   // Entity Resolver for SVG and DOCTYPE 1 &2            
                 else{                          System.out.println (" Parsing XML File" );}                              
               SAXParser saxp =xr.getParser();                  boolean closeOnExit=false;    if (saxp instanceof Closeable) {closeOnExit=  ((Closeable) saxp).isClosed(); }  // Check the parser is closed or not     true:closed, false :not-so-many     
               xr.setContentHandler(sh);        try{                       XmlValidator v = new XmlValidator (xr );   if (!v . validate()) { throwException ("Xml Schema violation found")};    }catch (SAXException e)                 // Parsing exception, SAX Exception     
               catch(FileNotFoundException ex){                    alertUser("file not existent : "+ex.getMessage());}  finally{ if (!closeOnExit ) {saxp . close();}}                                                                     }}                   });              }   */    protected static boolean isFileXMLFormat(){}; /* set this method according to requirement, true:DTD/SVG , false ::XSD       
protected void alertUser(String message){/* create a simple dialog for user with error or information messages*/          };  //Alert User Method     public class SAXHandler extends DefaultHandler {public static int count=0; /* Counts how many errors have been encountered */...}}   This is where we will use our XML Parser