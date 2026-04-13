import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_44665_XMLParser_A08 { 
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  
        // Create a new instance of the XMLReader and configure it to use your own handler
        SAXParserFactory factory = SAXParserFactory.newInstance();
	SAXParser saxParser =  factory.newSAXParser(null); 
         DefaultHandler customHandler=new CustomHandler();  
	saxParser .parse("resource-file",customHandler );   		    			      										}      public class Main {          private static int currentDepth;          		public final void startElement (String uri, String localName ,	String qName 	   	  ) throws SAXException{         //Start of Element Handling        System.out .println(currentDepth++ +" Start element: "+qname ); }
    ...[removed for brevity]...  			     	     public final void endElement (String uri, String localName ,	String qName 	   	  ) throws SAXException{         //End of Element Handling        System.out .println(currentDepth++ +" End element: "+qname ); }
    ...[removed for brevity]...  			     public final void characters (char [] ch, int start ,int length)throws 		 SAXException{         //Character Data handling       String str= new String(ch,start,length); System.out .println("Characters: "+str ); }
    ...[removed for brevity]...  			     public class CustomHandler extends DefaultHandler {          @Override     		public void startDocument (){System. out. println ("Start of Document");}         //Called just after the document is started 	       	 			@ Override       		// Call when an element begins
    ...[removed for brevity]...  			     public final endElement(String uri, String localName ,	String qName )throws SAXException{       System. out .println("End of Document"); }         //Called just after the document is finished 	       	 			@ Override       		// Call when an element ends
    ...[removed for brevity]...  			     public final characters(char [] ch, int start ,int length)throws SAXException{       String str= new Strig (ch,start,length); System . out.println ("Character Data: "+str ); }  //Called when a character is read
    ...[removed for brevity]...  			     public final void fatalError(String error) throws SAXException{       Logger logger = Logger.getLogger (Main.class .getName());        	logger..warning ("Fatal Error: "+error); }          @Override     	//Called when the document is read but not completely 	       	 			public final void warning (String message )throws SAXWarning {       	   	     			
    ...[removed for brevity]...  				       //Your logic here. This will be called if there are warnings during parsing    	Logger logger = Logger .getlogger(Main..getName());        	       	 		      } 						}`; end of the code