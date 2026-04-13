import java.security.Guard;
import java.security.Permission;
import java.security.SecurityManager;

public class java_39364_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            SecurityManager securityManager = new SecurityManager() {
                @Override
                public void checkPermission(Permission perm) {
                    // Do nothing. This method is not invoked by the SecurityManager.
                }

                @Override
                public void checkActions(String actions) {
                    // Do nothing. This method is not invoked by the SecurityManager.
                }
            };
            System.setSecurityManager(securityManager);

            XMLParser parser = new XMLParser();
            parser.parse("src/test.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class XMLParser {
    public void parse(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(fileName);
        document.getDocumentElement().normalize();

        NodeList nodeList = document.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            System.out.println("Node " + (i + 1) + ": " + node.getNodeName());

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Attribute 'id': " + element.getAttribute("id"));
                System.out.println("Attribute 'class': " + element.getAttribute("class"));
            }
        }
    }
}