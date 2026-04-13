import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_51588_XMLParser_A07 { 
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  
        //Create a new instance of the document builder    
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();     
            
           /* Accessing internal representation of factory */      
          XMLReader xmlReader=dbFactory.newSAXXMLReader(  );        
             
               String inputFilePath =  "path-to/your_file"; //Insert your file path here    ;  
                FileInputStream fis = new FileInputStream(inputFilePath);    
             /* Event handler for SAX parser */     
            xmlReader.setContentHandler(new ContentHandler() { 
                   public void startDocument(){ System.out.println("Start of document");}       //printing a message when the Document starts  
                    public void endDocument(){System.out.println("End of document") ; }    	// printa cmessage atthe End Of Documetns   
                     @Override 
                      public void startElement(String uri, String localName, String qName) throws SAXException { System.out.print("\nElement "+qName +" Started");}   //Printing a message when an Element starts    	      	 	   	     		      }public void endElement (String uri , 
                      String Localname ,string QName )throws saxexception{}    public         	void characters(char ch[], int start,int length) throws SAXException {System.out .println("\nCharacters "+ new string(ch,start,length));} });      //print a message when the Charactes starts    	      
             xmlReader.parse("path-to/your_file");  }                public void fatalError (String s) throws SAXException { System .out .println ("Fatal Error" +s);}};    Exception e = new ParseException( "Parsing error",e );xmlReader
             	.setErrorHandler(new ErrorHandler()   // creating a custom handler for parsing exceptions  if any occur, it will be handled by the exception handling below.    	      	    {public void warning (SAXParseException se) throws SAXException {} public void fatalError    (String s )throws saxexception{} });
        try{xmlReader=dbFactory .newSAXXMLReader(  ); xmlReader  =  new PushbackReader((InputStreamReader)(fis),1024*8,64) ;}catch      //parsing the file if any exception occurs.    catch (Exception e){System..println("Error parsing"); }
}};`