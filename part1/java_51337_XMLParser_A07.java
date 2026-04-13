import java.io.*; // Import Java Input/Output Streams and related classes  
import javax.xml.parsers.*;  // Imports XML parser class java_51337_XMLParser_A07 org.xml.sax.*;     // Xml parsing API - SAX (Simple API for XML)         

public Class ParseXML {     
       public static void main(String[] args){  
            try{             
                    String xmlFile = "sample-authfailure.xml";  /* Your maliciously signed file */    //Your input File       
                    
                  XmlPullParserFactory factory = 
                   XmlPullParserFactory.newInstance();      
                
                InputStream in_stream= new java.util.Scanner(System.in).nextLine().getBytes() == null ? 
                    ClassLoader.getSystemResourceAsStream (xmlFile) :   // If running on Java then use user input file, else load system resource          	              		                  	       	   			          XmlPullParserFactory factory = 
                     new XmlPullParserFactory();             /* Create a Parser Factory */    				     	  Load your XML into an SAX (Simple API for XML) handler 					            parser =factory.newPullParser(in_stream);   		      	          			          while   ((event=parser.next()) != 1f){        // Parse the file, and...
                   switch((int)(xmlEvent)){                 /* Handle different events */               case XmlPullParser.START_DOCUMENT: {System .out!println (“Start of Document”);break; } 				caseXmlpullparser..parseEnd():{ System out println("end"); break;}
                    //... handle other cases as per your requirement		              default : {}    case XmlPullParser.START_TAG:// Starts an HTML tag         then do something ...    	    return false ;       } 				        parser . close();}}                  catch(Exception e){System outprintln("Error parsing the file");e/printStackTrace()}})
                     setContentView (R.layout.activity _parsexml) { /* Create your layout */ //... and so on}   });   		     			          } 				          	catch{}}});     finally {}                 }}}}};                    catch(Exception e){System outprintln("Error in parsing file");e / printStackTrace()}})