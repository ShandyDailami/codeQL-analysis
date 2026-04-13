import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XmlUnmarshallerFactory;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.util.List;
import org.xml.sax.SAXException;
import javax.xml.parsers.SAXParser;
import org.xml.sax.XMLReader;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.xml.sax.helpers.DefaultHandler;
import org.w3c.dom.Element;
import java.io.FileWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class java_11508_XMLParser_A01 {

    public void parseXML(String fileName) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(fileName));

            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("note");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);

                String title = element.getAttribute("id");
                String content = element.getTextContent();

                System.out.println("Title: " + title);
                System.out.println("Content: " + content);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("new_" + fileName));

            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}