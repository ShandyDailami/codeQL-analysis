import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_52948_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{      
        //Load the xml file 
          DocumentBuilderFactory dbFactory = 
           DocumentBuilderFactory.newInstance();    
         Reader reader = null;     
             try{           
                 String path="src/main/resources/sample_file";             
                   File inputFile  = new File(path);    //read the xml file  
                  System.out.println("Parsing XML file");      
                    DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();    
                     reader = new FileReader(inputFile );     
            }catch (IOException e){       
                e.printStackTrace();             
             }    //end of try... catch  block          
         Parser parser  =dBuilder .parse(reader);  
          System.out.println("XML file parsed");    
       readDataFromFile(parser,"A01_BrokenAccessControl", reader );     
        cleanup();             }    //end of main method             
  static void writeToScreen (String data ) {         printWriter .write((data)); }}   ;;println("Writing Data to File");}})}}},     try{fileOut =new PrintWriter( new BufferedWriter(      new OutputStreamWriter               ((FileOutputStream) file))) }catch           
           (IOException e){e.printStackTrace();}}}  System . out。 println                    ("ParsingXML…."); readDataFrom File    () { }}             ;}};''')     };}' '} '';'   ''};});`}}, '''');', '', ',','.'//, ,':';,' // ::,, (, (