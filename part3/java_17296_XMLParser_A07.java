import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;

import javax.xml.crypto.Data;

public class java_17296_XMLParser_A07 {

    public static void main(String[] args) {
        // Create a new XML document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();

        // Add some data to the document
        Element rootElement = doc.createElement("root");
        doc.getDocumentElement().appendChild(rootElement);

        Element childElement = doc.createElement("child");
        rootElement.appendChild(childElement);

        // Write the document to a file
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("output.xml"));
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Read the file back into a document
        Document readDoc = builder.parse(new File("output.xml"));
        Element readElement = readDoc.getDocumentElement();
        System.out.println("Read element: " + readElement.getTagName());
    }
}