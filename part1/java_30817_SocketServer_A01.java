import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_30817_SocketServer_A01 {

    public static void main(String[] args) {
        int port = 6000;
        Socket socket = null;
        BufferedReader reader = null;
        PrintWriter writer = null;

        try {
            // 1. Establish a socket connection
            socket = new Socket("localhost", port);
            System.out.println("Connected to the server at " + socket.getLocalSocketAddress());

            // 2. Read from the socket
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // 3. Write to the socket
            writer = new PrintWriter(socket.getOutputStream(), true);

            // 4. Send a request
            writer.println("Hello, Server!");

            // 5. Read the response
            String response = reader.readLine();
            System.out.println("Server response: " + response);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 6. Close the connections
            try {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}