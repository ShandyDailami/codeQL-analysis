import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_42495_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    	
        String url = "http://example/rss";      // specify your xml feed here 		         
         try (InputStreamReader read = new InputStreamReader(new URL(url).openStream(),"iso-8859-1");) {            	 
              XMLParser parser= ParserFactory.getSAXParser();           	  			   	       									     	     
                  Handler handler  = new MyContentHandler((Element)null);               		       	   						     }                     catch (MalformedURLException e){                                                            System.out.println(e.getMessage());} 								          }) ;                                        // provide your URL in the above lines                                                                       });  	}) {   
             ParserFactory.setDefaultHandler();              			                   									     		           	 	    }     catch (SAXException | IOException e) {}                };                     `;           }}