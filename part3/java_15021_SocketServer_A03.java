import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15021_SocketServer_A03 {

    private static final int PORT = 4445;

    public static void main(String[] args) throws IOException {
        // create server socket and bind it to port
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port: " + PORT);

        // wait for client to connect
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            // create new thread for each client connection
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_15021_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // read from the socket to check for a potential command for an injection
            try {
                byte[] bytes = new byte[1024];
                socket.getInputStream().read(bytes);
                String command = new String(bytes);
                if (command.contains("command1") || command.contains("command2")) {
                    System.out.println("Attempting to execute command with potential injection: " + command);
                    // execute command with potential injection
                    // here, we're just checking if the command contains certain keywords and responding with a generic message
                    if (command.contains("injection")) {
                        System.out.println("Security alert: command contains a potential injection attempt.");
                    } else {
                        System.out.println("Successfully executed command: " + command);
                    }
                } else {
                    System.out.println("Successfully connected: " + socket.getRemoteSocketAddress());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}