import java.io.*;
import java.util.*;

public class java_02782_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\test.txt");
        FileWriter writer = new FileWriter(file, true);

        System.out.println("Please enter the command to exploit the security vulnerability: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = reader.readLine();

        writer.write(command);
        writer.write("\n");
        writer.flush();
   
        writer.close();
    }
}