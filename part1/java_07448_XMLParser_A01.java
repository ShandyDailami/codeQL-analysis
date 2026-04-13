import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class java_07448_XMLParser_A01 {

    private static void parse(String file) throws ParserConfigurationException, SAXException, IOException {
        // step 1: create the factory and parse the file
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(file));

        // step 2: extract the data from the document
        // we'll assume that the data is in an element named "data"
        NodeList nodes = doc.getElementsByTagName("data");

        // step 3: perform security-sensitive operations
        // let's say we want to read and print every text node in the document
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            System.out.println("Data: " + node.getTextContent());
        }
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // step 1: display the start of the program
        System.out.println("Start of program");

        // step 2: call the parse method with a file name
        parse("brokenAccessControl.xml");

        // step 3: display the end of the program
        System.out.println("End of program");
    }
}