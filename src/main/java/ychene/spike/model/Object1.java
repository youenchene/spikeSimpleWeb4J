package ychene.spike.model;

import com.github.jmkgreen.morphia.annotations.Entity;
import com.github.jmkgreen.morphia.annotations.Id;
import org.bson.types.ObjectId;


import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: ychene
 * Date: 24/03/13
 * Time: 09:05
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Object1 implements Serializable
{
    @Id
    public ObjectId id;
    public String field1;
    public String field2;
    public String field3;

    @Override
    public String toString() {
        return "Object1{" +
                "id=" + id +
                ", field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Object1 object1 = (Object1) o;

        if (field1 != null ? !field1.equals(object1.field1) : object1.field1 != null) return false;
        if (field2 != null ? !field2.equals(object1.field2) : object1.field2 != null) return false;
        if (field3 != null ? !field3.equals(object1.field3) : object1.field3 != null) return false;
        if (id != null ? !id.equals(object1.id) : object1.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (field1 != null ? field1.hashCode() : 0);
        result = 31 * result + (field2 != null ? field2.hashCode() : 0);
        result = 31 * result + (field3 != null ? field3.hashCode() : 0);
        return result;
    }
}
