import java.net.URL;
import java.net.MalformedURLException;
import java.util.List;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_25502_XMLParser_A03 {
    public List<String> parseXML(String filePath) {
        List<String> resultList = new ArrayList<>();
        try {
            URL url = new URL(filePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(url.openStream());
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("country");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                Element element = (Element) node;
                String countryName = element.getElementsByTagName("name").item(0).getTextContent();
                resultList.add(countryName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public static void main(String[] args) {
        MyXMLParser parser = new MyXMLParser();
        List<String> countryNames = parser.parseXML("http://example.com/countries.xml");
        for (String name : countryNames) {
            System.out.println(name);
        }
    }
}