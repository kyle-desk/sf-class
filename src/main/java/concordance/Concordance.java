package concordance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Concordance {

	public static void main(String[] args) throws IOException {
		Files.newBufferedReader(Paths.get("Owl.txt"))
		.lines()
		.flatMap(s->Stream.of(s.split("[\\W]")))
		.filter(s->s.length()>0)
		.forEach(s->System.out.println(s));
	}
}
