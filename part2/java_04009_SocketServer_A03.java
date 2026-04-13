import java.io.*;
import java.net.*;

public class java_04009_SocketServer_A03 {
    public static void main(String[] args) {
        int port = 8080;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                new HandleSocket(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class HandleSocket extends Thread {
        private Socket socket;
        HandleSocket(Socket socket) {
            this.socket = socket;
            start();
        }

        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(inputStream);
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                String request = dataInputStream.readUTF();
                // No hardcoding of user-provided data, to prevent injection attacks
                // We are only validating whether the input is an integer
                if (request.matches("\\d+")) {
                    // If the input is a valid integer, we can proceed with the operation
                    dataOutputStream.writeUTF("Successfully processed request: " + request);
                } else {
                    // If the input is not a valid integer, we return an error message
                    dataOutputStream.writeUTF("Invalid request: " + request);
                }
                dataOutputStream.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}