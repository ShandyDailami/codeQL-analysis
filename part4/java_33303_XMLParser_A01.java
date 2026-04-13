import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_33303_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // create a factory for building a document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // create a builder for the document
            DocumentBuilder builder = factory.newDocumentBuilder();

            // create a document
            Document doc = builder.parse(new File("example.xml"));

            // print the document
            System.out.println(doc.getDocumentElement().getNodeName());

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}