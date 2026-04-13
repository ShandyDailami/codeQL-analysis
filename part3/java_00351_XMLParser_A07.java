import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class java_00351_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("Security");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                if (nList.item(temp).getNodeType() == NodeList.ELEMENT_NODE) {
                    List<String> authFailures = new ArrayList<>();
                    NodeList authNodeList = nList.item(temp).getElementsByTagName("AuthFailure");
                    for (int i = 0; i < authNodeList.getLength(); i++) {
                        if (authNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                            authFailures.add(authNodeList.item(i).getTextContent());
                        }
                    }
                    if (authFailures.isEmpty()) {
                        throw new SecurityException("No authentication failures detected.");
                    } else if (authFailures.size() > 10) {
                        throw new AuthFailureException("Multiple authentication failures detected. Please check the logs.");
                    } else {
                        System.out.println("Authentication failures detected: " + authFailures);
                    }
                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}