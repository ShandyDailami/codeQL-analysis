import java.io.*;

public class java_20575_FileScanner_A01 {

    public static void main(String[] args) {
        File file = new File("/path/to/your/file");

        // Try to read the file
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                // Attempt to access the file
                FileWriter fw = new FileWriter(file, true); // append mode
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(line);
                bw.newLine();
                bw.close();
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading or writing file: " + e.getMessage());
        }
    }
}