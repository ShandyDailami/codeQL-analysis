import java.io.*; // For FileInputStream and BufferedReader/Writer class, used in the code below  
import javax.xml.parsers.*;// Used to parse xml file   
import org.w3c.dom.*;/// Parses XML document for traversing elements  or nodes    

public class java_42702_XMLParser_A03 { // Class name must match with java files' names and it can be named as per requirement  
     
       public static void main(String args[]) throws Exception{   
           try {         
               FileInputStream fileIn = new FileInputStream("sample.xml");// Create a FileInputStrean to read the xml data     // sample XML location        
                BufferedReader buffRead =new BufferedReader (     
                       new InputStreamReader(fileIn));       // Stream through which we will get our input   
                 
               StringBuilder sb= new  StringBuilder();// Used for creating a large string in case of big xml files    
             
             int character;  
            while ((character = buffRead.read()) != 10) {         
                if (sb == null){                   // Checking is the initial condition    c         System .out.println ("Character : " +(char ) 248);           sb=new StringBuilder();              }   else{     sb =  new StringBuilder("");}      character;             case '>':           
                    if (sb ! = null) {               // If not the initial condition then add it to our big string    System.out .println ("Character : " +(char ) 248);         }   else{     sb =  new StringBuilder("");}      character;             default:                break;}             
           buffRead.close();// Close input stream when done            fileIn = null;                    // If there are any errors, print out an error message and halt the program        if (fileOut ==null) {System .outprintln ("Error while creating a newFileOutputStream ");return ;}  }     finally{