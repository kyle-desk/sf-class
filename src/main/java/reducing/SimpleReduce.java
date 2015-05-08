package reducing;

import java.util.Optional;
import java.util.stream.Stream;

public class SimpleReduce {

	public static void main(String[] args) {
		Optional<String> os = Stream.of("Fred", "Jim", "Sheila")
				.reduce((a, b) -> a + b);
		os.ifPresent(s -> System.out.println(s));

		String s = Stream.of("Fred", "Jim", "Sheila")
				.reduce(", ", (t,u)->t+u);
		System.out.println(s);
		
		StringBuilder s2 = Stream.of("Fred", "Jim", "Sheila")
				.collect(
						()->new StringBuilder(),
						(t,u)->t.append(u),
						(t,u)->t.append(u)
						);
		System.out.println(s2);
		

	}

}
