package com.revature.eval.java.core;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class EvaluationService {

	/**
	 * 1. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		String[] words = phrase.split(" |-"); 
		String result = "";
		for (String s: words) {
			result += s.toUpperCase().charAt(0);
			
		}
		//System.out.println(result);
		return result;
	}

	/**
	 * 2. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration
		char[] charArray = string.toLowerCase().toCharArray();
		int result = 0;
		
		//System.out.println(charArray[0]);
		 for (int i = 0; i < charArray.length; i++) { 
			 //System.out.print(charArray[i]);
			if (charArray[i] == 'a' || charArray[i] == 'e' || 
				charArray[i] == 'i' || charArray[i] == 'o' || 
				charArray[i] == 'u' || charArray[i] == 'l' || 
				charArray[i] == 'n' || charArray[i] == 'r' || 
				charArray[i] == 's' || charArray[i] == 't' ) {
				result += 1;
				//System.out.println(charArray[i]);
			} else if (charArray[i] == 'f' || charArray[i] == 'h' ||
					   charArray[i] == 'v' || charArray[i] == 'w' ||
					   charArray[i] == 'y') {
				result += 4;
			} else if (charArray[i] == 'd' || charArray[i] == 'g') {
				result += 2;
			} else if (charArray[i] == 'b' || charArray[i] == 'c' || 
					   charArray[i] == 'm' ||    charArray[i] == 'p') {
				result += 3;
			} else if (charArray[i] == 'k') {
				result += 5;
			} else if (charArray[i] == 'j' || charArray[i] == 'x') {
				result += 8;
			} else if (charArray[i] == 'q' || charArray[i] == 'z') {
				result += 10;
			} 
		 }
		//System.out.println(result);
		return result;
	}

	/**
	 * 3. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 
	 *    613-995-0253
	 *  1 613 995 0253
	 *    613.995.0253 
	 * should all produce the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		// TODO Write an implementation for this method declaration
		// this will filter all numerical number
		String[] words = string.split("\\D"); 
		String result = "";
		if (string == null || string.isEmpty()) {
			return result;
		}
		// get all the numerical numbers in one (by concatenating) 
		for (String s: words) {
			result += s;
		}
		// throw "IllegalArgumentException" when digit is greater or less than 10
		if (result.length() > 10 || result.length() < 10 ) {
			throw new IllegalArgumentException();
		}		
		return result;
	}

	/**
	 * 4. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" 
	 * Output: olly: 2 in: 1 
	 * 		   come: 1 free: 1
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration
		
		Map<String, Integer> resultWordCount = new HashMap<>();
		if (string == null || string.isEmpty())
			return resultWordCount;
		// splitting words which has empty space, newline character and comma
		String[] words = string.split("\\s|,|\\n"); 
		
		Integer numberWords = new Integer(0);
		// for each loop to iterate through each words
		for (String s: words) {		
			// checks if given word in HashMap is 
			// already exist then increment it's count by 1
			if (!s.equals("")) {
				if (resultWordCount.containsKey(s)) { 
					numberWords = resultWordCount.get(s);
					resultWordCount.put(s, numberWords + 1);
				} else { 
					// if word is not exist then simply put into HashMap and count it's number to 1
					resultWordCount.put(s, 1);
				}
			}
		}
//		for (Map.Entry<String, Integer> entry : resultWordCount.entrySet()) {
//			System.out.println(entry.getKey() + " " + entry.getValue());
//		}
		return resultWordCount;
	}

	/**
	 * 5. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;
		// TODO Write an implementation for this method declaration
		public int indexOf(T t) {
			int lowerIndex = 0;
			int upperIndex = sortedList.size() - 1;
			int middleIndex = (upperIndex + lowerIndex) / 2;
			
			while (lowerIndex <= upperIndex) {
				middleIndex = (upperIndex + lowerIndex) / 2;
				
				if (middleIndex == sortedList.indexOf(t)) {
					//System.out.println(middleIndex);
					return middleIndex;
				} else if (middleIndex < sortedList.indexOf(t)) {
					lowerIndex = middleIndex + 1;
				} else { upperIndex = middleIndex - 1; }
			}
			
//			for (int i = lowerIndex; i < sortedList.size(); i++) {
//				if (sortedList.get(i).equals(t)) {
//					return i;
//				}
//			}
			return middleIndex;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 6. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 
	 * 10 is not an Armstrong number,because 10 != 1^2 + 0^2 = 2 
	 * 153 is an Armstrong number, because: 153 = 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
	 * 154 is not an Armstrong number, because: 154 != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 
	 * Write some code to determine whether a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration
		int digitCount = 0, sum = 0;
		int inputCopy = input;
		// getting the number of digits
		while (inputCopy > 0) {
			inputCopy /= 10;
			digitCount++;
		}
		//System.out.println("digitCount: " + digitCount); 
		inputCopy = input;
		while (inputCopy != 0) {
			int r = inputCopy % 10;
			sum += Math.pow(r, digitCount);
			inputCopy /= 10;
			
		}
		//System.out.println("sum: " + sum);
		return (sum == input); 
	}

	/**
	 * 7. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration
		
		// less than 2 is not prime
		// loop from 2 to n-1
		List<Long> primeFactor = new ArrayList<>();
	
		if (l < 2L) return null;
		long j = 2L;
		while (j <= l) {
			if (l % j == 0) {
				primeFactor.add(j);
				// update 'l' values every time it's divisible by 2L
				l /= j;
			} else j += 1L; // else increment 'j' value by 1L
			//calculatePrimeFactorsOf(l);
		}
		
//		for (int i = 0; i < primeFactor.size(); i++) {
//			System.out.println(primeFactor.get(i));
//		}
		return primeFactor;
	}


	/**
	 * 8-9. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {
		/**
		 * Question 8
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			// TODO Write an implementation for this method declaration
			// Creating a string having reversed alphabetical order 
	        String reverseAlphabet = "zyxwvutsrqponmlkjihgfedcba", reverseString = ""; 
	        String lowerString = string.toLowerCase().replaceAll("\\s|\\.|\\,","");
	     
	        int j = 0;	        
	        for (int i = 0; i < lowerString.length(); i++) {
	        	// to add space after 5th character
	        	if (j == 5) {
	        		j = 0;
	        		reverseString += " ";
	        	}
	        	
	        	if (Character.isDigit(lowerString.charAt(i))) reverseString += lowerString.charAt(i);
	        	else reverseString += reverseAlphabet.charAt(lowerString.charAt(i) - 'a'); 
	        	j++;
	        	
	        }
	        return reverseString; 
		}

		/**
		 * Question 9
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// TODO Write an implementation for this method declaration
			return encode(string).replaceAll(" ", "");
		}
	}

	/**
	 * 10. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		String[] words = string.split(" |\\?"); // this will filter all numerical number

		if (words[3].equals("plus")) {
			return Integer.parseInt(words[2]) + Integer.parseInt(words[4]);
		} else if (words[3].equals("minus")) {
			return Integer.parseInt(words[2]) - Integer.parseInt(words[4]);
		} else if (words[3].equals("multiplied")) {
			return Integer.parseInt(words[2]) * Integer.parseInt(words[5]);
		} else if (words[3].equals("divided")) {
			return Integer.parseInt(words[2]) / Integer.parseInt(words[5]);
		} else return 0;
	}

}
