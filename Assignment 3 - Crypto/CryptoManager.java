/**
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg 
 * Description: Write methods that encrypt and decrypt String ciphers based on the Caesar and Bellaso Ciphers
 * allows the user to make attempts to guess the randomly generated number.
 * Due: 07/10/2022
 * Platform/compiler: Eclipse Java IDE SE 18
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Zong Qiang Li
*/

public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	// Method determines whether or not the string passed is 
	// within the bounds of encryption - ZLi
	public static boolean stringInBounds (String plainText)
	{
		boolean inBounds = true;
		for(int i = 0; i < plainText.length(); i++)
		{
			if(plainText.charAt(i) < LOWER_BOUND || 
					plainText.charAt(i) > UPPER_BOUND)
				inBounds = false;
		}
		return inBounds;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	// Method converts and returns plainText as an encrypted String based 
	// on the key used through the Caesar Cipher - ZLi
	public static String encryptCaesar(String plainText, int key) 
	{
		int sub; // sub as in "substitution"
		String message = ""; // encrypted string
		// For loop to perform the substitution cipher based on
		// the integer key that specifies the offset of substituting
		// the character
		for(int i = 0; i < plainText.length(); i++)
		{
			// Add key to plainText.charAt(i) and the convert to char
			// to get the substitute character
			sub = (plainText.charAt(i) + key);
			// While sub > UPPER_BOUND, sub - RANGE (64) until sub is within range
			while(sub > UPPER_BOUND)
				sub -= RANGE;
			// Add the newly acquired char to the String message
			message += (char)sub;
		}
		return message;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	// Method converts and returns plainText as an encrypted String based 
	// on the key used through the Bellaso Cipher - ZLi
	public static String encryptBellaso(String plainText, String bellasoStr)
	{
		int sub;
		String message = "";
		for(int i = 0; i < plainText.length(); i++)
		{
			// The key is in bellasoStr, as the characters in that String offset the characters of plainText
			// The substitution would be the original key (plainText.charAt(i) + the bellasoStr.charAt(i))
			// Key given in CryptoManagerTest is "CMSC203", of which its length is less than example String
			// "THIS IS ANOTHER TEST", so the trick is reset the bellasoStr character: i % bellasoStr.length().
			sub = plainText.charAt(i) + bellasoStr.charAt(i % bellasoStr.length());			
			// Correct the range of sub if it is greater than UPPER_BOUND(95)
			while(sub > UPPER_BOUND)
			{
				sub -= RANGE;
			}
			// Add the character to the encrypted String
			message += (char)sub;
		}
		return message;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	// This methods works to decrypt a String of the Caesar cipher, 
	// an inverse of the encryptCaesar method - ZLi 
	public static String decryptCaesar(String encryptedText, int key)
	{
		int sub;
		String message = "";
		for(int i = 0; i < encryptedText.length(); i++)
		{
			// Subtract key from plainText.charAt(i) and the convert to char
			// to get the substitute character
			sub = encryptedText.charAt(i) - key;
			// While sub < LOWER_BOUND, sub + RANGE (64) until sub is within range
			while(sub < LOWER_BOUND)
				sub += RANGE;
			// Add the newly acquired char to the String message
			message += (char)sub;
		}
		return message;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	// This methods works to decrypt a String of the Bellaso cipher, 
	// an inverse of the encryptBellaso method - ZLi 
	public static String decryptBellaso(String encryptedText, String bellasoStr)
	{
		int sub;
		String message = "";
		for(int i = 0; i < encryptedText.length(); i++)
		{
			// Inverse of the encryptBellaso method above
			sub = encryptedText.charAt(i) - bellasoStr.charAt(i % bellasoStr.length());			
			// Correct the range of sub if it is less than UPPER_BOUND(32), "Wrap Around"
			while(sub < LOWER_BOUND)
			{
				sub += RANGE;
			}
			// Add the character to the encrypted String
			message += (char)sub;
		}
		return message;
	}
}
