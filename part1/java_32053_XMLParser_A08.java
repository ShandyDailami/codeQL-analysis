import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;

import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_32053_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            secureParseXML("example.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void secureParseXML(String fileName) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(ClassLoader.getSystemResourceAsStream(fileName));
        document.getDocumentElement().normalize();

        NamespaceContext namespaceContext = document.getNamespaceContext();
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        String expression = "/bookstore/book[year<1990]";

        XPathExpression expr = xpath.compile(expression);
        Iterator iterator = expr.iterate(document);

        while (iterator.hasNext()) {
            XPathExpression expr2 = xpath.compile("/bookstore/author");
            for (iterator = expr2.iterate(document); iterator.hasNext();) {
                X509Certificate certificate = (X509Certificate) iterator.nextNode();
                // here you can add the code to check if the certificate is trusted
            }
        }
    }
}