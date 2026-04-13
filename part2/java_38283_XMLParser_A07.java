import org.apache.xml.parser.DOM.DOMParser;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class java_38283_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("src/main/resources/sample.xml");

            DOMParser domParser = new DOMParser();
            domParser.setValidating(false);
            domParser.setDoNamespaces(false);
            domParser.setNamespaceAware(false);
            domParser.parse(document);

            if (domParser.getErrorCount() == 0) {
                System.out.println("XML is well-formed");
            } else {
                System.out.println("XML is not well-formed");
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}