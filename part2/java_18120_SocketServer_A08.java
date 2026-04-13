import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_18120_SocketServer_A08 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started on port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Create new threads for each client
                new Handler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Error occurred while starting the server: " + e.getMessage());
        }
    }

    static class Handler extends Thread {
        Socket socket;
        DataInputStream input;
        DataOutputStream output;

        Handler(Socket socket) {
            this.socket = socket;
            try {
                input = new DataInputStream(socket.getInputStream());
                output = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                System.out.println("Error occurred while creating the streams: " + e.getMessage());
                close(socket);
            }
        }

        public void run() {
            try {
                // Receive and send message from client
                while (true) {
                    String message = input.readUTF();
                    if (message.equals("exit")) {
                        break;
                    }
                    output.writeUTF("Message received: " + message);
                }
            } catch (IOException e) {
                System.out.println("Error occurred while handling the client: " + e.getMessage());
            } finally {
                close(socket);
            }
        }

        void close(Socket socket) {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Error occurred while closing the connection: " + e.getMessage());
            }
        }
    }
}