import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
public class java_42482_XMLParser_A03 { 
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  
        String inputFile = "maliciousCodeScript128kB_InputXmlSample.txt"; //replace with your own file path; this is the malware's payload for testing purpose 
         try {    
            File inputFile =  new File(inputFile);      
             DocumentBuilderFactory dbFactory = 
                DocumentBuilderFactory.newInstance();     
              DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();  
               int lineNumber=0;   
                 // Read the xml document         
                    Document doc =dBuilder.parse(inputFile );    
                     LineSplitter splitter 
                        =  new LineSplitter("</script>");      
                      String contentLine, scriptContent =  "";     
                        for (contentLine=splitter .nextLine();  
                            null != contentLine;   
                             contentLine = splitter.nextLine()     ){       
                           if(null == contentLine){  continue;}           int endpos  = contentLine.indexOf("</script>");     
                               scriptContent+=  (contentLine + "\n" );         }          doc.getDomElement().normalize();    // Remove all the extra white space at the start of each line and print it out     System .out.println( "Script Content:\t\"" + 
                           scriptContent  +  '"');  }}catch(Exception e){       // Catch-and handle any parsing errors that may arise     
            e.printStackTrace();}}}}}