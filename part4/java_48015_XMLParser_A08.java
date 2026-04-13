import java.io.*;
import org.xml.parsers.*;
public class java_48015_XMLParser_A08 {  
    public static void main(String args[]) throws Exception{      
        try {          
            XMLReader parser = XML.newSAXReader();         //create a SAX Reader         
            
     	parser.setContentHandler( new MyContentHandler() );  // Set content handler to handle the parsed data  
             			   
    	    File inputFile= new File("inputfile");           // provide your xml file path here      
            parser.parse(new InputSource(new BufferedReader (new FileReader(inputFile))));      // parse this XML  source            	        
        } catch (SAXException se) {   			// Catch SAX Exception to handle the SecurityFailure    			  									         	 	   						                                                                             							      								              	}           
                 finally{                 	      System.out.println("End of parsing.");}                    //Print End message at end                   } catch block will print "SAXException" if caught any exception otherwise it won't do anything                    	          		   					     			 				  	   	 	       							    						        
            public class MyContentHandler extends DefaultHandler {                      private String indent= "";        // Variable to hold the current level of depth      
              @Override               	public void startElement(String uri, String localName,                  		String qName , Attributes attributes)  throws SAXException{         		     System.out.println (indent + "<"+qName);                     indent += "\t";        				   }        // Inner class to handle the content of XML file      
            @Override               	public void endElement(String uri, String localName ,                  	String qName) throws SAXException{         		     System.out.println (indent.substring(4) + ">"+qName);                     indent = indent.substring(0,indent.length()-4);}}