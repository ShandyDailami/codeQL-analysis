import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_08286_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        // Step 1: Create a ServerSocket
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is running on port " + PORT);

        // Step 2: Accept incoming connections
        while (true) {
            Socket socket = server.accept();
            System.out.println("A client has connected");

            // Step 3: Create a new thread for each client
            new ClientHandler(socket).start();
        }
    }

    // Class for handling each client separately
    private static class ClientHandler extends Thread {
        private final Socket socket;

        public java_08286_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            // Step 4: Process the client's request
            try {
                // We'll use a very simple form of encryption for this example
                socket.getInputStream().read(); // skip the initial byte
                byte[] data = new byte[1024];
                socket.getInputStream().read(data);
                String receivedData = new String(data);

                // Step 5: Check the integrity of the data
                // For the purpose of this example, we'll assume that the received data is the same as the sent data
                boolean integrityCheck = receivedData.equals(new String(data));

                // Step 6: Send back a response
                socket.getOutputStream().write(integrityCheck ? 1 : 0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}