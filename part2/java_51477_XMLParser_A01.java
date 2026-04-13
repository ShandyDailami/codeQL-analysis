import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_51477_XMLParser_A01 { 
   public static void main(String args[]) throws ParserConfigurationException, IOException{    
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();   
      
      // Create a new document builder with the generic way to create an empty or read docuemnt type:         
      DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();  
 
      File inputFile= new File("inputfile");     #replace "Your_Directory" and file name below   
      
      //Parse any text resource, not just an embedded one :        
      Document doc =dBuilder.parse(inputFile);         
           
        doc.getDocumentElement().normalize();  
 
           System.out.println("Root Element: " +doc.getElementsByTagName("root"));     #replace root with your tag name    }       catch (Exception e) {         SysOutPrintln(e);}      }}`java' code snippet is as below, replace the 'file_name', and other placeholders accordingly: