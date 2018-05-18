package vert.backend;

/**
 * Various VNode array search functions
 * 
 * @author Jack Gilcrest
 *
 */

public class VSearch {
	private static VNode[] data;

	public VSearch(VNode[] data) {
		this.data = data;
	}

	/**
	 * Creates an array of VNodes based on a search query
	 * 
	 * @param theData the full library of VNodes
	 * @param category the VNode variable to search
	 * @param key the value being searched for
	 * @return an array of VNodes with values equal to key for the specified
	 *         category
	 */
	public static VNode[] query(String category, String key) {
		VNode[] temp;
		switch (category.toLowerCase()) {
		case "identifier":
			temp = getAllIdentifiers(key);
			break;
		case "nature":
			temp = getAllNatures(key);
			break;
		case "category":
			temp = getAllCategories(key);
			break;
		case "cname":
			temp = getAllCNames(key);
			break;
		case "kingdom":
			temp = getAllKingdoms(key);
			break;
		case "phylum":
			temp = getAllPhylums(key);
			break;
		case "subphylum":
			temp = getAllSubphylums(key);
			break;
		case "vclass":
			temp = getAllVClasses(key);
			break;
		case "subclass":
			temp = getAllSubclasses(key);
			break;
		case "order":
			temp = getAllOrders(key);
			break;
		case "suborder":
			temp = getAllSuborders(key);
			break;
		case "family":
			temp = getAllFamilies(key);
			break;
		case "genus":
			temp = getAllGenera(key);
			break;
		case "species":
			temp = getAllSpecies(key);
			break;
		case "geolperiod":
			temp = getAllgeolPeriods(key);
			break;
		case "geolepoch":
			temp = getAllgeolEpochs(key);
			break;
		case "habitat":
			temp = getAllHabitats(key);
			break;
		case "diet":
			temp = getAllDiets(key);
			break;
		case "egg":
			temp = getAllEggs(key);
			break;
		default:
			temp = null;
			break;
		}
		return resizeV(temp);
	}

