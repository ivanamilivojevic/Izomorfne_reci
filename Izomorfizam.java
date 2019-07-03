package domaci;

import java.util.HashMap;

public class Izomorfizam {
	
	public static boolean areIsomorphic(String A, String B) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		
		if(A.length() > B.length()) {
			String C = A;
			A = B;
			B = C;
		}
		
		for(int i=0; i<A.length(); i++) {
			if(map.containsKey(A.charAt(i)) && map.get(A.charAt(i)) != B.charAt(i))
				return false;
			map.put(A.charAt(i), B.charAt(i));
		}
		return true;
	}
	
	public static void main(String[] args) {
		// A = "земља", B = "књига" => true // (з:к, е:њ, м:и, љ:г, а:а) 
		// A = "noon", B = "feet" => false // (n:f, o:e, !n:t!)
		// A = "ααβ", B = "γγδ" => true // (α:γ, β:δ)
		String[][] tests = { {"земља","књига"}, {"noon", "feet"}, {"ααβ", "γγδ"} };
		for(String[] test: tests)
			System.out.printf("A = %s, B = %s => %b\n", test[0], test[1], areIsomorphic(test[0], test[1]));
	}

}
