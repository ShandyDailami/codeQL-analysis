import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;  // Import IOException Class to handle errors  
public class java_50838_XMLParser_A08 {   
 public static void main(String args[]) throws ParserConfigurationException, IOException{      
      String xmlFile = "/path/to/xmlfile";        XmlDocument document;          try (Stream<?> stream =  Files.newInputStream(Paths.get(xmlFile)))  // Using java streams for reading files     {           DocumentBuilderFactory dbFactory =   DocumentBuilderFactory.newInstance();     
       DBConfiguration config=dbFactory .newDocumentBuilderConfigur    ation("MyPREFerred");        document =  (XmlDocument)config.newDocumentBuilder().build(stream);         printElementList  ("",document );     } catch (Exception e){ System.out.println("/t" +   "An error has occurred: ");     
       //TODO : handle exception properly, for now just printing the caught Exception message           e .printStackTrace();    }}            private static void printElementList(String indentStr  , Node node) {     if (node != null){         System.out.println   (indentStr + "<"+ ((Element ) node).getNodeName()  +">");          for (int i = 0;i <(( Element)"children").getLength();   
       //TODO : handle children properly, in the real world scenario you might want to use a list of elements instead and iterate through it.         printElementList(indentStr + "  ",node." getChildNodes(). item ());     } else {           System .out.println   (" indent str+"  + node);}}