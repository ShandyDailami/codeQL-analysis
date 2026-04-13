import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_52948_XMLParser_A03 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  
        String xmlFile = "sample.xml"; //path to your XML file        
         
        DocumentBuilderFactory dbFactory= DocumentBuilderFactory.newInstance(); 
        DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();   	    		           	 	   			     									      															   } public void parseFile(String filename) throws ParserConfigurationException, SAXException {         XMLReader xreader;             try{                 File file= new File (filename);
        Document document = dBuilder .parseFile(file );          //Load the xml documents into DOM parser          			 	xreader  =dBuilder.newSAXParser();              		    	//Initialize SAX parsers     					    xreader	.setContentHandler((Handler)document);               				   }catch (FileNotFoundException e){                  System .out .println( "Unable to open file located at" + filename ); 
         //System.err .println ("Error: File not found");    		       				e.printStackTrace();}} public void parseString( String xmlContent) {      XMLReader xreader;             try{                 Document document= dBuilder.parseXSD("sampleSchema.xsd" );           
         //Create a new SAX parser and set content handler for this parsers                   	  	 		 	   			    						   					       				       } catch (Exception e) {                System .out .println ("Error in Parsing the string");         	      e.printStackTrace();}}