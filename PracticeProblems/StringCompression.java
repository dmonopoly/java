import java.lang.StringBuilder;
import java.util.Arrays;

// Write a basic compression function, the function should take a string and replace characters with the number of consecutive identical characters and the character.
// DONE

// For example aabccccdd => 2a1b4c2d
// aab => 2a1b
// abcd => 1a1b1c1d
// aabbaa => 2a2b2a
// 2aa => 122a
public class StringCompression {
	public static void main(String[] args) {
		String given = "aabbbc";
		System.out.println("Given: "+given);
		String ans = compress(given);
		System.out.println("Result: "+ans);

		String given2 = "aaaabcc";
		System.out.println("Given: "+given2);
		String ans2 = compress(given2);
		System.out.println("Result: "+ans2);
	}

	public static String compress(String s) {
		if (s.length() == 0) {
			return "0"; // or null
		} else if (s.length() == 1) {
			return "" + 1 + s.charAt(0);
		} else { // length is >= 2
			StringBuilder b = new StringBuilder();
			int length = s.length();
			int i=0;
			int j=1;
			int count = 1;
			char curr, next;
			boolean done = false;
			while (!done) { // ab
				curr = s.charAt(i);
				next = s.charAt(j);
				while (curr == next) {
					count++;
					j++;
					if (j == length) { 
						done = true; // This ensure situ. where the end is multi-lettered, like abbb
						break;
					}
					next = s.charAt(j);
				}
				b.append(count);
				b.append(curr);
				count = 1;
				i=j;
				j++;
				// In case of a single letter at the end, like the b in aaaab
				if (j == length && s.charAt(i) != curr) {
					b.append(1);
					b.append(s.charAt(i));
					break;
				}
			}
			return b.toString();
		}
	}
}