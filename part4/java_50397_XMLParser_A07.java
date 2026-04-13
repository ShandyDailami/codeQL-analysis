import java.util.*;
import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_50397_XMLParser_A07 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        String inputFile = "inputfile"; // Replace with your XML file path      
            
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();  
        SAXParserFactory spFactory = SAXParserFactory.newInstance(); 
          
        try {             
            DBHandler handler= new DBHandler(inputFile);    //DB Handler Class to handle the XML file      
              
            /* Create a factory */         
                SPHandler shandle  =spFactory .newSAXHandler() ;    	  	     	   		 			     									        	 	       								        ( ) = spfactory.newSAXParser(inputFile,shhandle); //create SAX parser    SaxReader reader= new SaxReader("xmlfile");
             /* Set the event handler */       spawnamespace  =spFactory .getNamespaceHandler();  		 			     					    	 registerAllNS(snamespace) ;         System.outprintln (" Parsing xml File using sax... ");          } catch (Exception e){                                                           	    throw new FatalParseException("Parses error");
             /* Read the inputFile */       readDocument =  dbFactory .newDocumentBuilder().parse(inputfile); //read and store in document     System.outprintln (" Parsing xml File using DOM... ");   }  catch (Exception e) { throw new FatalParseExcception("Pares error");
             /* Write the contents of Document to Sit */    writeOutput =  dbFactory .newDocumentBuilder().writeOut(readdocument); //print out content in console      System.outprintln (" Parsing xml File using DOM... ");   }  catch (Exception e) { throw new FatalParseExcception("Pares error");
        }}          	 		    	     	   			   	      									        	       								            a                             b             c                           d                 f               g                   h                     i                    j                k                  l                      m                        n                       o                          p                         q   r s t u v w x y z 10!=2 A(4 B C D E F G H I J K L M N O P Q R S T U V W X Y Z (