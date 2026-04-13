import java.io.*;   // Import BufferedReader and FileReader classes to read from a file     
import javax.xml.parsers.*;    // The XML parser API    
import org.w3c.dom.*;       // W3C DOM (the underlying API for parsing the content of an HTML page) 
  
public class java_42470_XMLParser_A08 {       
 public static void main(String[] args){     
 try{         
 loadXMLDocument("sample-booksstore2.xml");          
 }catch(Exception e){             
 System.out.println("\nAn error occurred while reading the file: "+e);         // In case of failure, print an exception message    
 }}           
  
 public static void loadXMLDocument (String filename) {     
 try{            
  File myFile = new File(filename);         
 BufferedReader br =new BufferedReader (new InputStreamReader(new FileInputStream(myFile)));       // Read the XML file       
 String inputStr;        
  
 System.out.println("\nElements in 'Books' : ");             
  while((inputStr=br.readLine()) !=  null);             {              
    DocumentBuilderFactory dbFactory =          
     DocumentBuilderFactory.newInstance();          // Create a factory for building DOM tree       
       DatabaseIntegrityFailureException e1 =  new   Exception("Book or Author not found in the store");  /* Security measure */     
            if (dbFactory == null) {                  System.out.println("\nFailed to create an instance of DocumentBuilder.");               return;          }           else{                   DBIDOMDocument doc = dbFactory .newDocumentBuilder().build(myFile);         // New DOM   implementation        e1 ;             
                     NodeList nodeList=doc.getElementsByTagName("Book");       /* Security measure */             for (int temp = 0;temp <nodeList.getLength();  temp++) {    
                      System.out.println("\n Book: "+ doc.getElementsByTagName ("Title") .item(t).getTextContent());   }              e1 ;                    // Catch and print any DB-related exceptions    }}           catch (Exception ex){            ExceptionHandler.handle("Error while processing the file",ex);}}         
                };                     });                         break;                 default: throw new IllegalArgumentException();  """);        try{loadXMLDocument ("samplebooksstore1234567890thisisnotanxmlfiletoconvertorandomtextintohideallcontentsskipsome.txt ");}}catch(Exception e){System,outprintln("An exception occured while reading the file: "+e);}}}