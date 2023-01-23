package beans;

/**
 * The class HashMap is an implementation of a hash table, which is a data
 * structure that stores elements in an array, using a function called a "hash
 * function" to map each element to an index in the array. The hash function is
 * used to compute the index of the array where each element should be stored.
 * 
 * The class uses quadratic probing to handle collisions, which means that if
 * two elements are mapped to the same index in the array, the second element
 * will be placed in the next available spot, and so on.
 * 
 * @author Pablo Cuesta Morer
 * @date 2023-01-22
 */
public class HashMap {

	/**
	 * The length of the table.
	 * 
	 * The current number of films is 6. However, they expect their peak volume to
	 * grow to 14 films. So you we can use table size of 14/0.8 = 17.5. The next
	 * prime number closest to that is 19. Using a table size of 19 will ensure that
	 * the table has enough space to store all the districts, even if the maximum
	 * number is reached, and it will also help to reduce the number of collisions.
	 */
	static final int TABLE_LENGTH = 67;
	/** Number of elements in the table */
	private int numElements;
	/** The load factor of the table */
	private double loadFactor;
	/** The array of students */
	private Film[] films;

	/**
	 * Constructs an empty HashMap with a default table length.
	 */
	public HashMap() {
		// initialize the table and its elements to null
		films = new Film[TABLE_LENGTH];
		for (int i = 0; i < TABLE_LENGTH; i++) {
			films[i] = null;
		}
		// initialize attributes to 0
		numElements = 0;
		loadFactor = 0;
	}

	/**
	 * Returns the index position in the table for the given key.
	 * 
	 * @param key to be hashed
	 * @return The index position in the table
	 */
	public int hash(String key) {
		int i = 0, p;
		long d;
		// since the key is a string, it is first converted to an integer value
		d = transformString(key);

		// apply modular arithmetic to get the base address
		p = (int) (d % TABLE_LENGTH);

		// quadratic exploration loop
		while (films[p] != null && !films[p].getId().equals(key)) {
			i++;
			p = p + i * i;
			p = p % TABLE_LENGTH; // consider array as circular
		}
		return p;
	}

	/**
	 * Transforms the given string key into an integer value.
	 * 
	 * @param key to be transformed
	 * @return The transformed integer value
	 */
	private long transformString(String key) {
		// multiplication method to perform the transformation.
		long d = 0;
		for (int j = 0; j < Math.min(10, key.length()); j++) {
			d = d * 29 + (int) key.charAt(j);
		}

		if (d < 0)
			d = -d;
		return d;
	}

	/**
	 * Adds a student to the table.
	 * 
	 * @param r The student to be added
	 */
	public void put(Film r) {
		int position = hash(r.getId());
		films[position] = r;
		numElements++;
		loadFactor = (double) (numElements) / TABLE_LENGTH;
		if (loadFactor > 0.8) {
			System.err.println("\n#### LOAD FACTOR EXCEEDS 80%, it is convenient to increase the size");
		}

	}

	/**
	 * Returns a reference to a student if it is found in the table and returns null
	 * if it is not found or was deactivated.
	 * 
	 * @param key The key of the student to be retrieved
	 * @return The student or null if not found or deactivated
	 */
	public Film get(String key) {
		int position = hash(key);
		Film pr = films[position];
		if (pr != null) {
			if (!pr.isActive()) {
				pr = null;
			}
		}
		return pr;
	}

	/**
	 * Deactivates a student in the table.
	 * 
	 * @param key The key of the student to be deactivated
	 */
	public void remove(String key) {
		int position = hash(key);
		if (films[position] != null) {
			films[position].setActive(false);
		}

	}
}
