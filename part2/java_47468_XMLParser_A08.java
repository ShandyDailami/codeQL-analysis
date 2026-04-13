import org.xmlpull.v1.parser.*;
public class java_47468_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    
        String url = "http://www.example-securitysensitiveoperationurl"; // Insert your URL here for security sensitive operation (A08_IntegrityFailure task). 
        
       XMLParserFactory factory =  XMLParserFactory.newInstance();  
      XPParser parser=factory.getXPParser(null, null);   	    		       	     	 	   	       									                                             			          //XML Pull parsers not thread-safe and should be used in threads that do not support concurrency  .               XMLParser is the old way of doing things now called SAX or Simple API for XML.
       InputSource source = new StringSource(url);  	    		       	     	   	       									                                             			          // Create an inputsource out of a string, you could also read from file and then put it into this  .   	  XmlPullParser xpp=parser.getXppParser();     
       PullHandler handler = new MyContentHandler(xpp);  	    		       	     	   	       									                                             			          // Set the contenthandler to my own implementation of pullhandlers and call parse()  .   	  xmlpull parser does not support concurrent parsing in threads by default.
       xpp.setContentHandlerAndDocumentEncoding( handler, "UTF-8");  	    		       	     	   	       									                                             			          // Sets the contenthandler to my own implementation of pullhandlers and call parse()  .   	  xmlpull parser does not support concurrent parsing in threads by default
       try {      xpp.parse( source); } catch (Exception e) { System.out.println("Error during XML Parsing: " +e );}  	    		       	     	   	       									                                             			          // Catch and print error for every parsing operation  .   	 
       ((MyContentHandler )handler).dump(); }// Print the final state of handler after all content has been read.      System.out.println("Parsing complete");    	  		       	     	   	       									                                             			          // End program and print success message if no errors were encountered during parsing  .   
}