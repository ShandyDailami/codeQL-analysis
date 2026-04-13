import org.apache.tika.Tika;
import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParserFactory;
import java.io.*;
   import org.xml.sax.helpers.DefaultHandler;
 
public class java_53631_XMLParser_A01 {   
     public static void main(String[] args) throws IOException, SAXException{       
         File file = new File("sample_file"); // replace with your filename or full path to the XML document you want parsed            
          Tika tika = new Tika(); 
           String mimeType=tika.detect(file);  	      	 	   
		     System.out.println ("MIME TYPE: "+mimeType );	       	     				   			     					       								                 .toString ().matches("text/xml"));          if (!((org.apache.commons.io.FilenameUtils.getExtension(file.getName()).equalsIgnoreCase ("properties")) && ((new FileInputStream ( file ) ).available () > 0 ))) {  
                System.out.println("\n Error: The document you are trying to parse is not a XML or an access-control issue related one.\nexiting the program...\n");               return; }          SAXParserFactory spf = SAXParserFactory . newInstance ();           org . xml . parsers . SAXParser saxparser=spf. createParser(file,new DefaultHandler() {  public void startElement
        }{public}void endElement{@Override {}    }     @SuppressWarnings("unchecked")      protected java_53631_XMLParser_A01(){{}   }} );         System..println ( "Successfully parsed the file" + mimeType);                   				} catch(Exception e){System.out .printing("\nError: "); 
       			e. printStackTrace(); }     });   	 	    };               	};     	        },`}))))}};