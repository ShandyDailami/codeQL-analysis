import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.security.AccessControlException;
import java.security.AccessControlListener;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_35381_XMLParser_A01 implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String XML_FILE_NAME = "broken_access_control.xml";
    private static final String FILE_NOT_FOUND_MSG = "File not found!";

    private AccessControlListener accessControlListener;

    public java_35381_XMLParser_A01(AccessControlListener accessControlListener) {
        this.accessControlListener = accessControlListener;
    }

    public List<String> parseXMLFile() {
        List<String> nodeList = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(XML_FILE_NAME);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(fis);

            NodeList nodeListXML = doc.getElementsByTagName("node");

            for (int i = 0; i < nodeListXML.getLength(); i++) {
                if (accessControlListener.checkAccess(nodeListXML.item(i))) {
                    nodeList.add(nodeListXML.item(i).getNodeName());
                }
            }

            fis.close();

        } catch (FileNotFoundException e) {
            System.out.println(FILE_NOT_FOUND_MSG);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();

        } catch (SAXException e) {
            e.printStackTrace();
        }

        return nodeList;
    }

    public static void main(String[] args) {
        XMLParser parser = new XMLParser(new AccessControlListener() {
            @Override
            public boolean checkAccess(Serializable arg0) {
                return false; // simulate access control
            }
        });
        List<String> nodeList = parser.parseXMLFile();
        for (String node : nodeList) {
            System.out.println("Node name: " + node);
        }
    }
}