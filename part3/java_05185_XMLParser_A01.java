import java.util.*;

public class java_05185_XMLParser_A01 {
    private static String xmlString;
    private static DocumentBuilderFactory dbFactory;
    private static DocumentBuilder builder;

    public static void main(String[] args) {
        // Step 1: Initialize XML Parser
        xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<root>" +
                "<element1>Some text1</element1>" +
                "<element2>Some text2</element2>" +
                "</root>";

        // Step 2: Create a new instance of DocumentBuilderFactory
        dbFactory = DocumentBuilderFactory.newInstance();

        // Step 3: Use DocumentBuilderFactory to create DocumentBuilder
        builder = dbFactory.newDocumentBuilder();

        // Step 4: Parse the XML string into Document
        parseXML(xmlString);
    }

    private static void parseXML(String xmlString) {
        try {
            // Step 5: Parse XML String into Document
            Document document = builder.parse(new InputSource(new StringReader(xmlString)));

            // Step 6: Print out the parsed XML content
            printXMLDocument(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printXMLDocument(Document document) {
        // Step 7: Print out the document title
        System.out.println("Document Title: " + document.getDocumentElement().getNodeName());

        // Step 8: Print out XML file properties
        System.out.println("Document Node: " + document.getDocumentElement().getNodeName());

        // Step 9: Get all element names
        NodeList nList = document.getElementsByTagName("*");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            System.out.println("Element : " + nList.item(temp).getNodeName());
        }
    }
}