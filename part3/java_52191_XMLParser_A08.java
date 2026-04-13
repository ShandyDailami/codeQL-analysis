import java.io.*; //for InputStream, OutputStream and Reader classes  
import javax.xml.parsers.*;//For XML parsing   
import org.w3c.dom.*;/* For DOM (Document) & XPath */ 
import org.xml.sax.*; /* SAX Parser for reading the document in a simple way*/    

public class java_52191_XMLParser_A08 {   //Main Class starts from here     
// Declare Input and Output Stream to read/write data on file system   
static FileInputStream inputStream = null; 
static FileOutputStream outputStream=null ;      
         
 static void createXMLFile(){        
 try{          
     /*create an instance of the class   XMLWriter */            
      XMLWriter xmlw = new XMLWriter();                 
              System.out.println("Writing Data in to file : ");       
                      //Write data into a File named as 01_IntegrityFailure .xml         
       for(int i=2 ;i<5;i++){          
                   xmlw.startDocument((Integer)i);           
              }        
     System.out.println("Completed");                      //Ending the document            
               outputStream = new FileOutputStream("/Users/path_to_yourfile/_IntegrityFailure .xml",true ); 
       try{                xmlw.flush();                     /*Flush data into a file*/                   }catch (Exception e){}            finally {outputStream.close();}}             System.out.println("Done");     }} catch(Exception ex)   {} // end of main method               public static void readXMLFile(){              try{          
       inputStream= new FileInputStream("/Users/path_to_yourfile/_IntegrityFailure .xml" );            DocumentBuilderFactory dbFactory =  DocumentBuilderFactory.newInstance();     
        try { 
             DOMParser parser = (DOMParser)dbFactory.newDocumentBuilder();   //Create a new document builder              String input=null;     InputStreamReader reader  = null ;       int i,n= 0);            while((i =inputStream .read()) !-1){           n++;} println("Read: " + (int)+" chars"); }catch(Exception e ){}    finally {if(!outputStream.closed() && inputStream!=null)}}} catch{e} // end of main method