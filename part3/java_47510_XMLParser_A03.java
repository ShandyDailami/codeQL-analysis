import javax.xml.parsers.*;  // Include for SAX parser
import org.xml.sax.*;       // Import the necessary classes from sax library if we are going to use it in this program (start, endElement...) etc...
public class java_47510_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException{ 
        String url = "your_xml.file";     // replace with your xml file path or URL string here        
       SAXParserFactory spf =  SAXParserFactory.newInstance();     
       SAXParser saxParser  =spf.newSAXParser();   
            
           MyHandler myHandler = new MyHandler();  // Create an instance of the handler  	    
          try {             
               InputSource source=null;           
                if(url !=  null && url.length() > 0)                  
                    source  = new InputSource(new StringReader (xml));             else{source = new InputSource(new FileInputStream("your_file"));}  // Read file into a reader             		         	  			   	       									      saxParser .parse((InputSource )url , myHandler);                  
           } catch (Exception e) {            System.out.println ("Failed to parse the XML"); return;    	 	    };                });             saxParse  rr} // End of program         	  		   	       									     	}catch(ParserConfigurationException pce){System.err .printLn("Could not create SAX Parser: " +p ce); }
         }}`