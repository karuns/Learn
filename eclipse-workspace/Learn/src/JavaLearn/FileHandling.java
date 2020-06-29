package JavaLearn;
import java.util.*;
import java.io.*;

//https://stackabuse.com/reading-and-writing-files-in-java/
	
public class FileHandling {
	static void ReadUsingBufferedReader(String s) throws Exception {
		BufferedReader bfr = new BufferedReader(new FileReader(s));
		String line = bfr.readLine();
		while(line !=null ) {
			System.out.println(line);
			line = bfr.readLine();
		}
		bfr.close();
	}
	
	static void FileWriteUsingBufferedWriter(String s) throws Exception {
		BufferedWriter bwr = new BufferedWriter(new FileWriter(s, true)); // True is important for append
		//bwr.write();
		//bwr.newLine();
		bwr.append("This is nex Line using BufferedWriter");
		
		bwr.close();
		
	}
	
	static void updateFileUsingBuffered(String fileName, String from, String to) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String s = br.readLine();
		while(s != null) {
			bw.write(s.replace(from, to));
			s = br.readLine();
		}
		br.close();
		bw.close();
	}
	
	public static void main(String[] args) throws Exception {
		//created an object
		File f = new File("a.txt");
		
		
		//create a file
		try {
			f.createNewFile();
			System.out.println(f.getAbsolutePath());
			Scanner sc;
			sc = new Scanner(f);
			while(sc.hasNextLine()) System.out.println(sc.nextLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		//fileReadCharByChar("a.txt");
		//fileWriteCharByChar("a.txt");
		
		ReadUsingBufferedReader("a.txt");
		//FileWriteUsingBufferedWriter("a.txt");
		updateFileUsingBuffered("a.txt", "nex", "next");
	}
	
//	static void fileWriteCharByChar(String s) throws IOException {
//		FileWriter f  = new FileWriter(s);
//
//		f.append("this is File writer", 5,10);
//		f.close();
//	}
//	
//	static void fileReadCharByChar(String s) throws IOException {
//		FileReader f  = new FileReader(s);
//		int ch = f.read();
//		while(ch != -1) {
//			System.out.print((char)ch);
//			ch = f.read();
//		}
//		f.close();
//	}
	

}
