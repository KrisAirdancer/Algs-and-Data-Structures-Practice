package chapter_1;

/**
 * Implement an algorithm to determine if a String has all unique characters.
 * What if you cannot use additional data structures?
 * 
 * @author Chris Marston
 *
 */

public class IsUnique {

	public static void main(String[] args) {
		
		String testString = "abcd";
		
		System.out.println(isUnique_Attempt_2(testString));

	}

	/**
	 * This solution DOES rely on additional data structures.
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isUnique_Attempt_2(String input) {
		
		int[] tracking = new int[256]; // Length 256 to house extended ASCII from 00 to 255
		
		for (int index = 0; index < input.length() - 1; index++) {
			
			tracking[input.charAt(index)]++; // Increment the count at the index that corresponds to the current character's ASCII value
			
			if (tracking[input.charAt(index)] > 1) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * This solution DOES NOT rely on additional data structures
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isUnique_Attempt_1(String input) {
		
		char currentChar = input.charAt(0); // I'm going to assume the charAt() method is not counted as an additional data structure b/c I know I don't know how to work around this.
		
		for (int index = 0; index < input.length() - 1; index++) {
			
			currentChar = input.charAt(index);
			
			for (int searchIndex = index + 1; searchIndex < input.length() - 1; searchIndex++) {
				
				if (input.charAt(searchIndex) == currentChar) {
					return false;
				}
			}
		}
		return true;
	}
	
}


/*
 ********** ATTEMPT 2 **********
 * RESTATEMENT OF PROBLEM:
 * 
 * SOLUTION IDEA:
 * - This solution DOES use additional data structures
 * - Create a new array of the same length as the number of unique characters in a valid input String.
 * 	- This would require that we know or dictate the characters that constitute as valid.
 * - Loop over the entire array and increment the corresponding index in the tracking array each time
 * we find a letter that corresponds to that index location.
 * 	- We can assign the index place by using the ASCII value of each character. We can use the Extended ASCII
 * set of characters so we don't have to adjust the ASCII value of each found character.
 * 	- Small Optimization: Each time we update a value in the tracking array, check if the value at that index
 * is greater than 1. If it is, we can end our search early and return false.
 * - When we get to the end of the String, search the tracking array for any values of 2 or greater and return
 * false if one is found
 * 
 * FULL SOLUTION DESCRIPTION:
 * 
 * DEFINITIONS OF VARIABLES AND PARAMETERS:
 * 
 * PSEUDO-CODE SOLUTION:
 * - Declare trackingArray
 * - Use for loop to loop over the entire String
 * 	- For each char in the String, get the ASCII value and use that to increment the trackingArray at that index
 * 		- After each update, use an if statement to check if that index place is greater than 2, if true,
 * end search and return false.
 * - After for loop, include return true.
 * 
 */

/*
 ********** ATTEMPT 1 **********
 * RESTATEMENT OF PROBLEM:
 * - Create an algorithm that evaluates a String and returns true if all of the String's characters are unique,
 * the string contains no duplicate characters, and false otherwise.
 * 
 * SOLUTION IDEA:
 * - This solution DOES NOT use additional data structures
 * - Pull each character from the string starting at index = 0 and ending at input.length() - 1,
 * and then looping over the entire array and comparing that character to all others in the String.
 * 	- This will be a slow implementation. Quadratic?
 * 	- Could add an array to hold one copy of each value already found, then check each character against
 * this array before searching the whole String again to ensure that we don't conduct a check on the
 * same character more than once. - still going to be slow though
 * 
 * FULL SOLUTION DESCRIPTION:
 * - Outer for loop loops over the entire String and increments the index.
 * 	- On each loop, the char at the current index is pulled, and stored in a variable (currentChar)
 * 	- COULD ADD DUPLICATE CHECKING ARRAY OPTIMIZATION HERE
 * - Inner for loop will loop over the entire array from index = 0 to index = input.length() - 1
 * 	- if statement is run on each loop that compares the currentChar to the char at the current index.
 * If a match is found, return false.
 * - If the entire array is searched, return true.
 * 
 * DEFINITIONS OF VARIABLES AND PARAMETERS:
 * - int currentChar
 * 
 * PSEUDO-CODE SOLUTION:
 * - Declare and initialize char currentChar = input.charAt();
 * - for loop to manage the whole string
 * 	- for loop to search the whole String for the current char
 * 		- if statement to check for duplicate chars
 * 			- return false statement
 * - return true statement 
 * 
 */


