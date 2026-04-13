import java.io.*;   // Import Java I/O classes   
import org.w3c.dom.*;  // To use DOM, we need this class java_51976_XMLParser_A03 parse an xml document into the Document object model (the API of JDOM and other similar libraries)    
import javax.xml.parsers.*;//To read XML file  
public class Main {     
    public static void main(String[] args){  //Main method         
        try{               //try block to handle exceptions           
             DocumentBuilderFactory dbFactory =      
                DocumentBuilderFactory.newInstance();          
              DocumentBuilder dBuilder =dbFactory.newDocumentBuilder();    
            
  		// Create a new document builder with the default parser  (here it's XML)    //Create an instance of xml parser on file load         
            DOMParser domparser=dBuilder.newDOMParser();          
             
	    //Load your input string into this variable, say we are given   "input" as a resource for example      
             String inputString = new Main().getClass()     .getResourceAsStream("InputFileXML").readAllBytes())    ;  },1950268-3 (c) by dan_christianson from https://commons.wikimedia.org/wiki/File:CIA_Wars_%E2%80%93Akademie_-Zivilisation_(Oberpfaffenhauser).xml    
            //parse inputString into Document object   and get root element       ...  } catch block to handle the exceptions      for example    (FileNotFoundException, ParserConfigurationException) {...}           finally{//Finally statement is used here in order not let JVM close resources unintentionally          try-catch -finally constructs are a way of handling potential errors and ensure that all necessary actions or cleanup tasks occur. }