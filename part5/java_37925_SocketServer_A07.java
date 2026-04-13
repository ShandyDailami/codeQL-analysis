import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_37925_SocketServer_A07 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        // Step 1: Create a ServerSocket
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            // Step 2: Accept a connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Step 3: Handle the connection
            // For simplicity, we'll just echo the incoming messages back to the client
            new EchoHandler(socket).start();
        }
    }

    private static class EchoHandler extends Thread {
        private final Socket socket;

        public java_37925_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Step 4: Read from the socket
                // This is a blocking call, it will wait until it receives a message
                byte[] buffer = new byte[1024];
                int bytesRead = socket.getInputStream().read(buffer);
                if (bytesRead < 0) {
                    System.out.println("Client disconnected");
                    socket.close();
                    return;
                }

                byte[] response = new byte[bytesRead];
                System.arraycopy(buffer, 0, response, 0, bytesRead);

                // Step 5: Write to the socket
                // This is a blocking call, it will wait until it sends a message
                socket.getOutputStream().write(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}