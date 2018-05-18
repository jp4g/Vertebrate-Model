package vert.backend;

/**
 * Node for a single vertebrate, holds data on vertebrate s
 * 
 * @author Jack Gilcrest
 *
 */
public class VNode {
	// String characteristics of organism
	private String identifier;
	private String nature;
	private String category;
	private String cName;
	private String kingdom;
	private String phylum;
	private String subphylum;
	private String vClass;
	private String subclass;
	private String order;
	private String suborder;
	private String family;
	private String genus;
	private String species;
	private String geolPeriod;
	private String geolEpoch;
	// existence range, in million years ago (MYA)
	private double ageStart;
	private double ageEnd;
	private String ageRange;
	// organism size, in centimeters (cm). sizeMin will be value if no range
	private double sizeMin;
	private double sizeMax;
	private String sizeRange;
	// array of habitats, at least 1 entry
	private String[] habitat;
	private String habitatString;
	private String diet;
	private String egg;
	private String citation;
	// url of the image to be displayed in the program (NOT IMPLEMENTED)
	private String url;
	// number of variables that have been initialized
	private int initializeIndex;

	/**
	 * constructor for an instance of a VNode
	 */
	public VNode() {
		initializeIndex = 0;
	}

	/**
	 * @return the identifier
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * @param identifier the identifier to set
	 */
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	/**
	 * @return the nature
	 */
	public String getNature() {
		return nature;
	}

