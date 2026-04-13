import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;

public class java_28975_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            SAXReader reader = new SAXReader();
            Document document = reader.read("input.xml"); // input.xml is the file to be parsed
            Element root = document.getRootElement();

            XmlFilters filters = new XmlFilters();

            // Add conditions to the filters
            filters.add("//item[price > $50]"); // Filter items with price more than 50
            filters.add("//item[1]"); // Filter items with id 1

            // Apply filters to the document
            document.selectNodes(filters.getFilter());

            // Print the filtered XML
            System.out.println(document.asXML());

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}