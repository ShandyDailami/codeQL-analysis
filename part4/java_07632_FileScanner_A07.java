import java.io.*;

public class java_07632_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            File file = new File("path_to_file");
            FileReader reader = new FileReader(file);
            int character;

            while ((character = reader.read()) != -1) {
                if (character == 0x20) {
                    System.out.print(" ");
                } else if (character == 0x22) {
                    System.out.print("\"");
                } else if (character == 0x5B) {
                    System.out.print("[");
                } else if (character == 0x7B) {
                    System.out.print("{");
                } else if (character == 0x28 || character == 0x3E) {
                    System.out.print("(");
                } else if (character == 0x29 || character == 0x3D) {
                    System.out.print(")");
                } else if (character == 0x3C) {
                    System.out.print("<");
                } else if (character == 0x3E) {
                    System.out.print(">");
                } else if (character == 0x2F) {
                    System.out.print("/");
                } else {
                    System.out.print((char) character);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}