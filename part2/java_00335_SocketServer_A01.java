import java.io.*;
import java.net.*;

public class java_00335_SocketServer_A01 {
    private static boolean stopThreads = false;

    public static void main(String args[]) throws IOException {
        ServerSocket server = new ServerSocket(4444);
        while (!stopThreads) {
            Socket socket = server.accept();
            System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());
            new HandleConnection(socket).start();
        }
        server.close();
    }

    private static class HandleConnection extends Thread {
        private Socket socket;

        public java_00335_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);
                    out.println("Echo: " + inputLine);
                }
                out.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}