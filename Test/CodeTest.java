import org.junit.Test;
import org.junit.Assert;

public class CodeTest {

    @Test
    public void testMinSetter()
    {
        WatchData wd = new WatchData();
        double testMinIn = 10;
        wd.setMin(testMinIn);
        double testMinOut = wd.getMin();

        Assert.assertEquals(testMinIn,testMinOut,0);
    }
}
