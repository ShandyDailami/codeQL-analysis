import java.util.List;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_40865_XMLParser_A03 {
    private String xmlString;

    public java_40865_XMLParser_A03(String xmlString) {
        this.xmlString = xmlString;
    }

    public List<String> parseXML() {
        List<String> result = new ArrayList<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            org.xml.sax.InputSource is = new org.xml.sax.InputSource(new StringReader(this.xmlString));
            Document doc = builder.parse(is);
            doc.getDocumentElement().normalize();
            NodeList nl = doc.getElementsByTagName("*");
            for (int temp = 0; temp < nl.getLength(); temp++) {
                Node node = nl.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String str = element.getTagName();
                    result.add(str);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}