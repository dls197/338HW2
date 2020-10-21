import java.lang.Math;
import java.util.*;
public class RandomGenerator {
	private static Random rand = new Random();
	public static int uniformRandom(int k) {

		return rand.nextInt(k+1);
	}
	public static int expRandom(int k) {
		double expBound =1;
		for (int i = 0; i<k;i++)expBound*=2;
		return (int) (-(Math.log(1-rand.nextDouble()*(1-1/expBound)))/(Math.log(2)));
	}
	public static int myRandom(int k) {
		int I = (int) Math.round(rand.nextFloat());
		int J = expRandom(k-6);
		return I*(4+rand.nextInt(6))+(1-I)*(J+((int)Math.signum(Math.signum(J-4)+1)*6));
	}
}
