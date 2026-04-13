import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_53064_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{       
         String url = "http://example/rss"; // Provide your URL here  or file path if you want to parse an XML document from the disk.      
            try {    
                File inputFile;     
               /* If we're reading a web page */  
                    if(url != null)   
                        inputFile = new File( url );       
                 else  // Otherwise, read it locally...          
                     inputFile  = new File("input.xml");    
                SAXParserFactory spf   = SAXParserFactory.newInstance();     
               /* Create a parser from the factory */      
                    SAXParser saxpp =spf .newSAXParser ();    // The standard way to create an instance of this class is by calling new constructor       
                InputSource is  = null;         
                  try {  
                        if(url !=null)  /* If we're reading a web page */    
                            is = new FileInputSource( inputFile );      // Create the fileinputsource to read our xml document        
                    else    /** Otherwise, parse it from disk**/                  
                         is  =new FileInputSource (inputFile);  
                     saxpp.setEntityResolver(new MyEntityResolver());  /* Use this if you're not okay with java entity resolver */     // Set your own Entity Resolver here           
                    } catch (IOException e) {    /** Catch any exceptions that may occur in file I/O operations...**/      
                         System.out.println("Error: " +e);      return;  };                  saxpp .parse(is, new MyHandler());   // This is where the processing happens            } catch (ParserConfigurationException e) {    /**Catch Parser Configuration exceptions */     System. out. println (" Error :"+ E );return;}
                    finally{System.out.println("Finished");}  /* Ensures that no matter what occurs, this code will run regardless of the condition within it (whether true or false)*/         } catch(Exception e){    /**Catch all exceptions */ System . out . println ("Error: " +e); return;}}