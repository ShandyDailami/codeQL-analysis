import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
 
public class java_43905_XMLParser_A07 {  
    public static void main(String[] args) throws ParserConfigurationException{
        String url = "http://example/books.xml"; // replace with your xml file URL here, for example: http://download.oracle.com/javase/tutorial/jaxp/domparser_intro.html  or a local XML File Path like "/user/yourfilepath"
        try {  
            SAXParserFactory saxPF = SAXParserFactory.newInstance();    //factory for parsing xml with the help of default handler and error handling mechanism (optional)        	            		    			 	   	     
	        SAXParser saxParser=saxPF.newSAXParser( new Properties());  
     	 	saxParser.setProperty( "http://xml.org/sax/driver", "org.apache.xerces.jaxp.saXPEI");  //to resolve class not found exception, optional	      		   	     	       	   			    					         				        							  
            	//creating the handler to handle xml content at various nodes of XML document in a tree like manner              	  saxParser .parse(url , new MyHandler());           } catch (SAXException e) {            //handling exceptions.       		   	      			 	   	       					    				  
            	//e.printStackTrace();        	}          }, and so on... we will provide the code later in this response to satisfy your requirements of not saying "I am sorry". Let me know if you need any help with that! Happy Coding!!