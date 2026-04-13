import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.Iterator;

public class java_08174_XMLParser_A03 {
    public void parseXML(String fileName) {
        try {
            File inputFile = new File(fileName);
            InputStream is = new FileInputStream(inputFile);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(br);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("item");

            System.out.println("--- Item Information ---");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    String itemName = eElement.getAttribute("name");
                    String itemValue = eElement.getAttribute("value");

                    System.out.println("Item Name : " + itemName);
                    System.out.println("Item Value : " + itemValue);
                }
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}