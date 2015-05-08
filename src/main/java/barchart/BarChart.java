package barchart;

import java.util.stream.Stream;

public class BarChart {

	public static void bar(int n) {
		Stream.generate(()->"*")
			.limit(n)
			.reduce((s,t)->s+t)
			.ifPresent(s->System.out.println(s));;
	}

	public static void main(String[] args) {
		bar(5);
		bar(9);
		bar(7);
	}

}
