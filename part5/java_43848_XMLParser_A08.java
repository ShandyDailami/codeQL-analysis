import org.w3c.dom.*;
import javax.xml.parsers.*;
public class java_43848_XMLParser_A08 {  
    public static void main(String[] args) throws Exception{     
        try{    
            SAXParserFactory saxpfactory = SAXParserFactory.newInstance();  // Create a factory for the parser        
            SAXParser saxparser=saxpfactory.newSAXParser();              // Get an instance of XMLReader  
            
           /* Incorrect file name */    
          DocumentBuilderFactory dbFactory = 
                  DocumentBuilderFactory.newInstance(); 
                
        //set the directory for xml files to be read:      
                File testFile = new File("invalidXML");     
            System.out.println(testFile);  
             if (!fileExists(testFile)) {    
               throw new Exception ("The file does not exist.");  }    return;        // exit program (end of main method)        
                
           Document doc = dbFactory .newDocumentBuilder().parse("invalidXML");      
            saxparser.setProperty( "http://xml.org/sax/properties/external-parsed-entity", "" );  }    catch (Exception e){      System.out.println ("Caught Exception: " +e);}        return;     }}   //end main method         
 private static boolean fileExists(File f) {         if (f != null && f.exists())           return true; else             throw new IllegalArgumentException("The provided path does not exist.");  }