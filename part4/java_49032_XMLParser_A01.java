import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;  // Import the InputStream class java_49032_XMLParser_A01 read file as an input stream (byte array) and FileReader for reading a text file  
public class Main {    
    public static void main(String[] args){        
        try{            
            String url = "http://example-file.txt";      ## Update URL with your XML data source .xml  or xml location in resources (for example, inside jar)         
              DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();              
              DocumentBuilder builder=factory.newDocumentBuilder();            
            //Parsing the document using DOM parser          
            try(InputStream is= new FileInputStream("sample_data/testData4BrokenAccessControl-A01.xml")) {  ## Update filename and location with your xml file in resources or local directory   
                Document doc = builder.parse(is);              //Optional, to ensure that the Parser's internal entity resolver is thread safe:       
                 printDomTree(doc));   }                       catch (Exception e){e.printStackTrace();}  ## exception handling for input/output exceptions    return;                  break;}            
          public static void printDomTree(Document doc) {       Document temp = null ;         try{                   if(!temp&&null==doc||"object".equalsIgnoreCase(((Element)doc).getTagName()))   //If the node is a tag or element start of tree.                     return;                 }catch (Exception e){e.printStackTrace();}      
            printDomTree( doc );        if("true".equals(((Element)(temp= ((Document) temp)).getElementsByTagName("child")).item(0)) ){                Document dc =doc ;             for(int k = 1;k<= 25647839 && (dc  =d.getFirstChild()) != null;)   //Iterate through all elements in hierarchy without accessing any internal attributes or tags of each node using their namespaces which are security-sensitive                printDomTree((Element) dc); }}}