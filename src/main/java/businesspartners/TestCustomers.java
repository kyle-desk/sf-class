package businesspartners;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import addresses.Addressable;

public class TestCustomers {

	public static void main(String[] args) {
		List<Customer> lc = Arrays.asList(
				new Customer("123 Acacia", "Warwick", 12345, 123),
				new Customer("1 Market", "San Francisco", 94105, 34),
				new Customer("27 Market", "San Francisco", 94105, 3400),
				new Customer("36 Market", "San Francisco", 94105, 934),
				new Customer("44 Market", "San Francisco", 94105, 374),
				new Customer("128 Market", "San Francisco", 94105, 534),
				new Customer("19 Market", "San Francisco", 94105, 3),
				new Customer("36 Market", "San Francisco", 94105, 304),
				new Customer("37 Downtown Lane", "Hillsboro", 42971, 97)
			);
		System.out.println("     Unsorted: " + lc);
		lc.sort(new CompareByZip());
		System.out.println("Sorted by zip: " + lc);
		lc.sort(Customer.getSpendComparator());
		System.out.println("Sorted by spend: " + lc);
		
		lc.sort(/*new Comparator<Addressable>() {
			@Override
			public int compare*/(Addressable o1, Addressable o2) -> {
				return o1.getStreet().compareTo(o2.getStreet());
			}
		/*}*/);

		lc.sort((Addressable o1, Addressable o2) -> {
					return o1.getStreet().compareTo(o2.getStreet());
				}
			);

		lc.sort((o1, o2) -> o1.getStreet().compareTo(o2.getStreet()));
		System.out.println("Sorted by street: " + lc);

		lc.sort((Comparator<Addressable>)((o1, o2) -> o1.getStreet().compareTo(o2.getStreet())));
		System.out.println("Sorted by street: " + lc);
		
		lc.forEach(c-> System.out.println(">" + c.getAddressLabel()));
		
		Predicate<String> ps = s -> s.length() > 4;
		System.out.println("ps is a " + ps.getClass().getName());
		System.out.println("ps is" + (ps instanceof Predicate ? "":" not") + " a Predicate");

		lc.stream().filter(c->c.getCity().equals("San Francisco")).forEach(c->System.out.println(c));
		long howMany = lc.stream().filter(c->c.getCity().equals("San Francisco")).count();
		System.out.println("There are " + howMany + " Customers in SF");
		List<Customer> lc2 = lc.stream().filter(c->c.getCity().equals("San Francisco")).collect(Collectors.toList());
		System.out.println("LC2 is " + lc2);
		
		lc.stream()
			.filter(c->c.getCity().equals("San Francisco"))
			.map(c -> c.getStreet())
			.sorted((s1,s2)->s1.compareTo(s2))
			.forEach(c->System.out.println(c));
	}
}
