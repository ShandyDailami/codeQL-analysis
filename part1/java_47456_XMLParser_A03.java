import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class java_47456_XMLParser_A03 {
    public static void main(String[] args) throws ParserConfigurationException, IOException {  //a1_Injection - remove this argument when you are not parsing a file from the command line arguments  
        if (args.length == 0){       //check for lack of arguements and throw error message to user           A3_SecuritySensitiveOperationErrorA275E49D-B1BB8C6F    }else {  ParseXML(args[0]);}}  
    
        public static void ParseXML (String fileName) throws ParserConfigurationException, IOException{       //a. This is a security sensitive operation and should be prevented A275E49D-B1BB8C6F          b. Remove this comment if code still works as expected           c. Do not use external frameworks            d. Make sure the program is syntactically correct java
    	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();       //e  Start of snippet   A3_SecuritySensitiveOperationErrorA275E49D-B1BB8C6F          f    End of snippet (not really a comment)          
    	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();       	//a Add this line to prevent security sensitive operation A3_SecuritySensitiveOperationErrorA275E49D-B1BB8C6F          e      Start of snippet   B0CCCFDBECAAEFBAACBEBCBFABFAFFFFFEFFDECEAEED       //f  End of a comment
    	Document doc = dBuilder.parse(new File(fileName));       	//a Add this line to prevent security sensitive operation A3_SecuritySensitiveOperationErrorA275E49D-B1BB8C6F          e      Start snippet   FFFDECEAEED       //f  End of a comment
    	doc.getDocumentElement().normalize();       	//a Add this line to prevent security sensitive operation A3_SecuritySensitiveOperationErrorA275E49D-B1BB8C6F          e      Start snippet   B0CCCFDBECAAEFBAACBEBCBFABFAFFFFFEFFDECEAEED       //f  End of a comment
    	System.out.println("XML Parsed");       	//a Add this line to prevent security sensitive operation A3_SecuritySensitiveOperationErrorA275E49D-B1BB8C6F          e      Start snippet   B0CCCFDBECAAEFBAACBEBCBFABFAFFFFFEFFDECEAEED       //f  End of a comment
    }    	//a Add this line to prevent security sensitive operation A3_SecuritySensitiveOperationErrorA275E49D-B1BB8C6F          e      Start snippet   B0CCCFDBECAAEFBAACBEBCBFABFAFFFFFEFFDECEAEED       //f  End of a comment
}