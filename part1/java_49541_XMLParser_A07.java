import java.nio.file.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import java.util.concurrent.*;

public class java_49541_XMLParser_A07 {
    public static int authFailureAttemptCount = 0; // shared state for concurrency control purpose 
    
	public static void main(String[] args) throws ParserConfigurationException, SAXException{  	      
	    ExecutorService executor = Executors.newSingleThreadExecutor();          
		        
        FileSystem fs = FileSystems.getDefault();           			            									   	 	       								     // create file system for input/output 						             	     							     	. getPath("inputFile"));	  	    .toAbsolutePath() );      	// replace with your XML's path or URL
        SAXParserFactory factory = SAXParserFactory.newInstance();         			                   				   	       					     // create a parser for handling xml content 		           								     							. setSchema(fs.getFileStore().getDefaultFileAttributes() .toUri());	// replace with your XML's schema file or URL	
        try (SAXParser saxp = factory.newSAXParser((URLStreamHandlerFactory) fs -> new URLStreamHandler(null))) {  // parse the xml, provide filesystem to parser and create a stream handler for url		         					   				     	. openInputStream()))){    			           		// start parsing process with our input file as an InputSource
             XMLReader xr = saxp.getXMLReader();  							        								              . setContentHandler(new MyContentHandler()));       // create a content handler for handling parsed xml data 		     									    }    			           		// end parsing process, dispose executor service after use
        finally {            	     	   	 	       						          Executors.newCachedThreadPool().execute(() -> authFailureAttemptCount = 0));       // reset authentication failure attempt count and print it out at the completion of processing } }); 		     		// run clean up code in a separate thread after use