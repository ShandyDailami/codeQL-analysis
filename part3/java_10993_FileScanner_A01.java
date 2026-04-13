import java.io.*;

public class java_10993_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File(".");
        try {
            FileReader reader = new FileReader(file);
            FileWriter writer = new FileWriter(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line.toUpperCase());
                bufferedWriter.newLine();
            }
            bufferedReader.close();
            bufferedWriter.close();

            System.out.println("All files have been successfully read and written to.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}