import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class Io {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8080);
            System.out.println("客户端启动成功");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            System.out.println("Server:" + in.readLine());
//            socket.connect(new InetSocketAddress("localhost", 8080));
//            OutputStream out = socket.getOutputStream();
            PrintWriter write = new PrintWriter(socket.getOutputStream());
            //Buffer buffer = new Buffer();
            write.println("hello");
            write.flush();

            write.close();
            socket.close();
//            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
