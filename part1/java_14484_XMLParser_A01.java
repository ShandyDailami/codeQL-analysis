import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.AccessControl;
import java.security.AccessControlContext;
import java.security.AccessDeniedException;
import java.security.GuardedBy;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import sun.security.util.AccessControlHelper;

public class java_14484_XMLParser_A01 {

    private final AccessControl context;

    public java_14484_XMLParser_A01(AccessControl context) {
        this.context = context;
    }

    public List<String> parse(String fileName) {
        final List<String> elements = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(fileName));
            document.getDocumentElement().normalize();

            NodeList list = document.getElementsByTagName("element");

            context.doPrivileged(new PrivilegedAction<Void>() {
                @GuardedBy("elements")
                public Void run() throws AccessDeniedException {
                    for (int i = 0; i < list.getLength(); i++) {
                        Element e = (Element) list.item(i);
                        String value = e.getAttribute("attribute");
                        elements.add(value);
                    }
                    return null;
                }
            });
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AccessDeniedException e) {
            System.out.println("Access Denied: " + e.getMessage());
        }

        return elements;
    }
}