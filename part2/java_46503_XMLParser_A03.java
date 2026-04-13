import java.security.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_46503_XMLParser_A03 {  
    public static void main(String args[]) throws Exception{    
        String xmlFile = "sample_file";  // specify your file here (remember to replace 'sample_file' with the real path of a .xml or xsd XML resource.)        
      try{            
          File inputFile=new File(xmlFile);      
            DocumentBuilderFactory dbFactory = 
                DocumentBuilderFactory.newInstance();  
              DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();   
           Documents rootElement;    
                  //parse the xml file       
                   rootElement  =dBuilder.parse(inputFile);     
             System.out.println("XML File Successfully Parsed");       }  catch (ParserConfigurationException pce) {  
                 printStackTrace(pce, "ERROR: Problem parsing XML document.");    }}     //end of main method         static void PrintStackTace..print Stack Traces and Exceptions in Java.      public static void printsstacktrace...in java        private …PrintStream out = new ConsoleOutputStream();  
public printstream{out=console}static final class console extends print Stream {private queue<byte[]> bytesqueues;queue <character []>  charactersQueues ;int availab1e = 0,tablishes= 8};prints stream(string s){bytesQueue.add (...) } 
//implement your own version of add method here...     public static void main..}