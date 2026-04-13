import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;   // Import InputStreamReader and FileWriter classes 
    
public class java_43207_XMLParser_A08 {   
       public static void main(String[] args) throws ParserConfigurationException, IOException{       
             XMLReader reader = null;     
              try {                
                    String xmlFilePath= "sample.xml"; //your file path here                  
                     Reader fileReader =  new FileReader(new java.io.File(xmlFilePath));  
                      Document document  =reader.getDocument();   
                       NodeList nodes =document .getElementsByTagName("node");                 
                        for (int i=0;i<nodes.getLength();i++){                           
                              System.out.println("\nNode["+(i+1)+"]: "); 
                               Node node  =   nodes.item(i);    
                                String text = null ;    //create a variable for the data of each tag      
                                 if (node instanceof Element ){                 
                                      text=((Element)node).getElementsByTagName("tag").item(0).getTextContent();                          }                           else  {                       System.out.println("\nThis is "+ node +"'s child nodes");                   };                    }}catch (Exception e){System.err.println ("Failed to parse the document: "+ 
                        e);}                  reader .close();       //closing XMLReader                }}};