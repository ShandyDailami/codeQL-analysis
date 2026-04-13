public class java_13453_XMLParser_A01 {
    public void parse(String fileName) {
        try {
            // Step 1: Read the XML file
            File file = new File(fileName);
            FileReader reader = new FileReader(file);
            int c;

            // Step 2: Parse XML file
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
            reader.close();

            System.out.println("Parsing completed successfully!");
        } catch (Exception e) {
            System.out.println("An error occurred while parsing the file: " + e.getMessage());
       
        }
    }
}