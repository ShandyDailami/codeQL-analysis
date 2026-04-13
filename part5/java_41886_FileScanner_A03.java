import java.io.*;

public class java_41886_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        String dirPath = "src/main/resources"; // Adjust this to your directory
        String searchTerm = "A03_Injection";

        File dir = new File(dirPath);
        File[] files = dir.listFiles((d, name) -> name.endsWith(".txt"));

        for (File file : files) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(searchTerm)) {
                    System.out.println("Found injection in file: " + file.getPath());
                }
            }
            reader.close();
        }
    }
}