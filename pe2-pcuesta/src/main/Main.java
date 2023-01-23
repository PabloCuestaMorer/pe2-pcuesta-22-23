package main;

import beans.Film;
import beans.HashMap;
import beans.QuickSort;
import beans.QuickSortV2;

/**
 * 
 * @author Pablo Cuesta Morer
 * @date 2023-01-24
 */
public class Main {

	public static void main(String[] args) {

		/*
		 * The current number of films is 6. However, they expect their peak volume to
		 * grow to 14 films. So you we can use table size of 14/0.8 = 17.5. The next
		 * prime number closest to that is 19. Using a table size of 19 will ensure that
		 * the table has enough space to store all the districts, even if the maximum
		 * number is reached, and it will also help to reduce the number of collisions.
		 */

		// Create a HashMap to store the Film objects
		HashMap hashMap = new HashMap();
		// Create Film objects
		Film film1 = new Film("SW15661", "Por un puñado de dolares", 101, 7.6);
		Film film2 = new Film("SW44226", "La muerte tenía un precio", 132, 8.1);
		Film film3 = new Film("SW95678", "El bueno el feo y el malo", 162, 8.2);
		Film film4 = new Film("FP11773", "Harry el sucio", 102, 7.2);
		Film film5 = new Film("WF567773", "Los puentes de Madison", 134, 7.5);
		Film film6 = new Film("WF41553", "Cartas de Iwo Jima", 141, 7.5);
		Film film7 = new Film("DR12984", "Gran Torino", 116, 8.1);
		// Add the Film objects to the HashMap
		hashMap.put(film1);
		hashMap.put(film2);
		hashMap.put(film3);
		hashMap.put(film4);
		hashMap.put(film5);
		hashMap.put(film6);
		hashMap.put(film7);
		// Create an array of Films
		Film[] films = { film1, film2, film3, film4, film5, film6, film7 };
		// Sort the array of Films ASC
		QuickSortV2<Film> quickSort = new QuickSortV2<>();
		long startTime = System.nanoTime();
		quickSort.sort(films, 0, films.length - 1, Film.BY_RATING_DURATION);
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		// Iterate through the sorted array of Films and print out information
		for (int i = 0; i < films.length; i++) {
			Film film = films[i];
			String isAward = i == 0 ? "Y" : "N";
			// If is the last one and exceeds the threshold
			System.out.println("(" + film.getId() + ") " + film.getTitle() + ": valoración [" + film.getRating()
					+ "], duracion [" + film.getDuration() + "], premio Rex Film [" + isAward + "]");
		}
		System.out.println();
		System.out.println("Sorting time: " + totalTime / 1000000.0 + " miliseconds");
	}

}
