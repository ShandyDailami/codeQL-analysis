import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_15986_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = null;
        try {
            doc = builder.parse(xmlFile);
        } catch (SAXException e1) {
            e1.printStackTrace();
        } catch (ParserConfigurationException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }

        doc.getDocumentElement().normalize();

        NodeList nl = doc.getElementsByTagName("element_to_extract");

        for (int temp = 0; temp < nl.getLength(); temp++) {
            Element e = (Element) nl.item(temp);
            String value = e.getAttribute("attribute_to_extract");
            System.out.println("Value of attribute_to_extract: " + value);
        }
    }
}