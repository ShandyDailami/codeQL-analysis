import java.net.*;
import java.io.*;

public class java_08323_SocketServer_A01 {

    private static boolean accessGranted = false;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {

        try {
            serverSocket = new ServerSocket(12345);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");
                new ClientHandler(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ClientHandler extends Thread {
        private Socket clientSocket;

        public java_08323_SocketServer_A01(Socket socket) {
            clientSocket = socket;
            start();
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    if (message.equals("access")) {
                        accessGranted = true;
                        out.writeBytes("Access granted\n");
                    } else {
                        out.writeBytes("Access denied\n");
                    }
                }

                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}