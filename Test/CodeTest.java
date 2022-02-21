import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

public class CodeTest {

    @BeforeClass
    public static void setUpClass()
    {
        System.out.println("setup");
    }


    @AfterClass
    public static void tearDownClass()
    {
        System.out.println("teardown");
    }



    @Test
    public void testMinSetter()
    {
        WatchData wd = new WatchData();
        double testMinIn = 10;
        wd.setMin(testMinIn);
        double testMinOut = wd.getMin();

        Assert.assertEquals(testMinIn,testMinOut,0);
    }

    @Test
    public void testMinSetterFailure()
    {
        WatchData wd = new WatchData();
        double testMinIn = 11;
        wd.setMin(testMinIn);
        double testMinOut = 11;

        Assert.assertEquals(testMinIn,testMinOut,0);
    }

    @Test
    public void testMaxSetterNotEqual()
    {
        WatchData wd = new WatchData();
        double testMinIn = 11;
        wd.setMin(testMinIn);
        double testMinOut = 12;

        Assert.assertNotEquals(testMinIn,testMinOut,0);
    }

    @Test
    public void testNoFourBetterName()
    {
        WatchData wd = new WatchData();
        double testMinIn = 110;
        wd.setMin(testMinIn);
        double testMinOut = 120;

        Assert.assertNotEquals(testMinIn,testMinOut,0);
    }

    @Test
    public void testNoFive()
    {
        WatchData wd = new WatchData();
        double testMinIn = 1100;
        wd.setMin(testMinIn);
        double testMinOut = 120;

        Assert.assertNotEquals(testMinIn,testMinOut,0);
    }

}
