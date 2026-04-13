import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_28461_SocketServer_A01 {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 1234)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println("Hello, Client!");

            String response = in.readLine();
            System.out.println("Server says: " + response);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}