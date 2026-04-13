import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class java_40697_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            DOMParser parser = new DOMParser();
            Document doc = parser.parse("sample.xml");
            NodeList nodes = doc.getElementsByTagName("tagName");

            for (int i = 0; i < nodes.getLength(); i++) {
                System.out.println("Node " + (i + 1) + ": " + nodes.item(i).getTextContent());
            }

            parser.getFeature("http://apache.org/xml/features/nonvalidating/load-dtd"));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}