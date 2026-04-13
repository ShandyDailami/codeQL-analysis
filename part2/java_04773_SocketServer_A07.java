import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_04773_SocketServer_A07 {
    private static final ExecutorService pool = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6789);
        while (true) {
            Socket socket = server.accept();
            pool.execute(new ClientHandler(socket));
        }
    }

    static class ClientHandler implements Runnable {
        Socket socket;

        public java_04773_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    if (message.equals("auth:fail")) { // Authentication Failure
                        out.println("You've failed the authentication.");
                        out.flush();
                        socket.close();
                        return;
                    } else {
                        out.println("Server: " + message);
                        out.flush();
                    }
                }
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}