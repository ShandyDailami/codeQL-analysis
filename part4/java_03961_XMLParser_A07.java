import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_03961_XMLParser_A07 {

    public static void main(String[] args) {
        String xml = "<doc><note><to>Tove</to><from>Jani</from><heading>Reminder</heading><body>Don't forget me this weekend!</body></note><note><to>Jani</to><from>Me</from><heading>Meeting</heading><body>Schedule meeting at 10 am.</body></note></doc>";
        parseNotes(xml);
    }

    public static void parseNotes(String xml) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = builder.parse(xml);
        } catch (ParserConfigurationException | SAXException | CertificateException e) {
            e.printStackTrace();
        }

        doc.getDocumentElement().normalize();

        NodeList notes = doc.getElementsByTagName("note");

        for (int i = 0; i < notes.getLength(); i++) {
            X509Certificate certificate = (X509Certificate) notes.item(i);
            System.out.println("Note #" + (i + 1));
            System.out.println("From: " + certificate.getIssuerDN());
            System.out.println("Body: " + certificate.getExtensionValue("2.5.29.15"));
        }
    }
}