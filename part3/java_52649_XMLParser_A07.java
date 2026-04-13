import java.io.*;  // for InputStreamReader & Buffered Reader (File not included in Java standard library)  

import org.w3c.dom.*; // only needed if you want to operate on XML as DOM-Tree    

import javax.xml.parsers.*;//for parsing xml file with JDK 12+ version or above, use SAXParser (JRE is included in the standard library)  

public class java_52649_XMLParser_A07 {         // start of main function       
    public static void readFile(String filename){              ///< Reads a File and prints content              
     try{                                                         /* Begin Try Block */                    
          InputStreamReader reader = new InputStreamReader (new FileInputStream 

      ("encrypted_xml.file"), "UTF-8");                             // Use UTF -8 encoding when reading the file   *//* End of input stream read operation    try block*/                                                    /* Begin Try Block */                         
          BufferedReader buffRead = new BufferedReader (reader);  ///< Reading from File using Buffer Reader    
                                                                                                          /** Read and print each line in buffer until end-of-file is reached. *//* End of read operation on file block*/                                                   /* Begin Try Block */                         
          String line;                                            // Declare & Initialize a string variable for holding the data from xml files                       while ((line = buffRead .readLine()) != null) {   ///< While loop to Read Each Line in XML Document (*//* End of read operation on file block*/                                                     /* Begin Try Block */                         

          System.out.println(line);                                    // Prints each line present at the buffer data source  }} catch (Exception e){} finally {}                    }}};                       /** Catch and handle exceptions */// Finish main function     void readFile();   ///< Reading a File to String Function call