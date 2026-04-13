import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_20180_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            String xmlFile = "sample.xml";
            File file = new File(xmlFile);
            InputStream inputStream = new FileInputStream(file);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputStream);
            doc.getDocumentElement().normalize();

            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

            NodeList nodeList = doc.getElementsByTagName("tag");

            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                System.out.println("  - Node Location " + temp + " : " + nodeList.item(temp).getTextContent());
            }

            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}