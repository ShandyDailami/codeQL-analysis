import javax.xml.parsers.*; // Importing necessary classes from Java XML parser package 
public class java_43406_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    
        String url = "path_to/yourXmlFile";// your xml file path goes here. Replace with real location if needed      
         XMLReader reader;  // creating a new instance of the Reader class     
          try {  
             System.out.println("Parsing Completed Successfully");    
           } catch (SAXException e) {   
              e.printStackTrace();//handling any exception if error occurs during parsing and printing stack trace        //  print the parsed data     
            reader = XMLReaderFactory.createXMLReader( );  
          writerHandler=new WriterHandler("D:/outputFile", "UTF-8");      
         }    
    /* Calling parse method of parser to read xml file */           catch (Exception e) {        //handling any exception if error occurs during parsing and printing stack trace      print the parsed data  }}   catches Block Ends Here.