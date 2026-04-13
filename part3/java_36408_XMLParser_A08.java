import java.awt.print.PrintJob;
import java.io.File;
import java.security.Permission;
import java.security.SecurityManager;
import java.security.PrivilegedAction;

public class java_36408_XMLParser_A08 {
    public static void main(String[] args) {
        // Create a SecurityManager that limits access to the XMLParser
        SecurityManager sm = new SecurityManager() {
            public void checkPermission(Permission perm) {
                // Check if the permission is one that requires an action
                if (perm.getName().startsWith("action.")) {
                    throw new SecurityException("Permission denied");
                }
            }

            public void checkAccess(String antler) throws SecurityException {
                // Check if the antler is one of our denied actions
                if ("read".equals(antler)) {
                    throw new SecurityException("Access denied");
                }
            }
        };

        // Set the SecurityManager for the current thread
        Thread.currentThread().setSecurityManager(sm);

        try {
            // Parse the XML file
            parseXML("example.xml");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void parseXML(String fileName) {
        // Use the DOM parser to parse the XML file
        javax.xml.parsers.DocumentBuilderFactory dbFactory =
            javax.xml.parsers.DocumentBuilderFactory.newInstance();
        javax.xml.parsers.DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        org.w3c.dom.Document doc = dBuilder.parse(new File(fileName));

        // Print out the content of the XML
        doc.getDocumentElement().normalize();
        System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());
        printElement(doc.getDocumentElement());
    }

    private static void printElement(org.w3c.dom.Node node) {
        // Print out the content of the current node
        System.out.print("Node Name: " + node.getNodeName());
        System.out.print(", Node Value: " + node.getTextContent());
        System.out.println();

        // Print out the content of the child nodes
        for (int i = 0; i < node.getChildNodes().getLength(); i++) {
            printElement(node.getChildNodes().item(i));
        }
    }
}