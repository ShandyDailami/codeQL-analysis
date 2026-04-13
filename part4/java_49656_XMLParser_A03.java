import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class java_49656_XMLParser_A03 { 
    public static void main(String[] args) throws ParserConfigurationException, IOException{  
        String fileName = "/path/to/yourfile"; //Replace this with your actual XML filename        
       try (FileInputStream fis = new FileInputStream(new File(fileName))) {         
           DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();            
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();               
             
               int maxIterations = 5; //Max number of iterations for parsing and security operations 
                   String harmfulContentRegexPattern= ".*(<script>|</script>|eval\\((.*?)\\)|[`~^@$#%+=-]{1,}|0x[a-fA-F0-9]{4}-[a-fA-F0-9]{4}).*"; //Replace this with your actual harmful content regex pattern
                   StringBuilder sb = new StringBuilder();          
               for (int i = 0; i < maxIterations ;i++){             
                  Document doc = dBuilder.parse(new InputSource(fis));               
                       NodeList listNode = doc.getElementsByTagName("*");            
                      if(!listNode.item(0).getTextContent().matches(harmfulContentRegexPattern)){                        break; }  //Breaks the loop on successful parsing without any harmful content             
                          sb.append("\n" + listNode.item(i));                      
               }         
                   System.out.println("Parsed and cleaned XML file: \n\n "+sb);          
        }            catch (SAXException e) {  // Catch exceptions for handling SAX content             printStackTrace();              ConsoleIO console = new JavaConsole(new PrintStream[]{consoleWriter,null}, false,"",false );     };                });   }}`;    */ `^'`` in the comments to display it properly.