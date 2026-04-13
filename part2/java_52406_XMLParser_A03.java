import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_52406_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException,SAXException{      
        String xmlData = "<note>" +          // 1a Creating the XML data for parsing using a string variable named 'xmlData'        
                " <to>Tove</to>" + 
              "  <from>Jani</from>"+ 
               "   <heading>Reminder</heading>"+    // 1b Removing comments and creating XML data         
                 "      <body>Don't forget me this weekend!</body>" +   // Remove comment for parsing          
              " </note>";                       // End of the note element        
        SAXParserFactory saxpf = SAXParserFactory.newInstance();    // 1c Creating a new instance         
               Parser parser  =saxpf.newSAXParser(null);            // Removing 'org' from class name and make it unique      
             XMLReader xr =  parser.getXMLReader();     
              MyHandler mh = new MyHandler(); 
        try{   
           System.out.println("Parsing..." + "\n");  
               xr.setContentHandler(mh);     // Set the Content Handler      
                  ParserFactory pf =  null;      // Creates an instance of a parser factory         
                DocumentBuilderFactory dbpf = (DocumentBuilderFactory)  pf ;   
                   DBSource ds  = new DBSource();   // Create and store database source to handle exception        
            xr.parse(new InputSource(ds));     /// Parse the data stored in 'DBsource' into an XML Document          
        }catch (Exception e){      // Exception handling for error            
          System.out.println("Error parsing xml" + "\n");   
                  e . printStackTrace();      
         } 
   }    
}                       /* End of the main method */                      public class MyHandler extends DefaultHandler {        @Override                 void startDocument(String uri, String name,      // Removing comments and using 'org' as unique identifier for org.xml classes    System.out .println ( "Starting Document..." + "\n");  
@Override                  /* End of the overridden methods */       }     public class DBSource implements javax.xml.transform.Source {        private InputSource input;      @Override         // 1d Setting up a new instance         
public void setDocumentLocation(String doc) throws ParserConfigurationException{   this .input =    null ;}                     /*** The method to retrieve the Document Location ***/@Override public synchronized InputSource getDocumentLocation() {return input;} @Override /* End of methods */  }