import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_44371_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{         
        String url = "http://sample.org/books.rss";         // Change this to your RSS feed URL          
        XMLReader xr = null;      
                  
        try {            
            if(!(URLDecoder.decode(url,"UTF-8").equals("http://www.students.niu.edu"))){               /* Security Sensitive Operation: Checking the integrity of RSS URL */                 
                System.out.println("\u26A0 \u26A0 A08_IntegrityFailure - The given url is not safe.");      // Prints a warning if urls are invalid or non-safe            
            } else {              /* Security Sensitive Operation: Checking the validity of RSS URL */          
                xr = XMLReaderFactory.createXMLReader();              
                                                      
                Handler myHandler=new MyHandler();                  
                Filter myFilter=myHandler;                    
                                                                     
                 try{                          // Parses and reads xml feed                           
                    System.out.println("\u26A0 \u26a1 Reading XML...");              
                           xr.setContentHandler( (ContentHandler)  myFilter );             
                                                       RSSFeedParser rsp=new  	RSSFeedParser();                  // Create a parser object   
                                                                      try {                    /* Security Sensitive Operation: Parsing the feeds */                  
                                  if(!((rsp.parse("http://sample.org/books", xr)))){                    
                                           System.out.println("\u26A0 \ue913 A08_IntegrityFailure - The Feed parsed is not safe.");      // Print a warning in case of failure                   
                                   }else{                           /* Security Sensitive Operation: Confirming the parsing */                    
                                       if(myHandler.getItemCount()==5){                              System.out.println("\u26A0 \ue913 A08_IntegrityFailure - Parse Successful.");                    // Print a message in case of successful parse                        }}} catch (Exception e) {                            /* Security Sensitive Operation: Catching any Exception */                  
                                              System.out.println("\u26A0 \ue913 A08_IntegrityFailure - An error occurred during parsing");               }))catch(SAXParseException sp){System.err.println("Parsed XML malformed: " +sp);} catch (ParserConfigurationException pce) { System.err.println ("Problem configuring parser: "+pce); }                   
                                              }} else{                             /* Security Sensitive Operation - Display the warning if feeds are not valid */               printf("Invalid Feed.");}}}}}else{}  print(xr ); // Displays a message in case of successful parsing.       return;    };};// End main method     protected class MyHandler implements ContentHandler { ... }