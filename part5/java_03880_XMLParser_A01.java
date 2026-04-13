import java.security.*;
import java.util.*;
import java.io.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import javax.xml.transform.*;

public class java_03880_XMLParser_A01 {
    private static final String XPATH_EXPRESSION = "/bookstore/book[price>50]";
    private static final String FILE_NAME = "bookstore.xml";

    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager() {
            @Override
            public boolean getPermission(Permission perm) {
                // disallow all permissions
                return false;
            }

            @Override
            public boolean getMethodsAction(Method m, Object obj) {
                // disallow all methods
                return false;
            }

            @Override
            public boolean getClassActions(Class<?> cl, ProtectionDomain pd) {
                // disallow all classes
                return false;
            }
        };
        System.setSecurityManager(securityManager);

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            XPathExpression expr = XPathFactory.newInstance().newXPath().compile(XPATH_EXPRESSION);

            reader.setContentHandler(new ContentHandler() {
                public void startDocument() {}
                public void endDocument() {}
                public void startElement(String uri, String localname, String qname) {}
                public void endElement(String uri, String localname, String qname) {}
                public void characters(char[] ch, int start, int length) {
                    String content = new String(ch, start, length);
                    XPathNil xpathnil = (XPathNil) expr.evaluate(content, XPathResult.FIRST_ORDERED_NODE_TYPE);
                    if(xpathnil.getNodeType() == XPathResult.FIRST_ORDERED_NODE_TYPE) {
                        System.out.println("Found price: " + content);
                    }
                }
            });

            Reader file = new FileReader(FILE_NAME);
            reader.parse(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}