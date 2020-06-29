package coding;

public class LcsDynamicProgramminBottomsup {
	
	public static String lcs (String i, String j) {
		if(i!="" && j!="") {
			//System.out.println(i);
			//System.out.println(j);
			Character i1 = i.charAt(i.length()-1);
			Character j1 = j.charAt(j.length()-1);
			//System.out.println(i1);
			//System.out.println(j1);
			String newI = "";
			if (i.length() >1) newI = i.substring(0,i.length()-1);
			String newJ = "";
			if (j.length() >1) newJ = j.substring(0,j.length()-1);
			
			if(i1==j1) {
				return lcs(newI, newJ)+Character.toString(i1);
			}else {
				String return1 = lcs(i, newJ);
				String return2 = lcs(newI, j);
				if(return1.length()>return2.length()) return return1;
				else return return2;
			}
		}
		return "";
	}
	public static void main(String[] args) {
		
		System.out.println(lcs("BATD","ABACD"));
	}
}
