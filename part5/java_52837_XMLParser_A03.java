import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
public class java_52837_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{ 
        String url = "sampleXML"; //This is a security sensitive operation as it contains user input which we're not controlling for this example to keep simple. You should replace 'userInput()', with your actual logic here that takes care of the injection vulnerability in real-world applications where A03_Injection can be exploited
        parse(url);  //parse method is responsible towards parsing and display data from xml file   
   }    
       private static void userInput(){ System.out.println("User Input detected, this should not happen!");}//Avoiding User input to make the code as minimalist possible in real world application where A03_Injection is being exploited 
        public static Document parse(String url) throws ParserConfigurationException, SAXException {   //parse method responsible for parsing and display data from xml file   
            userInput();//To avoid the vulnerability we are just printing a message in this step. In real world applications you should replace 'userInput()' with your actual logic that takes care of A03_Injection 
           DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();   //get document builder factory   
           DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();     //set document building true      
               Document doc =dBuilder.parse(url);//parsing the xml file       
              printElementData (doc,"");  //calling a function to display data in tree structure  
             return null;    }     
          static void printElementData(Node node, String padding){    
            if (!node.hasChildNodes() && !((1))) {       System.out.println("element: "+ ((Element) (node)).getTagName()); //print the tag name of element        return;   }      for (@SuppressWarnings ("rawtypes") Iterator iter = node .childNodes () ;iter..hasNext();){    
            Node child_node=(Node ) iter.next();    printElementData (child_node,padding + "--");  //calling the function recursively to display data in tree structure        }   }}//closes Main Class