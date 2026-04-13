import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.AccessControlException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_28855_XMLParser_A01 {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false); // Disable validation for testing
        DocumentBuilder builder = factory.newDocumentBuilder();

        try (FileInputStream fis = new FileInputStream("sample.xml")) {
            Document doc = builder.parse(fis);

            // If you've got a file and want to load it, you can use this line:
            // Document doc = builder.parse(new InputSource(new StringReader(xml)));

            System.out.println("XML Parsing Successful");
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please check the file path.");
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            System.out.println("Failed to parse configuration.");
            e.printStackTrace();
        } catch (SAXException e) {
            System.out.println("Error parsing the XML file.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error reading the file.");
            e.printStackTrace();
        }
    }
}