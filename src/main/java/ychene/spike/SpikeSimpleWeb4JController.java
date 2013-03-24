package ychene.spike;

import fr.ybonnel.simpleweb4j.exception.HttpErrorException;
import fr.ybonnel.simpleweb4j.handlers.Response;
import fr.ybonnel.simpleweb4j.handlers.Route;
import fr.ybonnel.simpleweb4j.handlers.RouteParameters;
import ychene.spike.model.Object1;
import ychene.spike.service.Service1;

import java.util.List;

import static fr.ybonnel.simpleweb4j.SimpleWeb4j.*;

/**
 * Main class.
 */
public class SpikeSimpleWeb4JController {


    private static Service1 service1=new Service1();

    /**
     * Object return by route.
     */
    public static class Hello {
        public String value = "Hello You!";
    }

    /**
     * Start the server.
     * @param port http port to listen.
     * @param waitStop true to wait the stop.
     */
    public static void startServer(int port, boolean waitStop) {
        // Set the http port.
        setPort(port);
        // Set the path to static resources.
        setPublicResourcesPath("public");

        // Declare the route "/hello" for GET method whith no param in request payload.
        get(new Route<Void, Hello>("/hello", Void.class) {
            @Override
            public Response<Hello> handle(Void param, RouteParameters routeParams) throws HttpErrorException {
                return new Response<>(new Hello());
            }
        });

        // Declare the route "/object1" for GET method whith no param in request payload.
        get(new Route<Void, List<Object1>>("/object1", Void.class) {
            @Override
            public Response<List<Object1>> handle(Void param, RouteParameters routeParams) throws HttpErrorException {
                return new Response<>(service1.getAllObject1());
            }
        });


        post(new Route<Object1, Object1>("/object1/", Object1.class) {
            @Override
            public Response<Object1> handle(Object1 param, RouteParameters routeParams) throws HttpErrorException {
                service1.insertObject1(param);
                return new Response<>(param);
            }
        });

        // Start the server.
        start(waitStop);
    }

    /**
     * Get the port.
     * <ul>
     *     <li>Heroku : System.getenv("PORT")</li>
     *     <li>Cloudbees : System.getProperty("app.port")</li>
     *     <li>default : 9999</li>
     * </ul>
     * @return
     */
    private static int getPort() {
        // Heroku
        String herokuPort = System.getenv("PORT");
        if (herokuPort != null) {
            return Integer.parseInt(herokuPort);
        }

        // Cloudbees
        String cloudbeesPort = System.getProperty("app.port");
        if (cloudbeesPort != null) {
            return Integer.parseInt(cloudbeesPort);
        }

        // Default port;
        return 80;
    }

    public static void main(String[] args) {
        // For main, we want to wait the stop.
        startServer(getPort(), true);
    }
}
