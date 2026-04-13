import java.io.*;
import java.net.*;

public class java_27081_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Server is running on port 4444...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Create a new thread for each client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }

    static class ClientHandler implements Runnable {

        private Socket socket;

        public java_27081_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(inputStream);
                String message = dataInputStream.readUTF();
                System.out.println("Received message: " + message);

                // Here you could potentially have security issues related to A01_BrokenAccessControl. 
                // For example, you could send back a message with a modified content:
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                outputStream.writeUTF("Modified message: " + message);
                outputStream.flush();

                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}