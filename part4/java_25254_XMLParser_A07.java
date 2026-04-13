import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_25254_XMLParser_A07 {

    public static void main(String[] args) {
        String filePath = "path_to_your_xml_file.xml"; // replace with your actual file path

        parseFile(filePath);
    }

    private static void parseFile(String filePath) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(filePath));

            // normalize the document
            document.getDoctype();
            document.getElementsByTagName("").iterator();

            // get the value of the first element
            NodeList nodeList = document.getElementsByTagName("element_name");

            List<String> elements = nodeList.getValues();

            for (String element : elements) {
                System.out.println("Value of element: " + element);
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}