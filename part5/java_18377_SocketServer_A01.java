import java.io.*;
import java.net.*;

public class java_18377_SocketServer_A01 {

    private static final int PORT = 1234;
    private static final String CLIENT_IDENTIFIER = "Client";

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client " + socket.getRemoteSocketAddress() + " connected.");

                // Verify the client's identity by comparing the identifier
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String clientIdentifier = in.readUTF();

                if (CLIENT_IDENTIFIER.equals(clientIdentifier)) {
                    out.writeUTF("Connection successful.");
                } else {
                    out.writeUTF("Connection failed. Identifier mismatch.");
                    socket.close();
                    continue;
                }

                // If the client's identity is verified, proceed with the communication
                handleCommunication(in, out, socket);
                socket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void handleCommunication(DataInputStream in, DataOutputStream out, Socket socket) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

        String message;
        while ((message = reader.readLine()) != null) {
            System.out.println("Received: " + message);
            writer.writeUTF("Message received: " + message);
        }
    }
}