public class java_13609_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            XMLParser parser = new XMLParser("src/main/resources/input.xml");

            while (parser.hasNext()) {
                Element element = parser.getNextElement();
                System.out.println("Element name: " + element.getName());
                System.out.println("Element value: " + element.getValue());
            }

            parser.close();
        } catch (Exception e) {
            System.out.println("Error parsing XML: " + e.getMessage());
        }
    }
}

class XMLParser {
    private Document document;
    private int currentElement;

    public java_13609_XMLParser_A01(String filePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(new File(filePath));
            document.getDocumentElement().normalize();
        } catch (Exception e) {
            throw new ParsingException("Error loading XML file: " + e.getMessage());
        }
    }

    public Element getNextElement() {
        if (currentElement >= document.getElements().getLength()) {
            throw new ParsingException("Unexpected end of XML document");
        }

        return document.getElements().item(currentElement++);
    }

    public boolean hasNext() {
        return currentElement < document.getElements().getLength();
    }

    public void close() {
        // Cleanup code here
    }
}

class ParsingException extends RuntimeException {
    public java_13609_XMLParser_A01(String message) {
        super(message);
    }
}