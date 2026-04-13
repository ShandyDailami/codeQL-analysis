import java.io.*;
import java.net.*;

public class java_22059_SocketServer_A07 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            // Step 1: Create Server Socket
            server = new ServerSocket(PORT);
            System.out.println("Server started at port: " + PORT);

            while (true) {
                // Step 2: Accept Client Connection
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

                // Step 3: Create Input and Output Streams
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                // Step 4: Perform Authentication
                String clientData = reader.readLine();
                if (clientData.equals("A07_AuthFailure")) {
                    writer.writeBytes("Authentication Failed\n");
                    writer.flush();
                    continue;
                }

                // Step 5: Process the Client Data
                writer.writeBytes("Hello, Client\n");
                writer.flush();

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close Server Socket
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}