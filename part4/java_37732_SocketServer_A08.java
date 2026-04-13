import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramSocket;
import java.net.Socket;

public class java_37732_SocketServer_A08 {

    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        try {
            // Create a datagram socket and listen on the server port
            DatagramSocket serverSocket = new DatagramSocket(SERVER_PORT);
            System.out.println("Server is listening on port " + SERVER_PORT);

            while (true) {
                // Wait for a client to connect
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

                // Create input and output streams
                DataInputStream input = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

                // Check for integrity failures
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String message = reader.readLine();
                if (!checkIntegrity(input, message)) {
                    System.out.println("Integrity failure detected. Connection closed.");
                    clientSocket.close();
                    continue;
                }

                // Send a message to all clients
                output.writeUTF(message);

                // Close the connection
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean checkIntegrity(DataInputStream input, String message) {
        try {
            // Check the integrity of the message from the client
            String receivedMessage = input.readUTF();
            if (!receivedMessage.equals(message)) {
                System.out.println("Integrity failure detected. Message received is not as expected.");
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}