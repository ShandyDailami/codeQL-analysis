public class java_34076_XMLParser_A08 {

    public static void main(String[] args) {
        String xml = "<person><name>John</name><age>30</age></person>";
        parseXML(xml);
    }

    public static void parseXML(String xml) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xml)));

            document.getDocumentElement().normalize();
            System.out.println("Root element: " + document.getDocumentElement().getNodeName());

            NodeList nodes = document.getElementsByTagName("name");
            for (int i = 0; i < nodes.getLength(); i++) {
                System.out.println("Name: " + nodes.item(i).getTextContent());
            }

            nodes = document.getElementsByTagName("age");
            for (int i = 0; i < nodes.getLength(); i++) {
                System.out.println("Age: " + nodes.item(i).getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}