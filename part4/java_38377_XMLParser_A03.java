import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_38377_XMLParser_A03 {

    public static void main(String[] args) throws Exception {
        // Create a DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // Create a DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Create a new file
        File file = new File("target.xml");

        // Create a new FileInputStream
        FileInputStream fis = new FileInputStream(file);

        // Parse the file
        Document doc = builder.parse(fis);

        // Print out the XML content
        System.out.println(doc.getDocumentElement().getNodeName());

        // Close the file input stream
        fis.close();
    }
}