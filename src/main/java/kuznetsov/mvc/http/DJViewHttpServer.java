package kuznetsov.mvc.http;

import com.sun.net.httpserver.HttpServer;
import kuznetsov.mvc.models.BeatModel;

import java.net.InetSocketAddress;

public class DJViewHttpServer {

    public static void main(String[] args) {

        try {
            System.out.println("DJView Http Server Running");

            BeatModel beatModel = new BeatModel();
            beatModel.initialize();

            HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8080), 0);
            server.createContext("/djview", new DJViewHttpHandler(beatModel));
            server.start();
            System.out.println("DJView Server is running at http://localhost:8080/djview");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
