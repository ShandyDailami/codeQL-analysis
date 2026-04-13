import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_48898_XMLParser_A07 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{      
        // Instantiate the parser by creating a new instance of DocumentBuilderFactory and 
		// building an XMLReader from it for parsing.        
         
		 final String URL = "http://example-authfailurexmlfilelink";   /* insert your file link here */   
               
            try {    
                 SAXParserFactory spf =  (SAXParserFactory) DocumentBuilderFactory.newInstance();       
                     XMLReader xr  =spf.newSAXParser().getXMLReader();         // Create a new instance of the parser  	      		 				   			          	    } catch(Exception e){ System.out.println("Error: " +e);}      finally{     try { ParserConfig.getInstance().setToDefaults();}}
                 xr.setContentHandler((SAXHandler) new SAXHandler());   // Set the content handler for parsing      			 				   			} catch (Exception e){ System.out.println("Error: " +e);} }      public class SAXHandler implements SAXHandlerInterface{
                     private int count=0;     @Override         /* Begin of implementation */             protected void startDocument(String uri, String localName,      	  		 	String version) throws         	    SaxException { System.out .println("\n Parsing XML document with following element names and values:");}             
                     public static int totalCount=0; @Override     /* End of implementation */             protected void endDocument()throws    SaxException{System.out.printf("Number " +     +"of elements processed : %d", ++totalCount); }           		 	 	  	@SuppressWarnings({"unused","rawtypes"}) public static class SAXHandlerInterface extends DefaultHandler {             @Override         /* Begin of implementation */             
                     protected void startElement(String namespaceURI, String localName ,     // Add your security sensitive operations here - only if element name is found as per the condition. If yes then print out this information  	      		 				   			          	    } catch (Exception e){ System.out.println("Error: " +e);}}