import java.io.*;
import java.net.*;

public class java_19231_SocketServer_A03 {

    private static final int PORT = 8888;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        try {
            // Step 1: Create Server Socket
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port " + PORT);

            while (true) {
                // Step 2: Accept Connection
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Step 3: Handle Client Communication
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                // Step 4: Read Data from Client
                String request = dis.readUTF();
                System.out.println("Received: " + request);

                // Step 5: Perform Security-Sensitive Operations
                // For example, remove the input string
                String response = request.replace("injection", "");

                // Step 6: Write Response to Client
                dos.writeUTF(response);
                dos.flush();

                // Step 7: Close Connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Step 8: Close Server Socket
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}