import java.io.*; // Import the Java built-in classes for input/output handling, such as FileInputStream or BufferedReader  
import javax.xml.parsers.*; // Access to XML parsing capabilities in a variety of formats (SAX etc.)    
   
public class java_52054_XMLParser_A01 { 
      public static void main(String args[]) throws Exception{       
          try {              
              FileInputStream fstream = new FileInputStream("sample.xml");   // Creating an input stream to read data from a file          
                  BufferedReader buffread=new BufferedReader (new InputStreamReader  (fstream));     
                   String strLine;     // Store the value of each line in string       
                      while ((strLine = buffread.readLine()) != null) {   
                          System.out.println(strLine);       }          
              fstream.close();          };   }, 1,0){}                 catch (Exception e) { // Catch block to handle the exceptions        try{// Your code here            FileInputStream fis = new FileInputStream("sample.xml");    BufferedReader br=new BufferedReader(new InputStreamReader(fis));     
              String strLine;     int lineNumber = 0 ;  while((strLine =br .readLine()) != null){   if (lineNumber %2 == 1) System.out.println("Broken Access Control Violation: " + strLine);          } br.close();    };
              }}             catch(Exception ex){System.out.println ("Error in parsing the XML file");  // Handle exceptions     ];}}            if (args.length != 1) { System . out . println("Usage : JavaSecureXMLParser  <xmlFilePath> ");   exit(-1); }};