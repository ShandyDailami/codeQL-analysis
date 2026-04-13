import java.io.*;
import java.net.*;
import java.util.*;

public class java_04777_SocketServer_A08 {
    private static List<Socket> clientSockets = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is ready to receive connections");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());
            clientSockets.add(socket);

            new HandleClient(socket).start();
        }
    }

    private static class HandleClient extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_04777_SocketServer_A08(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;
            try {
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Here we simulate a security-sensitive operation related to A08_IntegrityFailure
                    // e.g., checking if the message contains a certain pattern or if the content is corrupted
                    if (message.contains("important information")) {
                        System.out.println("Security alert: Corrupted message detected");
                        out.println("Security alert: Corrupted message detected");
                    } else {
                        System.out.println("Security alert: No integrity failure detected");
                        out.println("Security alert: No integrity failure detected");
                   
                    }

                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                socket.close();
                clientSockets.remove(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}