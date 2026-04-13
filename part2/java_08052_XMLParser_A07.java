import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XPPI;
import org.xml.sax.SAXParseException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class java_08052_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("input.xml");
        XMLParser parser = new XPPI();

        // We're using a custom handler that doesn't care about the XML.
        // We'll just collect the nodes that have "authFailure" in their text.
        AuthFailureHandler handler = new AuthFailureHandler();
        parser.setContentHandler(handler);

        try {
            parser.parse(xmlFile);

            // Print out all nodes that contain "authFailure"
            for (Node node : handler.getNodes()) {
                System.out.println(node.getNodeName() + ": " + node.getTextContent());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXParseException e) {
            e.printStackTrace();
        }
    }

    // A custom handler that doesn't care about the XML.
    // Instead, it collects all nodes that have "authFailure" in their text.
    static class AuthFailureHandler extends DefaultHandler {
        private List<Node> nodesWithAuthFailure = new ArrayList<>();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("authFailure")) {
                nodesWithAuthFailure.add(new Node(localName, null));
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String text = new String(ch, start, length);
            if (!text.trim().isEmpty()) {
                for (Node node : nodesWithAuthFailure) {
                    node.setTextContent(node.getTextContent() + text);
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // nothing to do here
        }

        List<Node> getNodes() {
            return nodesWithAuthFailure;
        }
    }

    // A simple data structure to hold a node's name and text content.
    static class Node {
        private String name;
        private StringBuilder textContent = new StringBuilder();

        Node(String name, String textContent) {
            this.name = name;
            this.textContent.append(textContent);
        }

        String getNodeName() {
            return name;
        }

        String getTextContent() {
            return textContent.toString();
        }

        void setTextContent(String textContent) {
            this.textContent.replace(0, this.textContent.length(), textContent);
        }
    }
}