	/**
	 * @param nature the nature to set
	 */
	public void setNature(String nature) {
		this.nature = nature;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the cName
	 */
	public String getCName() {
		return cName;
	}

	/**
	 * @param cName the cName to set
	 */
	public void setcName(String cName) {
		this.cName = cName;
	}

	/**
	 * @return the kingdom
	 */
	public String getKingdom() {
		return kingdom;
	}

	/**
	 * @param kingdom the kingdom to set
	 */
	public void setKingdom(String kingdom) {
		this.kingdom = kingdom;
	}

	/**
	 * @return the phylum
	 */
	public String getPhylum() {
		return phylum;
	}

	/**
	 * @param phylum the phylum to set
	 */
	public void setPhylum(String phylum) {
		this.phylum = phylum;
	}

	/**
	 * @return the vClass
	 */
	public String getVClass() {
		return vClass;
	}

	/**
	 * @param vClass the vClass to set
	 */
	public void setvClass(String vClass) {
		this.vClass = vClass;
	}

	/**
	 * @return the subclass
	 */
	public String getSubclass() {
		return subclass;
	}

	/**
	 * @param subclass the subclass to set
	 */
	public void setSubclass(String subclass) {
		this.subclass = subclass;
	}

	/**
	 * @return the order
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * @return the suborder
	 */
	public String getSuborder() {
		return suborder;
	}

	/**
	 * @param suborder the suborder to set
	 */
	public void setSuborder(String suborder) {
		this.suborder = suborder;
	}

	/**
	 * @return the family
	 */
	public String getFamily() {
		return family;
	}

	/**
	 * @param family the family to set
	 */
	public void setFamily(String family) {
		this.family = family;
	}

	/**
	 * @return the genus
	 */
	public String getGenus() {
		return genus;
	}

	/**
	 * @param genus the genus to set
	 */
	public void setGenus(String genus) {
		this.genus = genus;
	}

	/**
	 * @return the geolPeriod
	 */
	public String getGeolPeriod() {
		return geolPeriod;
	}

	/**
	 * @param geolPeriod the geolPeriod to set
	 */
	public void setGeolPeriod(String geolPeriod) {
		this.geolPeriod = geolPeriod;
	}

	/**
	 * @return the geolEpoch
	 */
	public String getGeolEpoch() {
		return geolEpoch;
	}

	/**
	 * @param geolEpoch the goelEpoch to set
	 */
	public void setGeolEpoch(String geolEpoch) {
		this.geolEpoch = geolEpoch;
	}

	/**
	 * @return the ageStart
	 */
	public double getAgeStart() {
		return ageStart;
	}

	/**
	 * @param ageStart the ageStart to set
	 */
	public void setAgeStart(String ageStart) {
		double temp;
		try {
			temp = Double.parseDouble(ageStart);
		} catch (NumberFormatException e) {
			temp = -1;
		}
		this.ageStart = temp;
	}

	/**
	 * @return the ageEnd
	 */
	public double getAgeEnd() {
		return ageEnd;
	}

	/**
	 * @param ageEnd the ageEnd to set
	 */
	public void setAgeEnd(String ageEnd) {
		double temp;
		try {
			temp = Double.parseDouble(ageEnd);
		} catch (NumberFormatException e) {
			temp = -1;
		}
		this.ageEnd = temp;
	}

	/**
	 * @return the habitat
	 */
	public String[] getHabitat() {
		return habitat;
	}

	/**
	 * @param habitat the habitat to set
	 */
	public void setHabitat(String habitat) {
		int count = 1;
		for (int i = 0; i < habitat.length(); i++) {
			if (habitat.substring(i, i + 1).equals("."))
				count++;
		}
		String[] temp = new String[count];
		String tempEntry = "";
		int index = 0;
		for (int i = 0; i < habitat.length(); i++) {
			if (!habitat.substring(i, i + 1).equals("."))
				tempEntry += habitat.substring(i, i + 1);
			else {
				temp[index] = tempEntry;
				tempEntry = "";
				index++;
			}
		}
		temp[index] = tempEntry;
		this.habitat = temp;
	}

	/**
	 * @return the diet
	 */
	public String getDiet() {
		return diet;
	}

	/**
	 * @param diet the diet to set
	 */
	public void setDiet(String diet) {
		this.diet = diet;
	}

	/**
	 * @return the egg
	 */
	public String getEgg() {
		return egg;
	}

	/**
	 * @param egg the egg to set
	 */
	public void setEgg(String egg) {
		this.egg = egg;
	}

	/**
	 * @return the citation
	 */
	public String getCitation() {
		return citation;
	}

	/**
	 * @param citation the citation to set
	 */
	public void setCitation(String citation) {
		this.citation = citation;
	}

	/**
	 * @return the sizeMin
	 */
	public double getSizeMin() {
		return sizeMin;
	}

	/**
	 * @param sizeMin the sizeMin to set
	 */
	public void setSizeMin(String sizeMin) {
		double temp;
		try {
			temp = Double.parseDouble(sizeMin);
		} catch (NumberFormatException e) {
			temp = -1;
		}
		this.sizeMin = temp;
	}

	/**
	 * @return the sizeMax
	 */
	public double getSizeMax() {
		return sizeMax;
	}

	/**
	 * @param sizeMax the sizeMax to set
	 */
	public void setSizeMax(String sizeMax) {
		double temp;
		try {
			temp = Double.parseDouble(sizeMax);
		} catch (NumberFormatException e) {
			temp = -1;
		}
		this.sizeMax = temp;
	}

	/**
	 * @return the url of the image
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url of the image to set
	 */
	public void setImageURL(String url) {
		this.url = url;
	}

	/**
	 * increases the value of initializeIndex by 1
	 */
	public void incrementInitializeIndex() {
		initializeIndex++;
	}

	/**
	 * @return the value of initializeIndex
	 */
	public int getInitializeIndex() {
		return initializeIndex;
	}

	/**
	 * @return the subphylum
	 */
	public String getSubphylum() {
		return subphylum;
	}

	/**
	 * @param subphylum the subphylum to set
	 */
	public void setSubphylum(String subphylum) {
		this.subphylum = subphylum;
	}

	/**
	 * @return the species
	 */
	public String getSpecies() {
		return species;
	}

	/**
	 * @param species the species to set
	 */
	public void setSpecies(String species) {
		this.species = species;
	}

	public String getHabitatString() {
		String temp = "";
		for (int i = 0; i < habitat.length; i++)
			temp += habitat[i] + ",";
		return temp.substring(0, temp.length() - 1);
	}

	// public String getHabit

	/**
	 * prints all data
	 */
	public void print() {
		System.out.println("Identifier: " + identifier);
		System.out.println("Nature: " + nature);
		System.out.println("Category: " + category);
		System.out.println("Common Name: " + cName);
		System.out.println("Kingdom: " + kingdom);
		System.out.println("Phylum: " + phylum);
		System.out.println("Subphylum: " + subphylum);
		System.out.println("Class: " + vClass);
		System.out.println("Subclass: " + subclass);
		System.out.println("Order: " + order);
		System.out.println("Suborder: " + suborder);
		System.out.println("Family: " + family);
		System.out.println("Genus: " + genus);
		System.out.println("Species: " + species);
		System.out.println("GeolPeriod: " + geolPeriod);
		System.out.println("GeolEpoch: " + geolEpoch);
		System.out.println("Start of Existence: " + ageStart);
		System.out.println("End of Existence: " + ageEnd);
		System.out.println("Minimum Size: " + sizeMin);
		System.out.println("Maximum Size: " + sizeMax);
		System.out.println("Habitats: " + getHabitatString());
		System.out.println("Diet: " + diet);
		System.out.println("Egg Type: " + egg);
		System.out.println("Citation: " + citation);
	}

	/**
	 * sets string variables for non-string fields
	 */
	public void setStrings() {
		ageRange = String.valueOf(ageStart) + "- " + String.valueOf(ageEnd) + " MYA";
		if (sizeMax > 0)
			sizeRange = String.valueOf(sizeMin) + "- " + String.valueOf(sizeMax) + " cm";
		else
			sizeRange = String.valueOf(sizeMin) + " cm";
		habitatString = getHabitatString();
	}

	/**
	 * Returns the proper name of the vertebrate
	 */
	public String getName() {
		String name = "";
		if (!genus.equals("NA"))
			name += genus;
		if (!species.equals("NA")) {
			if (!name.equals(""))
				name += " ";
			name += species;
		}
		if (name == "") {
			if (!family.equals("NA"))
				name = family;
			else if (!suborder.equals("NA"))
				name = suborder;
			else if (!order.equals("NA"))
				name = order;
			else if (!subclass.equals("NA"))
				name = subclass;
			else if (!vClass.equals("NA"))
				name = vClass;
		}
		return name.toLowerCase();
	}

}
