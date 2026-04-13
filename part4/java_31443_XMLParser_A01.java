import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_31443_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File("sample.xml"));

            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getElementsByTagName("note").item(0).getTextContent());

            NodeList nodeList = doc.getElementsByTagName("note");

            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Element element = (Element) nodeList.item(temp);

                System.out.println("Recipient: " + element.getElementsByTagName("to").item(0).getTextContent());
                System.out.println("Subject: " + element.getElementsByTagName("subject").item(0).getTextContent());
                System.out.println("Body: " + element.getElementsByTagName("body").item(0).getTextContent());
                System.out.println("======================================================");
            }

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (SAXException se) {
            se.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}