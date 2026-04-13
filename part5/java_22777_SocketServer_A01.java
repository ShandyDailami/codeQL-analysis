import java.io.*;
import java.net.*;
import java.util.*;

public class java_22777_SocketServer_A01 {
    private static List<Socket> clients = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Server started.");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            clients.add(socket);

            Handler handler = new Handler(socket);
            Thread thread = new Thread(handler);
            thread.start();
        }
    }

    static class Handler implements Runnable {
        private Socket socket;

        public java_22777_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Bypass access control
                    // This is a simplistic example, in a real scenario,
                    // you'd have more complex logic for access control.
                    if (message.equals("access")) {
                        writer.println("Denied access!");
                    } else {
                        writer.println("Allowed access!");
                    }
                }

                socket.close();
                clients.remove(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}