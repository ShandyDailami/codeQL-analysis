import org.dom4j.*;   // for Document, Element etc..   
import javax.xml.parsers.*;//for parsing XML document...    
import java.io.File;       // File object to hold the files and directories  ...     
public class java_43845_XMLParser_A01 {       
 public static void main(String args[])throws Exception{  
 DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();   
 DocumentBuilder dbbuilder=dbfactory.newDocumentBuilder();     //Create a new document builder...      
  File inputFile =  new File("src/test.xml");      if(inputFile.exists()){       
   System.out.println("\nParsing the XML file: " + "\n");    Document doc = dbbuilder.parse(inputFile);         //Create a parse tree from any xml source...       DOM Document     ...  content is read-only and not editable by user..            Element root=doc.getDocumentElement();          System.out.println("Root element: "+root.getName());       
   }else{             
    throw new Exception ("The input file doesn't exist");      // check if the xml document exists or no...             return;       case Sorry :            break;}                   catch(Exception e){e.printStackTrace();}         }}