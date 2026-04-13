import java.io.FileInputStream;
import java.io.InputStream;
import java.security.AccessControlException;
import java.security.AccessDeniedException;
import java.security.PrivilegedAction;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_32615_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            System.out.println(parseXML("secure.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String parseXML(final String xmlFile) {
        String result = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputStream is = new FileInputStream(xmlFile);
            Document doc = builder.parse(is);
            result = "XML Parsed Successfully!";
        } catch (ParserConfigurationException | SAXException | AccessControlException | AccessDeniedException e) {
            result = "Error parsing XML. Make sure XML file is secure and XML is well-formed.";
        } catch (Exception e) {
            result = "Error occurred while parsing XML.";
        }
        return result;
    }

}