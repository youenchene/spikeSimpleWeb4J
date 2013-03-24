package ychene.spike.test;

import org.fest.assertions.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import ychene.spike.SpikeSimpleWeb4JController;
import ychene.spike.model.Object1;
import ychene.spike.service.Service1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ychene
 * Date: 24/03/13
 * Time: 10:46
 * To change this template use File | Settings | File Templates.
 */
public class Service1Test {

    private static Service1 service1;

    @Before
    public void setup() {
        service1=new Service1();
        try
        {
        service1.mongoDao.getCollection().drop();
        }
        catch (Exception e) {}
    }

    @Test
    public void testService1FindAll()
    {
        List<Object1> expected=new ArrayList<Object1>();
        {
            Object1 o1=new Object1();
            o1.field1="toto";
            o1.field2="titi";
            service1.insertObject1(o1);
            expected.add(o1);
            Object1 o2=new Object1();
            o2.field1="tutu";
            o2.field2="tata";
            service1.insertObject1(o2);
            expected.add(o2);
            Object1 o3=new Object1();
            o3.field1="toutou";
            o3.field2="wouaf";
            service1.insertObject1(o3);
            expected.add(o3);
        }
        List<Object1> result=service1.getAllObject1();
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
