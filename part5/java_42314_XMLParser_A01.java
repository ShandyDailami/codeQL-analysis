import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_42314_XMLParser_A01 {   
     public static void main(String[] args) throws ParserConfigurationException{  
        String inputFile = "sample-file"; // provide your xml file name here, e.g., sample.txt 
         boolean validXML = true;         
          
         SAXParserFactory factory = SAXParserFactory.newInstance();      
         try {     
             SAXParser saxParser =  factory.newSAXParser( new InputSource(  
                  new FileInputStream ( inputFile )   
            ));        //Create a XMLReader    
             
               SaxHandler handler= new SaxHandler() ;  /// create the Handler to parse data in xml file        
             saxParser.parse(new InputSource(new StringReader((inputData))),handler)   );      }       catch (FileNotFoundException e){        validXML = false; printErrorMsg("The input File was not found",e);    };     // end of try-catch block  and handle the exception if xml file is invalid.
         System.out.println(validXML ? "Parsed Successfully" : "Failed to parse");   }       private static void printErrorMsg (String error, Exception e){        ErrorHandler handler = new Handler() {    @Override public void warning ( SAXParseException warn ){ super().warning (warn);}           
         // Override fatalError ,endlessLoop and much more methods as per requirement.  }};      };}};// end of class