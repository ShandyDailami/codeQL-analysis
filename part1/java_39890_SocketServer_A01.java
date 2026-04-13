import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_39890_SocketServer_A01 {

    private final static int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Create a new thread to handle the client
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_39890_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Here, we assume the client is trying to connect to our server,
            // and we have authenticated them by checking a username and password.
            // This is a very basic and unsafe implementation of access control,
            // in a real-world application you'd likely use a more secure and robust method.
            String username = socket.getRemoteSocketAddress().toString();
            String password = "password";

            if ("username".equals(username) && "password".equals(password)) {
                // If authentication is successful, we can now read and write data
                // Here, we're just printing the received data from the client
                try {
                    while ((socket = new DataInputStream(socket.getInputStream()).readUTF()) != null) {
                        System.out.println("Received: " + socket);

                        // Here we're just echoing back the data to the client
                        new DataOutputStream(socket.getOutputStream()).writeUTF(socket);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                // If authentication fails, we close the socket
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}