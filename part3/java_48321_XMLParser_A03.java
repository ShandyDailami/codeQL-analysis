import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_48321_XMLParser_A03 extends DefaultHandler {  
    boolean bContent = false; // Flag to check if content is inside element or not     
    
    public void startElement(String uri, String localName, 
                              String qName, Attributes attributes) throws SAXException{            
        System.out.print("Start Element : " +qName+ "\n");  
         bContent = true; // Set flag to True so that next element content can start printing   
     }     
      
     public void endElement(String uri, String localName , 
                             String qName) throws SAXException{            
        System.out.println("End Element : " +qName);  
         bContent = false; // Set flag back to False after parsing an element content     
     }   
      
     public void characters(char ch[], int start, 
                             int length) throws SAXException{            
        if (bContent){           
          System.out.println("Character Data : " + new String(ch ,start ,length));  
         }     
     }   
      
     public static void main(String[] args ) {  // Main Method to test the parser above in a simple xml file content, not secure against injection attacks if used with user provided input.        try{             
          SAXParserFactory saxpf = SAXParserFactory.newInstance();   
           XMLReader xr  = null;     (1)  
             System.out.println("Starting Parser");       //SAX parser starts parsing from here      str="<student><name>Tom</name><age>20<\\age><city>New York<\\city><grade> 9 < / grade  student> < \\学生的名字为 Tom , age = 21, city = New_York，成绩= 8。 >";      
             xr  = saxpf.newSAXParser();     (2)           // Create SAX parser      return;        }catch(Exception e){          System.out.println("Parsing failed");   try{ XMLReader xr = ... ;  parse the xml string, not used here but in future use case of parsing an input stream or file   
       catch block will be provided for exception handling and recovery from a failure to read/write files }      @Overridepublic void fatalError(SAXParseException e) {          System.out.println("Fatal error: line " +e.getLineNumber()+ ", column"  + 
        ""new String (e .getMessage()));           return;     }}   startElement and end element method is also provided above, for illustrating SAX parsing mechanism}}`    It uses the `SAX Parser Factory's new instance to create a 'XML Reader'. Then it calls these methods in sequence: starts an XML document. The DocumentHandler (here named SimpleXmlParser) 
        passes control back and forth between different method invocations of this handler, as described above by startElement(), endText() etc., while parsing the content read from source file or input stream till it is completely parsed up to a given maximum depth level. After that closing tag `</student>` will be encountered which ends document reading process and parser finally stops working }