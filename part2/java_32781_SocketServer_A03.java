import java.io.*;
import java.net.*;
import java.util.*;

public class java_32781_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(1234);

        System.out.println("Server started.");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            // Perform security checks
            if (isValidClient(socket)) {
                // If client is valid, start a new thread for communication
                CommunicationThread thread = new CommunicationThread(socket);
                thread.start();
            } else {
                System.out.println("Invalid client. Connection closed.");
                socket.close();
            }
        }
    }

    private static boolean isValidClient(Socket socket) {
        // TODO: Add actual security checks here, this is a placeholder
        return true;
    }

    private static class CommunicationThread extends Thread {
        private Socket socket;

        public java_32781_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                String request = reader.readLine();
                System.out.println("Received: " + request);

                writer.writeBytes("OK\n");
                writer.flush();

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}