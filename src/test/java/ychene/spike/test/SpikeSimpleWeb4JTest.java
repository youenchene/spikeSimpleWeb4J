package ychene.spike.test;

import org.junit.Before;
import com.github.kevinsawicki.http.HttpRequest;
import org.junit.After;
import org.junit.Test;
import ychene.spike.SpikeSimpleWeb4JController;

import static fr.ybonnel.simpleweb4j.SimpleWeb4j.stop;
import static org.junit.Assert.assertEquals;

public class SpikeSimpleWeb4JTest {

    private int port;

    @Before
    public void setup() {
        port = Integer.getInteger("test.http.port", 9999);
        SpikeSimpleWeb4JController.startServer(port, false);
    }

    @After
    public void tearDown() {
        stop();
    }

    @Test
    public void testHelloWorldService() {
        assertEquals("{\"value\":\"Hello You!\"}", HttpRequest.get("http://localhost:" + port + "/hello").body());
    }

}
