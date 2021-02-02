package ex1;

import java.math.BigInteger;

public class exRezolvate {
	public static BigInteger k(BigInteger d, BigInteger e, BigInteger n) {
		BigInteger one = new BigInteger("1");

		return ((e.multiply(d)).subtract(one.negate())).divide(n);
	}

	public static BigInteger d(BigInteger d, BigInteger e, BigInteger e2, BigInteger n) {

		BigInteger suma;

		BigInteger sumapow;
		BigInteger delta;

		BigInteger p;
		BigInteger q;

		BigInteger paranteze2;
		BigInteger d2;

		BigInteger one = new BigInteger("1");
		BigInteger kapa = k(d, e, n).add(one);

		BigInteger operator1;
		BigInteger operator2;
		BigInteger operator3;
		BigInteger operator4;
		BigInteger operator5;
		BigInteger operator6;
		operator1 = n.add(one);

		operator2 = kapa.multiply(operator1);

		operator3 = operator2.add(one);

		operator4 = e.multiply(d);
		operator5 = operator3.subtract(operator4);
		operator6 = operator5.divide(kapa);
		suma = operator6;
		sumapow = suma.pow(2);

		delta = sumapow.subtract(kapa.multiply(n));

		p = (suma.add(delta.sqrt())).divide(new BigInteger("2"));

		q = (suma.subtract(delta.sqrt())).divide(new BigInteger("2"));

		paranteze2 = (p.subtract(one)).multiply(q.subtract(one));

		d2 = e2.modPow(one.negate(), paranteze2);
		return d2;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger e1 = new BigInteger("7");
		BigInteger e2 = new BigInteger("17");
		// BigInteger exponent=new BigInteger("-1");
		BigInteger n = new BigInteger("837210799");
		BigInteger d1 = new BigInteger("478341751");
		BigInteger kapa;
		BigInteger ddd;
		kapa = k(d1, e1, n);
		ddd = d(d1, e1, e2, n);

		System.out.println("d2= " + ddd);

	}

}
