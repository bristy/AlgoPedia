import org.junit.Test;
import static org.junit.Assert.*;

public class ModularExponentiationTest {
	
	@Test(timeout=2000)
	public void test0() {
		int a = 3;
		int b = 5;
		int c = 8;
		assertEquals(3, ModularExponentiation.modulo(a, b, c));
	}
	

}
