import org.junit.Test;
import rmq.RMQSQRTDecompositon;

import static org.junit.Assert.assertEquals;

/**
 * Created by brajesh.k on 04/03/16.
 */
public class RMQSQRTDecompositonTest {
    @Test(timeout=2000)
    public void test0() {
        int A[] = new int[] {2, 4, 3, 1, 6, 7, 8, 9, 1, 7};
        int i = 2;
        int j = 7;
        int ans = 3;
        assertEquals(ans, (new RMQSQRTDecompositon(A)).query(i, j));
    }
}
