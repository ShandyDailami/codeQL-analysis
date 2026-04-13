public class java_23633_XMLParser_A01 {

    public void parseXML(String fileName) {
        try {
            // Step 1: Load the XML file
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File(fileName));

            // Step 2: Extract the data from the XML file
            doc.getDocumentElement().normalize();

            System.out.println("Root Element: " + doc.getElementsByTagName("").item(0).getNodeName());

            // Print out all the data
            NodeList nList = doc.getElementsByTagName("*");

            for (int temp = 0; temp != nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nNode Type: " + nNode.getNodeName());
                System.out.println("Node Value: " + nNode.getTextContent());
            }

            // Step 3: Perform security-sensitive operations
            // In this case, we are just printing the file name
            System.out.println("\nSecurity-Sensitive Operation: Printing file name");
            System.out.println("File name: " + fileName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        XMLParser parser = new XMLParser();
        parser.parseXML("yourfile.xml");
    }
}