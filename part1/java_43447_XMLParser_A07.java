import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_43447_XMLParser_A07 {  
    public static void main(String[] args) throws ParserConfigurationException{      //step1: declaration of the variable and setting up parser configuration    
        String file = "sampleXMLFile";  //replace with actual filename or directory name      
           DocumentBuilderFactory dbFactory = 
                DocumentBuilderFactory.newInstance();  
         
         try {    // step2 : trying to parse XML using built-in DOM (Document) model of parser    
              DocumentBuilder dBuilder =dbFactory.newDocumentBuilder(); 
               DocType docType= new DocType("sample", "");      //step3: declaring and setting up DOCTYPE for the document  
                dBuilder.setDoNamespaces(true);    //setting to allow namespace declarations    
           Document doc =dBuilder.parse(new File(file));  //parsing XML file      
               doc.getDoctype();//step4: retrieving and printing DOCTYPE of the document  
              System.out.println("XML Parsed successfully");    } catch (IOException e) {        //catch IOExceptions     
                  e.printStackTrace();     }}  finally{        
           try {            DocumentSaver saver = 
                dBuilder.newDocumentSaver();   setDefaultHandler(null);       System.out.println("XML Saved successfully"); } catch (Exception ex) {}    //step5: closing down the parser and setting default handler      }}