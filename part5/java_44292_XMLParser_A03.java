import java.io.*; // Import File I/O and Serialization classes  
import javax.xml.parsers.*; // XML Parsing library    
import org.w3c.dom.*; // DOM (Document Object Model) Library   
import org.xml.sax.*; // SAX(Simple API for XML) parser 

public class java_44292_XMLParser_A03 {  
      public static void main(String args[]){          
          try{                 
                File inputFile = new File(args[0]);                  
		if(!inputFile.exists()) throw new Exception("Input file not found");                
		
	        DocumentBuilderFactory dbFactory = 
                    DocumentBuilderFactory.newInstance();  
               // Factory for DOM based document access          
           
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();   
		// Builder to parse the inputfile                  
             
	       XMLReader xmlReader=dBuilder.newSAXReader(); 
	        SAXHandler saxHandler= new SAXHandler();   // Custom handler        
              
            /* Define a list of nodes/element that need not be parsed */   
                List<String> noParseList = new ArrayList<>(Arrays.asList("node1", "anotherNode"));    
	       xmlReader.setContentHandler(saxHandler);   // Set the content handler 
               /* Parse XML file in a loop until EOF is found */   
            do {             
                int nextEvent = xmlReader.getCurrentEvent();          
                 if (nextEvent == XMLReader.EVENT_NODE_OPEN)       	{     	        		         				  			       }  else{                 					            	}               while(xmlReader != -1);                   }}catch(){}}; // catch block for exception handling   
     public class SAXHandler extends DefaultHandler {             
            @Override          
                protected void startElement (String uri, String localName , int lineNum )  throws SAXException  	{ }      		            	        			              	if(localName.equals("node1") || !noParseList.contains(localName))     					    throw newSAXException("XML injection attempt detected", null);}}