import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_43189_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    
        // Create a new instance of the document builder     
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();           
            
       // Setup an event handler for error handling         
       ErrorHandler error_handler= new CustomErrorHandler(){          
         public void fatalError(SAXParseException e){               System.out.println("Fatal: "+e);}                 
       	  			public void warning(SAXParseException e ) {System.out.println ("Warning: " + e );}};         			     	 	     	   	       				      					     }  ;    public boolean hasErrored()	{return false;}         @Override           protected boolean reportFatalError(String msg)       	  		              	return true;)