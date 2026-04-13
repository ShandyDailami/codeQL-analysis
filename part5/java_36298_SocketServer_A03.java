import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_36298_SocketServer_A03 {
    private static ExecutorService exec = Executors.newCachedThreadPool();
    private static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        serverSocket = new ServerSocket(8080);
        System.out.println("Server is ready.");
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("New Client Connected.");
                Handler handler = new Handler(socket);
                exec.execute(handler);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

    static class Handler extends Thread {
        private Socket socket;
        public java_36298_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                String clientMessage, serverMessage;
                while (true) {
                    clientMessage = reader.readLine();
                    if (clientMessage == null) break;
                    serverMessage = "Server received: " + clientMessage;
                    outputStream.writeBytes(serverMessage + '\n');
                    outputStream.flush();
                }
                socket.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
}