package barchart;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MonteCarlo {

	public static void main(String[] args) {
		Instant start = Instant.now();
		Stream.generate(
			((Supplier<Integer>)() -> {
				ThreadLocalRandom tlr = ThreadLocalRandom.current(); 
				return tlr.nextInt(1 ,7) + tlr.nextInt(1, 7);
				}
			))
			.parallel()
			.limit(1_000_000_000)
			.collect(Collectors.groupingBy(v->v, Collectors.counting()))
			.entrySet()
			.stream()
			.sorted((e1,e2) -> e1.getKey() - e2.getKey())
			.forEach((e)-> System.out.println(
			    e.getKey() + ":" 
			    + Stream.generate(()->"*")
				.limit(e.getValue()/2_000_000)
				.reduce("", (s,t)->s+t)));
		Instant end = Instant.now();
		System.out.println("Processing took " + ChronoUnit.MILLIS.between(start, end));
	}

}
