import java.io.*; // for FileInputStream & BufferedReader classes used to read the XML files  
public class java_53399_XMLParser_A07 {   
 public static void main(String[] args) throws Exception{    
      String xmlData = loadXMLFromFile("testfile");  /// replace "testfile" with your file name.        
       //parse and extract data from XML here by calling appropriate methods or using standard library/API like XPath, SAX etc  
 }   
 private static void parseAndExtract(String xmlData) {    
      int lineNumber = 0;  /// count for numbering each error found in the file. (optional).       
       try{         //try block to capture any exceptions or errors during parsing and extraction process           
          XMLParser parser = new MyXMLParser();   /* your implementation of this interface will handle how you want xml data is extracted */   
              boolean success;     /// set true when no error/exception occur in the parse operation.  false otherwise       
               do{         //do while loop to keep parsing until successful or an exception occurs      
                    try {      /*try block for each piece of code inside it (parse, extract) */         
                         success = parser.parse(xmlData);     /// set true when no error/exception occur in the parse operation  false otherwise       
                          if (!success){         //if not successful then print all errors found and break out from loop      
                                for (; ; lineNumber++ ){      /*this code will keep counting until an exception is encountered */  
                                      System.out.println("ERROR: " + parser.getErrorDetail(lineNumber));        }                   return;     //break the loops    }}catch (Exception e) {  /// Catch and print all exceptions here           PrintWriter out = new PrintWriter ("logfile");       /* this file will contain error logs */        
                          if (!success){         
                               System.out.println("ERROR: " + parser.getErrorDetail(lineNumber));        }                   return;     //break the loops    }}catch (Exception e) {  /// Catch and print all exceptions here       PrintWriter out = new PrintWriter ("logfile");         /* this file will contain error logs */
                    lineNumber = 0 ; xmlData= loadXMLFromFile("testfile") } while (!success);      //continue parsing if last attempt failed   }}while (true)     };  /// end of main function    public interface XMLParser{ ...}