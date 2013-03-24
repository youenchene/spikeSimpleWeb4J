package ychene.spike.service;

import com.github.jmkgreen.morphia.Datastore;
import com.github.jmkgreen.morphia.Morphia;
import com.mongodb.Mongo;
import com.mongodb.MongoURI;
import ychene.spike.dao.MongoDao;
import ychene.spike.model.Object1;

import java.net.UnknownHostException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ychene
 * Date: 24/03/13
 * Time: 09:08
 * To change this template use File | Settings | File Templates.
 */
public class Service1 {

    public MongoDao mongoDao;

    public Service1()
    {
        Mongo m = null;
        try {
            //m = new Mongo(new MongoURI("mongodb://localhost:27017/));"
            m = new Mongo(new MongoURI("mongodb://flame.mongohq.com:27098"));
            Datastore db=new Morphia().createDatastore(m,"LgtSCMeIplQ4hdEK2dcQ","cloudbees", "testcloud".toCharArray());
            mongoDao=new MongoDao(db);
        } catch (UnknownHostException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    public List<Object1> getAllObject1()
    {
        return  mongoDao.find().asList();
    }


    public void insertObject1(Object1 object1)
    {
        mongoDao.save(object1);
    }
}
