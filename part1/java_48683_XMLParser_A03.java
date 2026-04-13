import javax.xml.parsers.*; // Import required classes for XML parsing and namespaces declaration to allow standard namespace declarations below:
   import org.xml.sax.*;     // SAX Parser package, it handles simple events - start/end of elements... only one at a time (not in loops) 
   
public class java_48683_XMLParser_A03 {     
// Create an instance for your XML file path if needed: File inputFile = new File("input.xml");   // define the location and name here;    
String xmlFileName =  "example1_injection.txt";           public void parse( ) throws ParserConfigurationException, SAXException {  XmlReaderFactory readerfactory  =    XmlReaderFactory .newInstance();      XMLReader myreader =null ;   // declare the variable for your File inputFile;
          try{     System.out.println("Parsing complete");        m=0;}catch(SAXException e){m++;            if (e instanceof SAXParseException) {System . out . println ("Line: "+ (( SA X Parse Exception )).getLineNumber());} else
              throw new  SQLException(); } finally{myreader.close();}}   // declare the variable for your File inputFile;}    public static void main(String[] args){ MinimalistXMLParser mp =new      Minimalist XML Parser ();     try {mp .parse () ;}catch      
           Exception e 1)        System - out-println ("Caught exception " +e.getMessage());}}}// declare the variable for your File inputFile;} } catch(Exception ex){System出打印ln("Error message:   ",ex)};}} // end of class..`