package hust.soict.dsai.garbage;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class GarbageCreator {
	public static void main(String[] args) throws IOException  {
		String fileName = "IMG_20201006_191353.jpg";
		byte[] inputByte = {0};
		long startTime = System.currentTimeMillis();
		inputByte = Files.readAllBytes(Paths.get(fileName));
		long endTime = System.currentTimeMillis();
		System.out.println("Time to read file: " + (endTime - startTime) + "ms");	


		
	}

}
