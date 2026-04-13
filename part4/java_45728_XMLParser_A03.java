import java.io.*; // For InputStreamReader and FileInputStream classes needed for reading xml files from disk  
import org.w3c.dom.*;// Required when working on XML Document Object Model (DOM) 1-st level API's to read, manipulate or create documents with a particular style of markup as well using HTML tags in the way and XHTML/XML namespaces for more comprehensive access control mechanisms
import javax.xml.parsers.*;// Required when working on XML parsing from an InputSource (stream), file source(FileInputStream) 1-st level API's to parse xml files into Document objects, SAX or DOM parser APIs needed if you want a lightweight approach for read operation
  
public class java_45728_XMLParser_A03 {    //Class name must be same as Java File Name without extension. In this case it is 'SecureXmlParseExample'. 
     public static void main(String args[]) throws ParserConfigurationException, IOException{     
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();   //Create a document builder factory   
         
         try (InputStream inputStream =  new FileInputStream("inputFile")) {       //Open the xml file for reading    
             DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();      //Obtains an instance of DOM parser 1-st level API's to parse XML document from source or URL  2nd Level APIs provided by SAX and others are not used in this example   
             
         } catch (ParserConfigurationException e) {       //Catching exception if any     System.out .println("Invalid configuration for XmlReader");  Exception handling     
             e.printStackTrace();                 
        return;  
          }catch(IOException ex){                    Console Output when file not found           PrintWriter r = new PrintWriter (System.out);         //Exception Handling     System out printing exception, to the console    x=exmlp("File Not Found",r );  Finally block for closing resources after execution of try/catch blocks
              e1.printStackTrace();   }            return;      }}