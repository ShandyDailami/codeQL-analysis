public class java_32450_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Load XML file
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse("sample.xml");

            // Print out document elements
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            // Iterate over children
            NodeList nList = doc.getElementsByTagName("item");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("Child node: " + nNode.getNodeName());
            }

            // Security sensitive operations related to A08_IntegrityFailure
            // ...

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}