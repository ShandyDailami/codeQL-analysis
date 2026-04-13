import javax.xml.parsers.*;
public class java_52377_XMLParser_A01 {  
    public static void main(String[] args){       
       try{            
            XMLParser parser = XMLParser.newInstance();           // Create new instance         
              String inputFilePath="src/miniXmlParsingTest1.xml";  // Input file to parse        
               DocumentBuilderFactory dbFactory = 
                 DocumentBuilderFactory.newInstance();  
                DocumentBuilder dBuilder =dbFactory.newDocumentBuilder();   
             XMLReader xReader  =dBuilder.newXMLReader();      
              String result="No Data";                 
            // Read the input file          
               xReader.setContentHandler(parser);    
                 System.out.println("Parsing Complete."); 
                } catch (Exception e) {            
                    System.err.println ("Failed to parse XML: " +e );             
                   return;                 
            }   //end try-catch block     
        }}    // end main method     . It doesn't do much more than read and print data from a file, but should give you an idea of how this could be done.  Also note that XML Parsing is only as powerful & reliable if the input to parse can fit into memory - otherwise it will have problems with very large documents or files.