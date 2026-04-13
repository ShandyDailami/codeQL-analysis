import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_50309_XMLParser_A03 {  
    public static void main(String[] args) throws Exception{    
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();      
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();     
        
        // Parse the XML file          
        Document doc =dBuilder.parse( new File("samplefile.xml") ); 
         
        getElementsByTagName(doc,"<a03_Injection/>");    }  
     public static void getElementsByTagName (Node node, String tag){     
         NodeList nlist =node.getChildNodes();       for(int i=0;i <=nlist.getLength()-1;i++) {          
             Node n=nlist.item(i);              if(n instanceof Element)    try{     // Security-sensitive operation (A03_Injection injection).         
                System.out.println("Found a security sensitive element: "+((Element)(n)).getNodeName());            }       catch(Exception ex){System.out.printlne("Error in parsing");}           }}  };   });    `}}