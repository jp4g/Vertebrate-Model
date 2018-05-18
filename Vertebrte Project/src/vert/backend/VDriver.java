package vert.backend;

/**
 * Driver for back end work
 * 
 * @author Jack Gilcrest
 *
 */
public class VDriver {
	private final static String URL = "src/vert/res/data.txt";
	private static VNode[] data;
	
	/**
	 * constructor for an instance of VDriver
	 */
	public VDriver() {
		initialize();
	}
	
	public static void main(String[] args) {
		initialize();
	}
	
	/**
	 * initializes the backend of the program
	 */
	private static void initialize() {
		VNodeInitializer v = new VNodeInitializer(URL);
		data = v.getVArray();
	}
	
	public static VNode[] getData() {
		return data;
	}
	
}
