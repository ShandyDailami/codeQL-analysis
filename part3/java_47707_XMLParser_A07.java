import org.xml.sax.*;   //SAX Parsers interface, uses XML Content Handlers and parses an XML document using predefined schemas to a Document Object Model (DOM) tree or other variant of the graph model with which users can traverse through it in various ways – either by natural traversal itself.
import org.xml.sax.helpers.*; //SAX Parser Helper provides SAX methods for parsing XML documents  

public class java_47707_XMLParser_A07 {    
    public static void main(String[] args) throws Exception{     
        String inputFile="A07_AuthFailureSampleData/inputfile1234.xml"; //Change with your xml file name and location 
        
        SAXParserFactory spf = SAXParserFactory.newInstance();  
         
        try {    
            SAXParser saxParser=spf.newSAXParser(true);//True indicates the parser should call back into us when it encounters an end of document, false otherwise   
             
             MyContentHandler mycontenthandler = new  MyContentHandler();   // Create a Content Handler for parsing XML Document    
                  saxParser.parse(inputFile ,mycontenthandler);//Parse the file and send content handler to parse it using SAX parser       
               } catch (ParsingException e) {   
                   System.out.println("Parsing failed: "+e );   //Catch exception if parsing fails     
                 }; 
            });    
       }}`;