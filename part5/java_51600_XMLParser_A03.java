import org.xml.sax.*; //SAX Parser library from XML standard W3C
import java.io.*;    //IO related classes (InputStream, OutputStream) to read/write files  
public class java_51600_XMLParser_A03 {
     public static void main(String[] args){ 
          String xmlFile = "path_to_yourfile";//Replace this with your XML file path here                 
           parseXmlDocument(xmlFile);              //Parse the document                    
      }              
       private static void parseXmlDocument (final String xmlFile) {    //Method to read and process an Xml Document    
             SAXParserFactory spf = SAXParserFactory.newInstance();  //Create a new instance of sax parser factory  
            try{                    
                SAXParser saxParser=spf.newSAXParser(true);//Creates the actual parsers with true option for error reporting          
               InputSource is = null;   
              if (xmlFile !=null) {  //Checking whether file exists or not       
                  System.out.println("Start Parsing XML File "+ xmlFile +"...");  
                   is =  new InputSource(new FileInputStream(xmlFile));//Read the input source from a specified character-input stream       }      else {              //if no specific file provided, use default location     System.out.println("Start Parsing Default XML Location (in this project)...");         
                  is = new InputSource();}    return;}catch(Exception e){   systemOutPrintlnErrMsg ("Error in SAXParser : " +e );return;  }      //Main Method starts here        public static void mainMethod(){     String methodName =  Thread.currentThread().getStackTrace()[2].toString ().substring("class .+.".length());System.out.println(method Name);}}