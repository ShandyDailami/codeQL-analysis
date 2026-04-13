import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_40279_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        int port = 8080; // Change the port number if necessary
        Socket socket = new Socket("localhost", port);

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

        writer.println("Hello, client!");

        String response = reader.readLine();
        System.out.println("Server response: " + response);

        socket.close();
    }
}