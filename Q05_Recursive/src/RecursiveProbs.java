public class RecursiveProbs {
	StringBuilder sb = new StringBuilder();
	int reverseN = 0;
	
	public boolean recursiveContains(char c, String s) {
		if (s.length() == 0)
			return false;
		if (s.charAt(s.length() - 1) == c) 
			return true;
		else return recursiveContains(c, s.substring(0, s.length() - 1));
	}
	
	public boolean recursiveAllCharacterSame(String s) {
		
		if (s.length() == 0)
			return true;
		if (s.charAt(s.length() - 1) != s.charAt(1))
			return false;
		if (s.length() - 1 == 1)
			return true;
		else return recursiveAllCharacterSame(s.substring(0, s.length() - 1));
		
	}
	
	public String recursiveHead(int n, String s) {
		if (s.length() == 0 || s.length() < n || n < 0)
			return "";
		if (n != 0)
			sb.append(s.charAt(reverseN++));
		if (n == 0)
			return sb.toString();
		else return recursiveHead(n - 1, s);
	}

}
