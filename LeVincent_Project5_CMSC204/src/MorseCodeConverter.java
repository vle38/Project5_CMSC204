import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MorseCodeConverter {

	// MorseCodeTree object tree initialized as a new MorseCodeTree object
	public static MorseCodeTree tree = new MorseCodeTree();
	
	
	// convertCodeToEnglish method which allows morse code to be converted to its alphabetic letter equivalent. 
	public static String convertCodeToEnglish(String code) {
		
		// StringBuidler object englishConversion is initialized as a StringBuilder object to form string values when converting from morse code into alphabetic letters.
		StringBuilder englishConversion = new StringBuilder();
		
		// String array called words which contains all morse code, each letter divided by a "/". 
		String[] words = code.trim().split(" / ");
		
		// For loop which increments through the entire length of words array
		for(int i = 0; i < words.length; i++) {
			
			// String array letters which gathers the items all from the words array, divides each morse code representing a letter with a space.
			String[] letters = words[i].trim().split(" ");
			
			// For loop which increments through all morse code letters within the letters array
			for(String morseCodeLetter : letters) {
				// englishConversion.append(tree.fetch(morseCodeLetter));
				
				// If statement which checks if there is no space by checking if the morse code letter variable equals() method being executed equates to false
				if(morseCodeLetter.equals("") == false) {
					// If the if statement is proven true (indicating that equals() is false, then the englishConversion StringBuilder object appends the morse code letter into the tree.
					englishConversion.append(tree.fetch(morseCodeLetter));
				}
			}
			
			// If statement which checks if the current index of the words array is less than the final index of the words array
			if(i < words.length - 1) {
				
				// If true, a space will be appended into the englishConversion StringBuilder object.
				englishConversion.append(" ");
				
			}
			
			
		}
		
		// The method then returns the StringBuilder object as one whole string by utilizing the toString method.
		return englishConversion.toString();
		
	}
	
	
	
	// convetCodeToEnglish method which opens a file to access text files and convert morse code to english alphabetic letters.
	public static String convertCodeToEnglish(File file) throws FileNotFoundException {
		
		// Scanner object canner which scans the text file of its contents
		Scanner scanner = new Scanner(file);
		
		// StringBuilder morseCode which will contain the morse code from the text file
		StringBuilder morseCode = new StringBuilder();
		
		/*
		do {
			code.append(scanner.nextLine()).append("\n");
		}
		while(scanner.hasNextLine() == true);
		*/
		
		
		// While loop which check if the scanner does have the ability to check the next line through hasNextLine().
		while(scanner.hasNextLine() == true) {
			
			// If true, the scanner then appends the morse code into the morseCode StringBuilder object and creates a new line for every morse code letter
			morseCode.append(scanner.nextLine()).append("\n");
			
		}
		
		// The method then returns the execution of the method, combining all elements from the morseCode StringBuilder object as one whole string through toString
		return convertCodeToEnglish(morseCode.toString().trim());
		
	}
	
	
	// printTree method which prints the tree
	public static String printTree() {
		
		// ArrayList object list which is initialized with the tree converted into an arrayList through toArrayList.
		ArrayList<String> list = tree.toArrayList();
		
		// Method returns everything in list as a string by concatenating everything under a string value.
		return String.join(" ", list);
		
	}
	
	
	
	
}
