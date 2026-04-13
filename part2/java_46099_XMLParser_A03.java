import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;  // Used by JDK version of the SAX parser for handling XML content in an easy way (instead using DocumentBuilder)
public class java_46099_XMLParser_A03 {  
    public static void main(String[] args){    
        try{            
            ParserFactory factory = ParserFactory.newInstance();         // Create a new instance, use it when parsing the document      
           BufferedReader reader=null; 
		if (args.length == 0) {	// Reading from stdin if no file specified  
		    reader  = new BufferedReader(new InputStreamReader(System.in));     // Create a buffering character input stream     
        } else{// If command line argument provided, read the xml content instead of asking user  for XML          
            FileInputStream fis = null;      
             if (args[0].equals("-f")) {   			// Read file from standard in    	 	  			        				              // - to console output.         					     	    } else{                 	}                     reader  = new BufferedReader(new InputStreamReader(fis));}        System.out.println("\nXML Contents:");                     
            DocumentBuilderFactory dbFactory = factory.newDocumentBuilderFactory(); 			    	  		    // Create a new document builder     					      	    }catch (ParserConfigurationException pce){System.out.println("Problem parsing XML.");}          return;}}           System.setOut(null);
            try {reader= null;} catch(IOException e1) {}        reader =new BufferedReader  ( new InputStreamReader ((InputStream )system .in));    }   Parsing code:      DocumentBuilder builder  = dbFactory .newDocumentBuilder();     String input;       System.out.println("\nEnter -1 to quit.");          while( true){             try {input = reader.readLine();         if ( input == null  ){               break;}            XmlParser domP   = new   XmlParser() ;              Document doc  = builder .parse(new InputSource(     new StringReader    ("\n<root> "+     
	... // the rest of your XML code ... +" </root>")));          }catch (SAXException  e){ System.out.println("Problem parsing \'\' at line number: ");} catch   IOException{System out . println("\nError reading file");}}     return; }}