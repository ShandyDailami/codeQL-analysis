import java.io.*;
import java.net.*;
import java.util.*;

public class java_07910_SocketServer_A01 {
    private static int port = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is listening on port " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // create new input stream for this connection
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readLine();
            System.out.println("Received message from client: " + message);

            out.writeUTF("Thank you for connecting to the server.");
            out.flush();

            socket.close();
        }
    }
}