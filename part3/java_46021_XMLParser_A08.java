import org.xml.sax.*;
import javax.xml.parsers.*;
import java.io.*;   // Import FileInput and FileOutput steps, for example purposes only — you will need to import specific classes as needed by your program   
public class java_46021_XMLParser_A08{    
 public static void main(String[] args) {     
try {            
        SAXParserFactory spf = SAXParserFactory.newInstance();          // Create a new factory instance          
         System.out.println("SAX Parser: "+spf);             
  SAXParser saxParser=   spf.newSAXParser(false,null );             //Create an XML Reader with no error handling and default settings      
        MyHandler myhandler = new MyHandler();                     
         File inputFile =  null;                         
          try {     if (args[0]=="") throw  IllegalArgumentException("Please specify the file name argument");      else   for(String fn: args)    InputStream in=null ;             // Create an instance of a class that implements this interface. This will be passed as parameter to create() method
                      inputFile = new File (fn);                  if (!inputFile .exists()) throw IllegalArgumentException("The file " + inputFile+" does not exist");              else  saxParser.setDocument(new SAXSource((InputStream)in,null));      // set document for parsing          } catch ((Exception e){
                      System.out.println ("Caught exception: ",e);   return;     }}catch (SAXParseException spxe ) {            try{saxParser .parse("The input file has a syntax error",spxe );}  // If there is any parsing issue, print the detailed message      } catch(FileNotFoundException fnfe){System.out.println ("Caught exception: ",fnfe); return;}}          finally {if (in !=null) try{ in .close();}catch(IOException ioe ) {}  }}
public class MyHandler extends DefaultHandler   // Create a new handler instance           public void startElement    (String uri, String localname , string qName, Attributes attributes){            System.out.println ("Start Element: " +localname);         }       Public void endDocument() {             print("End of Document");     }}