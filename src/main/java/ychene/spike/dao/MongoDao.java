package ychene.spike.dao;

import com.github.jmkgreen.morphia.Datastore;
import com.github.jmkgreen.morphia.Morphia;
import com.github.jmkgreen.morphia.dao.BasicDAO;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoURI;
import org.bson.types.ObjectId;
import ychene.spike.model.Object1;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ychene
 * Date: 24/03/13
 * Time: 09:09
 * To change this template use File | Settings | File Templates.
 */
public class MongoDao extends BasicDAO<Object1, ObjectId> {

    public MongoDao( Datastore ds ) throws UnknownHostException {

        super(ds);
    }
}
