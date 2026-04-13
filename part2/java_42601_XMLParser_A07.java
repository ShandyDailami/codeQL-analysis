import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
   public class java_42601_XMLParser_A07 {    
      static void parse(String filename) throws ParserConfigurationException, IOException{   
         // Step a: Load the xml document via Java API  - Start of code snippet            
          DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();             
          DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();               
          
          File inputFile = new File(filename);                         
         // Step b: Read the xml file content, parse and extract data - Start of code snippet   
          Document doc =dBuilder.parse(inputFile);                     
        }  // Ends here            
      public static void main (String[] args) throws Exception {  
            ParserConfigurationException e1;      
           IOException e2 ;        
     };                            try{              for(int i = 0;i<args.length;+++){                parse((new String[]{"inputfilelocation\\A07_AuthFailure-v3495a6dcebe8fedc1bdbadecbddee2ccbcfafeffebbbgjpwkacqnrzl.xml",args[i]}));}catch(Exception e){System . out ."Error" +E;}}
}; // Ends here   };//End main method    } ; end of the program            `