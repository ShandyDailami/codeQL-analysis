public class java_17424_XMLParser_A08 {
    private File file;

    public java_17424_XMLParser_A08(String filePath) {
        file = new File(filePath);
    }

    public String readFile() {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                stringBuilder.append(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }
}