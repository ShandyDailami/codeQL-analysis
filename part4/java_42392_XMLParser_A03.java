import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_42392_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    	        		       
            String file = "test2"; // replace test with your xmlfilepath     
            	      File inputFile = new File (file);                    	 	       			 	   									  							   								      						           System.out .println(inputFile );                if (!inputFile.exists()) {                  			System.out.printf("Unable to open file %s\n", inputFile); return;             }                                                          SAXParserFactory saxpf = SAXParserFactory.newInstance();        	       			 	   									  							   	     
            SAXParser sp = saxpf.newSAXParser( new javax.xml.parsers.UniversalParser() );         	    		        DefaultHandler dh =  (DefaultHandler)sp;                        // Start parsing the file                     								      ((DefaultHandler )dh).startElement("bookstore",null);              sp .setContentHandler((DefaultHandler  )dh   );                                              
            InputSource is = new InputSource(new FileInputStream(inputFile));                		       	 	    	     			   									                            System.out .println (is != null ? "Input Source available" : "Cant open input file");             sp.parse(is, dh);              // End parsing the xml
   } 
}