/**
 * Created by brajesh.k on 10/10/15.
 * An efficient way to calculate a ^ b % c. TC of this algo is O(log n).
 */
public class ModularExponentiation {

    /**
     * if number is in int range
     * (a2)(b/2)           if b is even and b > 0
     * ab = a*(a2)((b-1)/2)    if b is odd
     * 1                  if b = 0
     */
    public static int modulo(int a, int b, int c) {
        long x = 1;
        long y = a;
        while (b > 0) {
            if ((b & 1) == 1) { // b is odd
                x = (x * y) % c;
            }
            y = (y * y) % c; // squaring base
            b >>= 1;
        }


        return (new Long(x % c)).intValue();
    }

}
