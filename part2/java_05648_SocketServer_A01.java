import java.io.*;
import java.net.*;

public class java_05648_SocketServer_A01 {
    private static boolean running = true;

    public static void main(String[] args) {
        new SocketServer();
    }

    private java_05648_SocketServer_A01() {
        ServerSocket server = null;
        try {
            server = new ServerSocket(1234);
            System.out.println("Server started at port 1234");
            while (running) {
                Socket socket = server.accept();
                System.out.println("Client connected at " + socket.getRemoteSocketAddress());
                new ClientHandler(socket);
            }
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
       
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Server stopped");
        }
    }

    private class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public java_05648_SocketServer_A01(Socket socket) {
            this.socket = socket;
            try {
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                start();
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
                    out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                close();
            }
        }

        private void close() {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}