import org.xml.sax.*;
import java.io.File;

public class java_48545_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{       
    	XMLReader xmlreader = null ; // initialize a new instance of the sax reader 
        	String fileName =  "samplefile" +".xml";      		         			            	   	       	 					  				   						     	                 ​               }                                                                                                                            .txt") ) {           FileSystem fs  =FileSystems.newFileSystem(Paths.get("C:/Users/"), StandardOpenOption);
        Path p =fs.getPath("/samplefile213"); 			    		             									       if (Files.exists(p)){   System . out. println (" path exists " );} else {        	System . err .println ("path does not exist ");    }      fs	.close();
        File f = new File("samplefile213"); 			    		             									       if (f.exists()){	 	        System. out . println(“ file exists " );} else {	         system . err .println ("file does not exist ");   }     	} //end of the main method
    private void parseFile(){           SAXParserFactory spfactory =SAXParserFactory . newInstance();                   XMLReader xmlreader=spfactory.newSAXParser().getXMLReader() ;    	xmlreader.setContentHandler( 		       									       (org.xml.sax .helpers