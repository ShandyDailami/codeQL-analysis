import java.io.*;
import java.net.*;
import java.util.*;

public class java_23617_SocketServer_A03 {

    private static List<Socket> clientSockets = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server started on port 5000");

        while (true) {
            Socket socket = server.accept();
            clientSockets.add(socket);

            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }

    private static class ClientHandler implements Runnable {

        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_23617_SocketServer_A03(Socket socket) {
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
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Here, you could use code that is security-sensitive, such as sending the message back to the client
                    // For example, here we just echo the message back to the client
                    out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                close();
            }
        }

        private void close() {
            clientSockets.remove(socket);
            try {
                socket.close();
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}