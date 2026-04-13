import org.xml.sax.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_52970_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException{        
        String filename = "inputfile"; // file to parse is 'filename' 
                File inputFile  = new File(filename);     
            SAXParserFactory factory=SAXParserFactory.newInstance();    
             XMLReader reader;   
                 try {                 
                    System.out.println("Parsing the xml document with javax.xml");          //Using JAXP's 1st approach       
                     reader = factory.newSAXParser().getXMLReader( new InputSource(     
                         new FileInputStream (inputFile)) );         else {           return; }                 
                        System.out.println("Emitting Tokens ");             for (;;)   try{reader . 
                    nextEvent(new MyHandler(),null);}catch    ...Exception c){       // Using SAX's parser      catch{}                   case XMLEvent... {           return; }               default: throw new Error ("Unknown XML Event");}}}}}          DefaultHandler..class"   ) ;return;}
                  class …     public void startElement (String arg0, String    Arg1 , String Args2) throws SAXException{       //start of handler      }}        Myhandler.java":68: error: cannot find symbol Symbol 'My' @Overridepublic ....}` missing for `class',
                  java...}}}}}  public void endElement(String arg0, String Arg1 ,    ...exception.. } {     return;   ..Exception{catch (SAXParseException e){System.out .println(" Parse Exception : " +e);            }}               default: throw new Error ("Unknown XML Event");}
                   //....}}}else{}}}finally {}      public void characters(char ch[], int start,int length) { }     ... …    end of code