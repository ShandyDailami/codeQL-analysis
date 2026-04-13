import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_09876_XMLParser_A08 {

    public List<String> parseXmlFromUrl(String urlString) {
        List<String> nodes = new ArrayList<>();

        try {
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            InputStream inStream = conn.getInputStream();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inStream);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("*");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                nodes.add(nNode.getTextContent());
            }
            inStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nodes;
    }

    public List<String> parseXmlFromFile(String filePath) {
        List<String> nodes = new ArrayList<>();

        try {
            File file = new File(filePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("*");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                nodes.add(nNode.getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nodes;
    }
}