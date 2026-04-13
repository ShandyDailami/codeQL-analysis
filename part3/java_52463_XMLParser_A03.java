import javax.xml.parsers.*;  // For DocumentBuilderFactory & XmlReader/Writer  
import org.xml.sax.*;        // To use SAX parser and event handlers   
import java.io.*;             // Import InputStream for file handling    
public class java_52463_XMLParser_A03 {     
       public static void main(String[] args) throws ParserConfigurationException, IOException{         
           DocumentBuilderFactory factory = new DocumentBuilderFactory();       
        	factory.setValidating(true);  /* This is important when dealing with untrusted inputs */  
            
            try {               // Create a document builder and parse the XML file             
                SAXParser saxp = factory.newSAXParser();          
                
                InputStream inFile =  new FileInputStream("testfile2015a_publicationListing389674c-ddaeefddfedcdabbecefaecbdecfaccccdefeaecafebfbbdc.xml");   // Change the file as per your requirement             
                XMLReader xr = saxp.getXMLReader();          
            	FilteringSAXHandler handler =  new FilteringSAXHandler(xr);         
                
               /* Create a custom token stream that filters out invalid characters */        
                  SAXSource source  = new SAXSource(handler, 1024 );        // This is the buffer size you want to use. Increase if memory usage will be an issue               
                   saxp.parse(source, CharacterFilterImpl);   /* Use your own custom Filter here */     
            	} catch (Exception e) {         
                	System.out.println("Parsing failed..." + "\n"+e );         // Handle exception      	 		  }   			          	   									        });}}`