import java.io.FileInputStream;
import java.io.InputStream;
import java.security.AccessControlException;
import java.security.AccessDeniedException;
import java.security.CodeSigner;
import java.security.cert.Certificate;
import java.util.Iterator;

import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_07836_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Load XML document
            InputStream inputStream = new FileInputStream("input.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputStream);

            // Access Control - Check if document is signed
            try {
                Certificate[] certificates = doc.getSignatures();
                if (certificates.length > 0) {
                    throw new AccessDeniedException("Document is signed");
                }
            } catch (AccessControlException | CertificateException e) {
                e.printStackTrace();
            }

            // Access Control - Check if document is not signed
            try {
                CodeSigner codeSigner = doc.getCodeSigner();
                if (codeSigner != null) {
                    throw new AccessDeniedException("Document is not signed");
                }
            } catch (CodeSignerException e) {
                e.printStackTrace();
            }

            // Print XML namespaces
            NamespaceContext namespaceContext = doc.getNamespaceURI();
            if (namespaceContext != null) {
                Iterator<String> iterator = namespaceContext.getDeclaredNamespaces().iterator();
                while (iterator.hasNext()) {
                    String namespace = iterator.next();
                    System.out.println("Namespace: " + namespace);
                }
            }

            // Print XML document
            doc.getDocumentElement().normalize();
            System.out.println(doc.getDocumentElement().getNodeName());

            // XMLStream operations
            XMLStreamReader streamReader = doc.createXMLStreamReader();
            int event = streamReader.getEventType();
            while (event != XMLStreamConstants.NULL) {
                switch (event) {
                    case XMLStreamConstants.START_DOCUMENT:
                        System.out.println("Start Document");
                        break;
                    case XMLStreamConstants.START_ELEMENT:
                        System.out.println("Start Element: " + streamReader.getLocalName());
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        System.out.println("End Element: " + streamReader.getLocalName());
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        System.out.print(streamReader.getText());
                        break;
                }
                event = streamReader.nextEvent();
            }

            inputStream.close();

        } catch (ParserConfigurationException | SAXException | XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}