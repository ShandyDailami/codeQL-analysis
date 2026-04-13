import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_41130_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml");
            FileInputStream fis = new FileInputStream(xmlFile);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(fis);

            // Extract and print out XML tags and values
            String xpathExpression = "/note/to/from";
            NodeList nList = doc.selectNodes(xpathExpression);
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node node = nList.item(temp);
                String to = node.getAttributes().getNamedItem("to").getNodeValue();
                String from = node.getAttributes().getNamedItem("from").getNodeValue();
                String note = node.getChildNodes().item(0).getNodeValue();

                System.out.println("to: " + to);
                System.out.println("from: " + from);
                System.out.println("note: " + note);

                // Add your security-sensitive operations here

            }

            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}