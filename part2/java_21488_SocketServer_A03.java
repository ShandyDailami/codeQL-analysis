import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class java_21488_SocketServer_A03 {

    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {

        //Initialize executor
        executor = Executors.newFixedThreadPool(10);

        //Socket server
        ServerSocket serverSocket = new ServerSocket(12345);

        System.out.println("Server is listening on port 12345...");

        while(true){
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            //Thread to handle the communication
            executor.execute(new ClientHandler(socket));
        }
    }

    public static class ClientHandler implements Runnable{

        Socket socket;

        public java_21488_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run(){
            try{
                //Create streams
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                //Read and echo message
                String message;
                while((message = in.readLine()) != null){
                    System.out.println("Received: " + message);
                    //Add code for Injection here
                    //Example of Injection:
                    //String sqlInjection = "select * from Users where username='" + message + "'";
                    //out.println(sqlInjection);

                    //Example of not Injection
                    out.println("Echo: " + message);
                }

                //Close the socket
                socket.close();

            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}