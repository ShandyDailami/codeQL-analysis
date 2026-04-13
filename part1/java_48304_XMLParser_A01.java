import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_48304_XMLParser_A01 {   
     public static void main(String[] args) throws ParserConfigurationException, IOException{     
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();  
         DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder(); 
         
         // parse the document using DOM parser (read it from file or input stream )   
         Document doc =  dBuilder .parse( new File("inputFilePath") );    
               
         System.out.println("\nElement details: ");  
           
         printElementDetails(doc); 
         
        //prints out attributes of the element for security sensitive operations like Broken Access Control   
       /* doc.getElementsByTagName("tagname").item(0).getAttributes().length; */    
           System.out.println("\nEnd");     
   }        
  private static void printElementDetails (Document document){       
          // Traverse through all the elements in XML file and prints them details   
       NodeList nodeList = document.getElementsByTagName("*");               
              for(int temp = 0;temp<nodeList.getLength();temp++) {     
                 if (document.getElementsByTagName("tagname").item(temp).hasAttributes())         
                  printElementDetails((Element) nodeList.item(temp));    // recursion        ...for attribute printing     }   else             System.out.println("\nStart tag : "+nodeList.item(0).getNodeName() );       return; }}  catch (ParserConfigurationException e){        
          e.printStackTrace();      };                    try{                   new FileInputStream("inputFilePath");                  //do not print anything for security sensitive operations like Broken Access Control    }catch (IOException ex) {                 ExitProgram(ex);};     protected static void  PrintElementDetails(){}};}}}