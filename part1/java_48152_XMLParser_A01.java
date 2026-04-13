import javax.xml.parsers.*;  // importing only required package parser class java_48152_XMLParser_A01 org.xml.sax.*;      // SAX parsing library    
import java.io.*;           // for exception handling in reading xml file   
// Custom classes are not used, but included here just to keep the program clean and tidy!
public abstract class XmlParser { 
   public static void parse(String filename) throws ParserConfigurationException, SAXException{    
      try{           // start a transaction for XML document       
         File inputFile = new File(filename);    // construct file object to get data from given xml           
          if (!inputFile.exists()) {                   System.out.println("Unable to find the specified resource: " + filename );  return; }               
           SAXParserFactory saxParserFactory=SAXParserFactory.newInstance();     // create new instance of parser   
           SAXParser saxParser =saxParserFactory.newSAXParser(null);       // parse xml file using this factory         
       
         Handler myHandler =  new MyHandlerImpl ( );      // creating handler and passing it to our parsing method    
            saxParser .parse(inputFile,myHandler) ;  }    catch (Exception e){           System.out.println("Error in processing XML file");   return;                 },0);        }}             };