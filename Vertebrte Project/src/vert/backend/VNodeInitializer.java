package vert.backend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Instantiates all necessary VNodes and can return an array of all VNodes
 * 
 * @author Jack Gilcrest
 */
public class VNodeInitializer {
	private VNode[] vertebrates;
	private int arrayIndex;
	private String url;

	/**
	 * Construcor for VNodeInitializer
	 * 
	 * @param url the url of the file from which data will be taken
	 */
	public VNodeInitializer(String url) {
		this.url = url;
		vertebrates = new VNode[16];
		arrayIndex = 0;
		try {
			initialize();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * initializes VNodes based off of the url passed into the constructor
	 * 
	 * @throws IOException
	 */
	private void initialize() throws IOException {
		BufferedReader br = null;
		String l;
		//File f = new File(url);
		//System.out.println("Attempting to read from file in: "+f.getCanonicalPath());
		try {
			br = new BufferedReader(new FileReader(url));
			l = br.readLine();
			while ((l = br.readLine()) != null)
				addVNode(l);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		standardizeVArray();
	}

	/**
	 * adds a VNode to the vertebrates array
	 * 
	 * @param line the data used to create the VNode
	 */
	private void addVNode(String line) {
		if (arrayIndex == vertebrates.length)
			resizeVArray();
		vertebrates[arrayIndex++] = initializeVNode(line);
	}

	/**
	 * increases the size of the array of VNodes vertebrates by doubling the size.
	 * called when arrayIndex is no longer less than vertebrates.length
	 */
	private void resizeVArray() {
		VNode[] temp = new VNode[arrayIndex * 2];
		for (int i = 0; i < vertebrates.length; i++)
			temp[i] = vertebrates[i];
		vertebrates = temp;
	}

	/**
	 * Sizes the array to the number of entries
	 */
	private void standardizeVArray() {
		VNode[] temp = new VNode[arrayIndex];
		for(int i = 0; i < temp.length; i++)
			temp[i] = vertebrates[i];
		vertebrates = temp;
	}
	
	/**
	 * @param line data read from the file in a single line string. Values are
	 *            separated by ";", missing values are denoted as "NA" in the text
	 *            file.
	 */
	private VNode initializeVNode(String line) {
		String tempData;
		VNode vTemp = new VNode();
		while (!line.equals("")) {
			tempData = getFromSemicolon(line);
			line = disjoinFromSemicolon(line);
			initializeNext(vTemp, tempData);
		}
		vTemp.setStrings();
		vTemp.print();
		return vTemp;
	}

	/**
	 * removes all characters before a semicolon, including the semicolon, in a
	 * string
	 * 
	 * @param line the String to be edited
	 * @return the abbreviated String; returns the full string in absence of a
	 *         semicolon
	 */
	private String disjoinFromSemicolon(String line) {
		if (line.indexOf(";") == 0)
			return line;
		else
			return line.substring(line.indexOf(";") + 1);
	}

	/**
	 * copies all characters before a semicolon, not including the semicolon, in a
	 * string
	 * 
	 * @param line the String from which characters are copied
	 * @return all characters before the first semicolon; returns null in absence of
	 *         a semicolon
	 */
	private String getFromSemicolon(String line) {
		if (line.indexOf(";") == 0)
			return null;
		else
			return line.substring(0, line.indexOf(";"));
	}

	/**
	 * Initializes the next uninitialized variable in a VNode
	 * 
	 * @param node the VNode being initialized
	 * @param data the data to be passed into the VNode
	 */
	private void initializeNext(VNode node, String data) {
		int index = node.getInitializeIndex();
		switch (index) {
		case 0:
			node.setIdentifier(data);
			break;
		case 1:
			node.setNature(data);
			break;
		case 2:
			node.setCategory(data);
			break;
		case 3:
			node.setcName(data);
			break;
		case 4:
			node.setKingdom(data);
			break;
		case 5:
			node.setPhylum(data);
			break;
		case 6:
			node.setSubphylum(data);
		case 7:
			node.setvClass(data);
			break;
		case 8:
			node.setSubclass(data);
			break;
		case 9:
			node.setOrder(data);
			break;
		case 10:
			node.setSuborder(data);
			break;
		case 11:
			node.setFamily(data);
			break;
		case 12:
			node.setGenus(data);
			break;
		case 13:
			node.setSpecies(data);
		case 14:
			node.setGeolPeriod(data);
			break;
		case 15:
			node.setGeolEpoch(data);
			break;
		case 16:
			node.setAgeStart(data);
			break;
		case 17:
			node.setAgeEnd(data);
			break;
		case 18:
			node.setSizeMin(data);
			break;
		case 19:
			node.setSizeMax(data);
			break;
		case 20:
			node.setHabitat(data);
			break;
		case 21:
			node.setDiet(data);
			break;
		case 22:
			node.setEgg(data);
			break;
		case 23:
			node.setCitation(data);
			break;
		case 24:
			node.setImageURL(data);
			break;
		}
		node.incrementInitializeIndex();
	}

	public VNode[] getVArray() {
		return vertebrates;
	}
}
