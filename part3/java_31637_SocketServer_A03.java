import java.io.*;
import java.net.*;

public class java_31637_SocketServer_A03 {
    private static int port = 6666;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_31637_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    // perform security-sensitive operations related to A03_Injection
                    // for example, prevent SQL injection by escaping special characters
                    message = message.replace(";", ";&#34;");
                    message = message.replace("DROP", "DROP&#34;");

                    out.println("Server response: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}