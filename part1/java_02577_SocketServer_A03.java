import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_02577_SocketServer_A03 {
    private static ExecutorService executor = Executors.newCachedThreadPool();
    private static Socket socket;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8000);
            System.out.println("Server is listening on port 8000...");

            while (true) {
                socket = serverSocket.accept();
                System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected!");
                Handler handler = new Handler(socket);
                executor.execute(handler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Handler implements Runnable {
        Socket socket;

        public java_02577_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                String message;
                while ((message = in.readLine()) != null) {
                    if (message.equals("exit")) {
                        break;
                    }
                    out.writeBytes(message + "\n");
                }
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}