import java.io.*; //For File I/O operations 
import javax.xml.parsers.*;//for parsing XML documents  
    import org.w3c.dom.*;//to manipulate data in the document       
import org.xml.sax.*;//SAX parser for reading an xml file    
public class java_51292_XMLParser_A07 { //creating a new Java Class 
       public static void main(String[] args) throws ParserConfigurationException, SAXException{  
             String filename = "sample_file.txt";    /* your XML File */     
               DocumentBuilderFactory dbFactory = 
                   DocumentBuilderFactory.newInstance();        //create a new document builder factory 
                    
            DocumentBuilder dBuilder = 
                dbFactory.newDocumentBuilder();       //creating a parser for the file  
             
             try(Source source = new StreamSource(filename)) {    /* reading xml from disk */        
                  System.out.println("Successfully parsed XML document.");    
                      Document doc = dBuilder.parse(source); 
                    printElementNamesRecursive(doc, "");   //calling recursion function to start printing element names          }        catch (IOException e){            /* catching any IOException */           System.out.println("Failed...io exception occured.");     return;      }}                  private static void printElementNamesRecursive(Node node, String indent) {    if ("\n".equals("\t")){indent="";}          else               
                    //printing the current element name and its attributes       System.out.println((indent+node.getNodeName()));  for (int i = 0;i <            } node .hasChildNodes())           { printElementNamesRecursive(node, indent + "\t");}}}     catch   
                  //any SAXException      e){System outprint("Parsing canceled...");}}   }}catch exception */  /* end of try block *//* this is the main method where execution starts*/}