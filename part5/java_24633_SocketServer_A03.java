import java.io.*;
import java.net.*;

public class java_24633_SocketServer_A03 {
    private static final int PORT = 9876;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            // Create input and output streams for communication
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Get the request from the client
            String request = in.readUTF();
            System.out.println("Received: " + request);

            // Add a random delay for security purpose
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Send the response back to the client
            out.writeUTF("Thank you for connecting to the server");
            out.flush();

            socket.close();
        }
    }
}