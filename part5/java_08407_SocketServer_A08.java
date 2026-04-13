import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_08407_SocketServer_A08 {
    private static ExecutorService executor = Executors.newCachedThreadPool();
    private static int clientCount = 0;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            clientCount++;
            System.out.println("Client " + clientCount + " connected");

            executor.execute(new ClientHandler(socket));
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_08407_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);

                    if (inputLine.equals("exit")) {
                        out.writeBytes("Goodbye!\n");
                        socket.close();
                        System.out.println("Client " + clientCount + " disconnected");
                        return;
                    }

                    out.writeBytes("Hello client " + clientCount + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}