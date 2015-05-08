package concordance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Map;

public class Concordance {

	public static void main(String[] args) throws IOException {
		Files.newBufferedReader(Paths.get("Owl.txt"))
		.lines()
		.flatMap(s->Stream.of(s.split("[\\W]")))
		.filter(s->s.length()>0)
		.forEach(s->System.out.println(s));

		Files.newBufferedReader(Paths.get("PrideAndPrejudice.txt"))
		  .lines()
		  .flatMap(s->Stream.of(s.split("[\\W]")))
		  .filter(s->s.length()>0)
		  .collect(Collectors.groupingBy(s->s, Collectors.counting()))
          .entrySet()
		  .stream()
		  .sorted((e1, e2)-> e2.getValue().compareTo(e1.getValue()))
		  .limit(100)
		  .forEach(e-> System.out.println("> " + e.getKey() + " occurs " + e.getValue() + " times"));
		
		
	}
}
