package addresses;

public interface Addressable {
	String getStreet();
	String getCity();
	int getZip();
	default String getAddressLabel() {
		return getStreet() + "\n"
			+ getCity() + "\n"
			+ getZip();
	}
}
