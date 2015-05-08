package businesspartners;

import java.util.Comparator;

import addresses.Addressable;

public class Customer implements Addressable, Comparable<Customer>{
	private String street;
	private String city;
	private int zip;
	private long totalSpend;
	
	@Override
	public String getStreet() {
		return street;
	}

	@Override
	public String getCity() {
		return city;
	}

	@Override
	public int getZip() {
		return zip;
	}
	
	public long getTotalSpend() {
		return totalSpend;
	}

	public void addSpending(long s) {
		totalSpend += s;
	}

	@Override
	public String toString() {
		return "Customer [street=" + street + ", city=" + city + ", zip=" + zip
				+ ", totalSpend=" + totalSpend + "]";
	}

	public Customer(String street, String city, int zip) {
		super();
		this.street = street;
		this.city = city;
		this.zip = zip;
	}
	
	public Customer(String street, String city, int zip, long spend) {
		this(street, city, zip);
		totalSpend = spend;
	}

	@Override
	public int compareTo(Customer o) {
		return this.getStreet().compareTo(o.getStreet());
	}
	
	public static Comparator<Customer> getSpendComparator() { // Note the parentheses here VVV
		return new /* private static class CompareBySpend implements */ Comparator<Customer>() {
			@Override
			public int compare(Customer o1, Customer o2) {
				long diff = (o1.totalSpend - o2.totalSpend);
				if (diff > 0) return 1;
				if (diff < 0) return -1;
				return 0;
			}

		}; // <---semicolon completes the return statement
	}
	
}
