package p1;

import org.junit.Test;
import org.junit.Assert;

import java.io.IOException;

public class H1Test {


    @Test
    public void testParser(){


        H1 testH1 = new H1 ();

       String op = testH1.helloStr(" KVJ1") ;

        Assert.assertEquals(op,"Hello KVJ1");


    }



}

