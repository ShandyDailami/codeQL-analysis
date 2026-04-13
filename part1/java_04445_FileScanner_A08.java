import java.io.*;

public class java_04445_FileScanner_A08 {

    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\User\\Desktop\\test.txt"); // Change this to your file path
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
           
                // Syntactic correctness
                // For realism, we'll try to open a file in read-only mode
                FileReader fr = new FileReader(file);

                // We should not be able to open a file in read-only mode
                if(fr.getEncoding().equals("ISO-8859-1")) {
                    System.out.println("Read only mode detected.");
                }
            }

            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}