	/**
	 * Creates an array of all VNodes with age ranges containing the specified date
	 * 
	 * @param theData the full library of VNodes
	 * @param date the date being searched for
	 * @return an array of VNodes matching the age query
	 */
	public static VNode[] queryAge(VNode[] theData, double date) {
		VNode[] temp = new VNode[data.length];
		int index = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i].getAgeStart() >= date && data[i].getAgeEnd() <= date)
				temp[index] = data[i];
		}
		return temp;
	}

	/**
	 * Creates an array of all VNodes containing overlapping age ranges within the
	 * specified age range
	 * 
	 * @param theData the full library of VNodes
	 * @param start the start date being searched for
	 * @param end the end date being searched for
	 * @return an array of VNodes matching the age query
	 */
	public static VNode[] queryAge(VNode[] theData, double start, double end) {
		VNode[] temp = new VNode[data.length];
		int index = 0;
		for (int i = 0; i < data.length; i++) {
			if (withinDateRange(data[i], start, end))
				temp[index] = data[i];
		}
		return temp;
	}

	/**
	 * Creates an array of all VNodes with size ranges containing or size values
	 * matching the queried size
	 * 
	 * @param theData the full library of VNodes
	 * @param size the size being searched for
	 * @return an array of VNodes matching the size query
	 */
	public static VNode[] querySize(VNode[] theData, double size) {
		VNode[] temp = new VNode[data.length];
		int index = 0;
		for (int i = 0; i < data.length; i++) {
			if (containsSize(data[i], size))
				temp[index] = data[i];
		}
		return temp;
	}

	/**
	 * Creates an array of all VNodes with size ranges overlapping the queried size
	 * range
	 * 
	 * @param theData the full library of VNodes
	 * @param min the minimum size being searched for
	 * @param max the maximum size being searched for
	 * @return an array of VNodes matching the size query
	 */
	public static VNode[] querySize(VNode[] theData, double min, double max) {
		VNode[] temp = new VNode[data.length];
		int index = 0;
		for (int i = 0; i < data.length; i++) {
			if (withinSizeRange(data[i], max, min))
				temp[index] = data[i];
		}
		return temp;
	}

	/**
	 * determines whether a VNodee's existence/ age range overlaps with a specified
	 * date range
	 * 
	 * @param target the VNode being evaluated
	 * @param start start date of existence
	 * @param end end date of existence
	 * @return true if the VNode's existence falls within the date range, and false
	 *         otherwise
	 */
	private static boolean withinDateRange(VNode target, double start, double end) {
		if (target.getAgeStart() >= start && target.getAgeEnd() <= start)
			return true;
		else if (target.getAgeStart() >= end && target.getAgeEnd() <= end)
			return true;
		else if (target.getAgeStart() >= start && target.getAgeEnd() <= end)
			return true;
		else if (target.getAgeStart() <= start && target.getAgeEnd() >= end)
			return true;
		else
			return false;
	}

	/**
	 * determines whether a VNodee's size range overlaps or the size falls within a
	 * specified size range
	 * 
	 * @param target the VNode being evaluated
	 * @param min the minimum size
	 * @param max the maximum size
	 * @return true if the VNode's existence falls within the date range, and false
	 *         otherwise
	 */
	private static boolean withinSizeRange(VNode target, double min, double max) {
		if (target.getSizeMax() != -1) {
			if (target.getSizeMax() >= max && target.getAgeEnd() <= max)
				return true;
			else if (target.getAgeStart() >= min && target.getAgeEnd() <= min)
				return true;
			else if (target.getAgeStart() >= max && target.getAgeEnd() <= min)
				return true;
			else if (target.getAgeStart() <= max && target.getAgeEnd() >= min)
				return true;
		} else {
			if (target.getSizeMin() <= max && target.getSizeMin() >= min)
				return true;
		}
		return false;
	}

	/**
	 * determines whether a VNodee's size range overlaps or the size falls within a
	 * specified size range
	 * 
	 * @param target the VNode being evaluated
	 * @param min the minimum size
	 * @param max the maximum size
	 * @return true if the VNode's existence falls within the date range, and false
	 *         otherwise
	 */
	private static boolean containsSize(VNode target, double size) {
		if (target.getSizeMin() == size)
			return true;
		else
			return target.getSizeMin() <= size && target.getSizeMax() >= size;
	}

	/**
	 * creates an array of all VNodes with matching identifier values
	 * 
	 * @param key the identifier keyword
	 * @return array of VNodes with matching identifier values
	 */
	private static VNode[] getAllIdentifiers(String key) {
		VNode[] temp = new VNode[data.length];
		int index = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i].getIdentifier().equals(key))
				temp[index++] = data[i];
		}
		return temp;
	}

	/**
	 * creates an array of all VNodes with matching nature values
	 * 
	 * @param key the nature keyword
	 * @return array of VNodes with matching nature values
	 */
	private static VNode[] getAllNatures(String key) {
		VNode[] temp = new VNode[data.length];
		int index = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i].getNature().equals(key))
				temp[index++] = data[i];
		}
		return temp;
	}

	/**
	 * creates an array of all VNodes with matching category values
	 * 
	 * @param key the category keyword
	 * @return array of VNodes with matching category values
	 */
	private static VNode[] getAllCategories(String key) {
		VNode[] temp = new VNode[data.length];
		int index = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i].getCategory().equals(key))
				temp[index++] = data[i];
		}
		return temp;
	}

	/**
	 * creates an array of all VNodes with matching cName values
	 * 
	 * @param key the cName keyword
	 * @return array of VNodes with matching cName values
	 */
	private static VNode[] getAllCNames(String key) {
		VNode[] temp = new VNode[data.length];
		int index = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i].getCName().equals(key))
				temp[index++] = data[i];
		}
		return temp;
	}

	/**
	 * creates an array of all VNodes with matching kingdom values
	 * 
	 * @param key the kingdom keyword
	 * @return array of VNodes with matching kingdom values
	 */
	private static VNode[] getAllKingdoms(String key) {
		VNode[] temp = new VNode[data.length];
		int index = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i].getKingdom().equals(key) || key == null)
				temp[index++] = data[i];
		}
		return temp;
	}

	/**
	 * creates an array of all VNodes with matching phylum values
	 * 
	 * @param key the phylum keyword
	 * @return array of VNodes with matching phylum values
	 */
	private static VNode[] getAllPhylums(String key) {
		VNode[] temp = new VNode[data.length];
		int index = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i].getPhylum().equals(key))
				temp[index++] = data[i];
		}
		return temp;
	}

	/**
	 * creates an array of all VNodes with matching subphylum values
	 * 
	 * @param key the subphylum keyword
	 * @return array of VNodes with matching subphylum values
	 */
	private static VNode[] getAllSubphylums(String key) {
		VNode[] temp = new VNode[data.length];
		int index = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i].getSubphylum().equals(key))
				temp[index++] = data[i];
		}
		return temp;
	}

	/**
	 * creates an array of all VNodes with vClass nature values
	 * 
	 * @param key the vClass keyword
	 * @return array of VNodes with matching vClass values
	 */
	private static VNode[] getAllVClasses(String key) {
		VNode[] temp = new VNode[data.length];
		int index = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i].getVClass().equals(key))
				temp[index++] = data[i];
		}
		return temp;
	}

	/**
	 * creates an array of all VNodes with matching subclass values
	 * 
	 * @param key the subclass keyword
	 * @return array of VNodes with matching subclass values
	 */
	private static VNode[] getAllSubclasses(String key) {
		VNode[] temp = new VNode[data.length];
		int index = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i].getSubclass().equals(key))
				temp[index++] = data[i];
		}
		return temp;
	}

	/**
	 * creates an array of all VNodes with matching order values
	 * 
	 * @param key the order keyword
	 * @return array of VNodes with matching order values
	 */
	private static VNode[] getAllOrders(String key) {
		VNode[] temp = new VNode[data.length];
		int index = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i].getOrder().equals(key))
				temp[index++] = data[i];
		}
		return temp;
	}

	/**
	 * creates an array of all VNodes with matching suborder values
	 * 
	 * @param key the suborder keyword
	 * @return array of VNodes with matching suborder values
	 */
	private static VNode[] getAllSuborders(String key) {
		VNode[] temp = new VNode[data.length];
		int index = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i].getSuborder().equals(key))
				temp[index++] = data[i];
		}
		return temp;
	}

	/**
	 * creates an array of all VNodes with matching family values
	 * 
	 * @param key the family keyword
	 * @return array of VNodes with matching family values
	 */
	private static VNode[] getAllFamilies(String key) {
		VNode[] temp = new VNode[data.length];
		int index = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i].getFamily().equals(key))
				temp[index++] = data[i];
		}
		return temp;
	}

	/**
	 * creates an array of all VNodes with matching genus values
	 * 
	 * @param key the genus keyword
	 * @return array of VNodes with matching genus values
	 */
	private static VNode[] getAllGenera(String key) {
		VNode[] temp = new VNode[data.length];
		int index = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i].getGenus().equals(key))
				temp[index++] = data[i];
		}
		return temp;
	}

	/**
	 * creates an array of all VNodes with matching species values
	 * 
	 * @param key the species keyword
	 * @return array of VNodes with matching species values
	 */
	private static VNode[] getAllSpecies(String key) {
		VNode[] temp = new VNode[data.length];
		int index = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i].getSpecies().equals(key))
				temp[index++] = data[i];
		}
		return temp;
	}

	/**
	 * creates an array of all VNodes with matching geolPeriod values
	 * 
	 * @param key the geolPeriod keyword
	 * @return array of VNodes with matching geolPeriod values
	 */
	private static VNode[] getAllgeolPeriods(String key) {
		VNode[] temp = new VNode[data.length];
		int index = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i].getGeolPeriod().equals(key))
				temp[index++] = data[i];
		}
		return temp;
	}

	/**
	 * creates an array of all VNodes with matching geolEpoch values
	 * 
	 * @param key the geolEpoch keyword
	 * @return array of VNodes with matching geolEpoch values
	 */
	private static VNode[] getAllgeolEpochs(String key) {
		VNode[] temp = new VNode[data.length];
		int index = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i].getGeolEpoch().equals(key))
				temp[index++] = data[i];
		}
		return temp;
	}

	/**
	 * creates an array of all VNodes with matching habitat values
	 * 
	 * @param key the habitat keyword
	 * @return array of VNodes with matching habitat values
	 */
	private static VNode[] getAllHabitats(String key) {
		VNode[] temp = new VNode[data.length];
		int index = 0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].getHabitat().length; j++) {
				if (data[i].getHabitat()[j].equals(key))
					temp[index++] = data[i];
			}
		}
		return temp;
	}

	/**
	 * creates an array of all VNodes with matching diet values
	 * 
	 * @param key the diet keyword
	 * @return array of VNodes with matching diet values
	 */
	private static VNode[] getAllDiets(String key) {
		VNode[] temp = new VNode[data.length];
		int index = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i].getDiet().equals(key))
				temp[index++] = data[i];
		}
		return temp;
	}

	/**
	 * creates an array of all VNodes with matching egg values
	 * 
	 * @param key the egg keyword
	 * @return array of VNodes with matching egg values
	 */
	private static VNode[] getAllEggs(String key) {
		VNode[] temp = new VNode[data.length];
		int index = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i].getEgg().equals(key))
				temp[index++] = data[i];
		}
		return temp;
	}

	/**
	 * Determines if a value is present in an array of Strings
	 * 
	 * @param String[] arr the array being searched
	 * @param x the value being searched for
	 * @return true if the array contains the value, and false otherwise
	 */
	private static boolean included(String[] arr, String x) {
		int increment = 0;
		while (arr[increment] != null && increment < arr.length) {
			if (arr[increment].equals(x))
				return true;
			else
				increment++;
		}
		return false;
	}

	/**
	 * resizes a string array to be exactly the length of its members
	 */
	private static String[] resize(String[] arr) {
		String temp[];
		int index = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				index = i;
				break;
			}
		}
		if (index == -1)
			return arr;
		else {
			temp = new String[index];
			for (int i = 0; i < temp.length; i++)
				temp[i] = arr[i];
			return temp;
		}
	}

	/**
	 * resizes a vnode array to be exactly the length of its members
	 */
	private static VNode[] resizeV(VNode[] arr) {
		VNode[] temp;
		int index = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				index = i;
				break;
			}
		}
		if (index == -1)
			return arr;
		else {
			temp = new VNode[index];
			for (int i = 0; i < temp.length; i++)
				temp[i] = arr[i];
			return temp;
		}
	}

	/**
	 * returns all possible values in the identifier category
	 */
	private static String[] getPossibleIdentifiers() {
		String[] temp = new String[data.length];
		int increment = 0;
		for (int i = 0; i < temp.length; i++) {
			if (!included(temp, data[i].getIdentifier()))
				temp[increment++] = data[i].getIdentifier();
		}
		return resize(temp);
	}

	/**
	 * returns all possible values in the nature category
	 */
	private static String[] getPossibleNatures() {
		String[] temp = new String[data.length];
		int increment = 0;
		for (int i = 0; i < temp.length; i++) {
			if (!included(temp, data[i].getNature()))
				temp[increment++] = data[i].getNature();
		}
		return resize(temp);
	}

	/**
	 * returns all possible values in the category category
	 */
	private static String[] getPossibleCategories() {
		String[] temp = new String[data.length];
		int increment = 0;
		for (int i = 0; i < temp.length; i++) {
			if (!included(temp, data[i].getCategory()))
				temp[increment++] = data[i].getCategory();
		}
		return resize(temp);
	}

	/**
	 * returns all possible values in the common name category
	 */
	private static String[] getPossibleCNames() {
		String[] temp = new String[data.length];
		int increment = 0;
		for (int i = 0; i < temp.length; i++) {
			if (!included(temp, data[i].getCName()))
				temp[increment++] = data[i].getCName();
		}
		return resize(temp);
	}

	/**
	 * returns all possible values in the kingdom category
	 */
	private static String[] getPossibleKingdoms() {
		String[] temp = new String[data.length];
		int increment = 0;
		for (int i = 0; i < temp.length; i++) {
			if (!included(temp, data[i].getKingdom()))
				temp[increment++] = data[i].getKingdom();
		}
		return resize(temp);
	}

	/**
	 * returns all possible values in the phylum category
	 */
	private static String[] getPossiblePhylums() {
		String[] temp = new String[data.length];
		int increment = 0;
		for (int i = 0; i < temp.length; i++) {
			if (!included(temp, data[i].getPhylum()))
				temp[increment++] = data[i].getPhylum();
		}
		return resize(temp);
	}

	/**
	 * returns all possible values in the subphylum category
	 */
	private static String[] getPossibleSubphylums() {
		String[] temp = new String[data.length];
		int increment = 0;
		for (int i = 0; i < temp.length; i++) {
			if (!included(temp, data[i].getSubphylum()))
				temp[increment++] = data[i].getSubphylum();
		}
		return resize(temp);
	}

	/**
	 * returns all possible values in the class category
	 */
	private static String[] getPossibleVClasses() {
		String[] temp = new String[data.length];
		int increment = 0;
		for (int i = 0; i < temp.length; i++) {
			if (!included(temp, data[i].getVClass()))
				temp[increment++] = data[i].getVClass();
		}
		return resize(temp);
	}

	/**
	 * returns all possible values in the subclass category
	 */
	private static String[] getPossibleSubclasses() {
		String[] temp = new String[data.length];
		int increment = 0;
		for (int i = 0; i < temp.length; i++) {
			if (!included(temp, data[i].getSubclass()))
				temp[increment++] = data[i].getSubclass();
		}
		return resize(temp);
	}

	/**
	 * returns all possible values in the order category
	 */
	private static String[] getPossibleOrders() {
		String[] temp = new String[data.length];
		int increment = 0;
		for (int i = 0; i < temp.length; i++) {
			if (!included(temp, data[i].getOrder()))
				temp[increment++] = data[i].getOrder();
		}
		return resize(temp);
	}

	/**
	 * returns all possible values in the suborder category
	 */
	private static String[] getPossibleSuborders() {
		String[] temp = new String[data.length];
		int increment = 0;
		for (int i = 0; i < temp.length; i++) {
			if (!included(temp, data[i].getSuborder()))
				temp[increment++] = data[i].getSuborder();
		}
		return resize(temp);
	}

	/**
	 * returns all possible values in the family category
	 */
	private static String[] getPossibleFamilies() {
		String[] temp = new String[data.length];
		int increment = 0;
		for (int i = 0; i < temp.length; i++) {
			if (!included(temp, data[i].getFamily()))
				temp[increment++] = data[i].getFamily();
		}
		return resize(temp);
	}

	/**
	 * returns all possible values in the genus category
	 */
	private static String[] getPossibleGenera() {
		String[] temp = new String[data.length];
		int increment = 0;
		for (int i = 0; i < temp.length; i++) {
			if (!included(temp, data[i].getGenus()))
				temp[increment++] = data[i].getGenus();
		}
		return resize(temp);
	}

	/**
	 * returns all possible values in the species category
	 */
	private static String[] getPossibleSpecies() {
		String[] temp = new String[data.length];
		int increment = 0;
		for (int i = 0; i < temp.length; i++) {
			if (!included(temp, data[i].getSpecies()))
				temp[increment++] = data[i].getSpecies();
		}
		return resize(temp);
	}

	/**
	 * returns all possible values in the geolPeriod category
	 */
	private static String[] getPossibleGeolPeriods() {
		String[] temp = new String[data.length];
		int increment = 0;
		for (int i = 0; i < temp.length; i++) {
			if (!included(temp, data[i].getGeolPeriod()))
				temp[increment++] = data[i].getGeolPeriod();
		}
		return resize(temp);
	}

	/**
	 * returns all possible values in the geolEpoch category
	 */
	private static String[] getPossibleGeolEpochs() {
		String[] temp = new String[data.length];
		int increment = 0;
		for (int i = 0; i < temp.length; i++) {
			if (!included(temp, data[i].getGeolEpoch()))
				temp[increment++] = data[i].getGeolEpoch();
		}
		return resize(temp);
	}

	/**
	 * returns all possible values in the habitat category
	 */
	private static String[] getPossibleHabitats() {
		String[] temp = new String[data.length];
		int increment = 0;
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < data[i].getHabitat().length; j++) {
				if (!included(temp, data[i].getHabitat()[j]))
					temp[increment++] = data[i].getHabitat()[j];
			}
		}
		return resize(temp);
	}

	/**
	 * returns all possible values in the diet category
	 */
	private static String[] getPossibleDiets() {
		String[] temp = new String[data.length];
		int increment = 0;
		for (int i = 0; i < temp.length; i++) {
			if (!included(temp, data[i].getDiet()))
				temp[increment++] = data[i].getDiet();
		}
		return resize(temp);
	}

	/**
	 * returns all possible values in the egg type category
	 */
	private static String[] getPossibleEggs() {
		String[] temp = new String[data.length];
		int increment = 0;
		for (int i = 0; i < temp.length; i++) {
			if (!included(temp, data[i].getEgg()))
				temp[increment++] = data[i].getEgg();
		}
		return resize(temp);
	}

	/**
	 * returns possible options of a category
	 * 
	 * @param category
	 * @return
	 */
	public static String[] getPossible(String category) {
		String[] temp;
		switch (category.toLowerCase()) {
		case "identifier":
			temp = getPossibleIdentifiers();
			break;
		case "nature":
			temp = getPossibleNatures();
			break;
		case "category":
			temp = getPossibleCategories();
			break;
		case "common name":
			temp = getPossibleCNames();
			break;
		case "kingdom":
			temp = getPossibleKingdoms();
			break;
		case "phylum":
			temp = getPossiblePhylums();
			break;
		case "subphylum":
			temp = getPossibleSubphylums();
			break;
		case "class":
			temp = getPossibleVClasses();
			break;
		case "subclass":
			temp = getPossibleSubclasses();
			break;
		case "order":
			temp = getPossibleOrders();
			break;
		case "suborder":
			temp = getPossibleSuborders();
			break;
		case "family":
			temp = getPossibleFamilies();
			break;
		case "genus":
			temp = getPossibleGenera();
			break;
		case "species":
			temp = getPossibleSpecies();
			break;
		case "geolperiod":
			temp = getPossibleGeolPeriods();
			break;
		case "geolepoch":
			temp = getPossibleGeolEpochs();
			break;
		case "habitat":
			temp = getPossibleHabitats();
			break;
		case "diet":
			temp = getPossibleDiets();
			break;
		case "egg type":
			temp = getPossibleEggs();
			break;
		default:
			temp = null;
			break;
		}
		return temp;
	}

}
