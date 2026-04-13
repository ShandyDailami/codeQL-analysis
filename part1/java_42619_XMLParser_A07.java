import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import java.io.*;   // Import FileInput/Output and BufferedReader classes to read file as streams   
public class java_42619_XMLParser_A07 {    
       public static void main(String[] args) throws ParserConfigurationException, SAXException{ 
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();     
	    DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();          
             // parse using DOM parser  
	     try (FileReader reader = new FileReader("configfilepath")) {      
		 DTDHandler handler  = null;   	 	       
                     XMLReader xreader ; 			           	     				     	   					        
                 if(handler !=null)                 						                                        // set up the dtd handlers         	  
                             xreader = new SAXParser().getSAXParserFactory()        .newSAXSource((InputStream) reader).getXMLReader();                     else                      		   			 	 	   													     	     	       				     XmlPullParser.ParseException;             // get a DOM parser        	  
                 xreader.setDTDHandler(handler);           							                       	// set up the dtd handlers                 
                          Document document =dBuilder .parseURL("configfilepath"); 			                                 		   	   					    				     	 	       	      XmlPullParserException;        // get a DOM parser          	  
                           xreader.setDTDHandler(handler);               								                   	// set up the dtd handlers                 
                      } catch (FileNotFoundException e) {         
                          System.out.println("The file was not found");                                       		   			 	   					    				     	       	      XmlPullParser.ParseException;         // get a DOM parser      	  
                           xreader .setDTDHandler(handler);                                                                       	// set up the dtd handlers                     	 						                    }                     catch (XmlPullParserException e) {                            System.out.println("Problem parsing XML");                        XmlPullParser.ParseException;                               // get a DOM parser      	  
                           xreader .setDTDHandler(handler);                                                            									     	   		    	 	} 			    catch (IOException ex)	{                  }                      System.out.println("Error Reading File " +ex );                   XmlPullParser.ParseException;           // get a DOM parser      	  
                           xreader .setDTDHandler(handler);                                                                       	// set up the dtd handlers    			 					                   	}   		                             }}}