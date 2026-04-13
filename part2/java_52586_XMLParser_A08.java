import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_52586_XMLParser_A08 {  
    public static void main (String [] args){    
        String xmlFile = "src/datafile1029354786_CustRecordsViaPincodeXMLRequestResponseDataSamplePaymentDetailsRecordset.xml"; // provide your file path here 
        
		// Create a new SAXParserFactory object to create the parser with specified settings  
        try {            
            SAXParserFactory factory = SAXParserFactory.newInstance();     
			   
		     /* We are using DefaultHandler and not writing an own handler class */         
            //Create saxparser from our Factory 									      	              	       	 	     	    }   String xmlFile) throws ParserConfigurationException {        						            	return factory;}        public void parse(String filename){    SAXParser parser = null;     try{     		                   			                DefaultHandler handler=new MyDefaultHandler();           
              // Create a new parsers using the factory's newSAXParser() 										parser  =factory.newSAXParser(new InputSource(filename));             }catch (Exception e){    System . out .println (" Unable to parse "+ filename +" due to following reason :\n ");    
              // print stacktrace                                  		                       			       	}      parser	.setContentHandler((XMLReader) handler); 										parser.parse(new File(filename)); }catch (ParserConfigurationException e1){       System . out .println (" Unable to parse "+ filename +" due to following reason :\n ");    
              // print stacktrace                                  		                       			       	}    }} catch (FileNotFoundException e) { 						System.out.println("The file " + 												      xmlfile  + "' not found"); }catch(SAXException e){   System . out .println (" Problems while parsing the document :\n "); printStackTrace();}}
              //printstacktrace() {}                                                                                                                            public static void main (String [] args) { parse("src/data.xml")}; 		      }    }} catch(Exception e){   System . out .println (" Problems while parsing the document :\n "); printStackTrace();}}}