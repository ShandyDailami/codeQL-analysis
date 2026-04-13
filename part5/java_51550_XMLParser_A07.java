import java.io.*;    // Import FileInput/Output streams, etc.,  
import javax.xml.*;// For parsing XML file - Java Standard Edition API in TC3-Corporate libraries section (https://docs.oracle.com/javase/tutorial/extra/library/) 

public class java_51550_XMLParser_A07 {    // Main method is declared at the top of your code  
        public static void main(String args[]) throws Exception{    
            try      // Declare a new instance for parsing      
                FileInputStream fis = null;                  //FileInput/Output streams, etc.,  and XMLDecoder    are here. These need to be imported from java .io package   (http://docs.oracle.com/javase/6/docs/api/java/io/package-summary.html)
            {        FileNameOrURL providedUrl="inputFile";      // Create a new instance of the object,  and its not instantiable in this case     because it is declared as static inside Main class   (http://stackoverflow.com/questions/6023519/)      
                fis =new FileInputStream(providedUrl);    System.out .print("File opened "+fis );        // Open the file for input streams  and decode it to an object      PrintWriter   (http://docs.oracle.com/javase/6/docs/api/java/io/PrintWriter.html)
            }       catch(Exception e){System . out . println ("Error while reading " +e);}     // Catch the exception and display it  to user in console        System..println (“The file you are trying too open is not there” );    return;   });                    /* End of Main method */
            try {                   FileWriter fw= new FileWriter("outputFile.txt");                     XMLUnmarshaller um = XmlBeanFactory.newInstance(fis);                // Creating a file writer and parsing the xml to object  (http://docs.oracle.com/javase/6/docs/api/java/io/PrintWriter.html)
            } catch (Exception e){ System . out . println ("Error while writing " +e );}       return;   });      // Catch exception and display it in console  PrintStackTraceElement[]    /* End of Main method */};}}        };// This is where the code ends, don't change