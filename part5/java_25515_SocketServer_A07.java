import java.io.*;
import java.net.*;
import java.util.*;

public class java_25515_SocketServer_A07 {
    private static List<Socket> clientSockets = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server is running...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            clientSockets.add(clientSocket);

            System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

            new HandleClient(clientSocket).start();
        }
    }

    static class HandleClient extends Thread {
        Socket clientSocket;

        HandleClient(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Simulate auth failure
                    if (message.equals("authFail")) {
                        out.println("Auth failure");
                    } else {
                        out.println("Auth successful");
                    }
                }

                clientSocket.close();
                clientSockets.remove(clientSocket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}