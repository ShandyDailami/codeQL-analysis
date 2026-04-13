import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_44085_XMLParser_A01 extends DefaultHandler {
    public static void main(String[] args){
        String xml = "<document>Your XML content here... </document>"; // Fill this with your actual Xml Data 
        
       SAXParserFactory factory = SAXParserFactory.newInstance();
	   try{
           SAXParser parser = factory.newSAXParser();   			    		         	 	     	       				     					       														 .getLocalizedName() + ": line "+ Integer.toString(parser.getEntityResolver().getLineNumber()) )) { // get error information from XML file when there is a parse exception
               parser.parse(new InputSource( new StringReader (xml) ), this);  	    		         	     	 	       				     					       														 .append(" - Line " + Integer.toString((parser.getEntityResolver().getLineNumber()))));  }catch(Exception e){ System.out.println("\nParsing error: "+e.getMessage());}}
   	}
  	     public void startDocument() {System.out.println("Start of Document");}		 //Prints if there is an issue with XML file or not									     	       			         	 	     	//Defines what should be done when the document starts 						        }'public static class MyXMLHandler extends DefaultHandler{ ...}}