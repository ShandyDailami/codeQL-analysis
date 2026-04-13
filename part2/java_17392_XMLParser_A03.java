import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_17392_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document;

        try {
            document = builder.parse(xmlFile);

            // Here you would typically call a method to process the document
            processDocument(document);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void processDocument(Document document) {
        // Implement your document processing here
    }
}