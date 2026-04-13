import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.InvalidParameterException;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class java_07885_XMLParser_A07 {
    public Document readXMLDocument(String fileName) {
        try {
            FileInputStream input = new FileInputStream(new File(fileName));
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(input);
            doc.getDocumentElement().normalize();
            return doc;
        } catch (Exception e) {
            throw new InvalidParameterException("Error occurred while reading the XML file.", e);
        }
    }

    public void parseXML(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("note");
        Iterator<Element> elementIterator = nodeList.iterator();

        while (elementIterator.hasNext()) {
            Element element = elementIterator.nextElement();
            // TODO: Parse and process XML element here
            // For instance, print note's title and description
            System.out.println("Note: " + element.getAttribute("title"));
            System.out.println("Description: " + element.getAttribute("description"));
        }
    }

    public static void main(String[] args) {
        XMLParser parser = new XMLParser();
        Document doc = parser.readXMLDocument("notes.xml");
        parser.parseXML(doc);
    }
}