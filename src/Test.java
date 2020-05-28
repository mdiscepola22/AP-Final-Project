import java.io.File;

public class Test {
public static void main(String[] args) {
	File[] files = new File("./").listFiles();
	for(int i = 0; i<files.length; i++) {
		System.out.println(files[i].getName());
	}

}
}
