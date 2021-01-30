import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HighScoreSaver {
	static String filePath = "src/HighScore.dat";
	public static int getScore () {
		int score = -1;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            score = Integer.parseInt(reader.readLine());
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return score;

	}
	public static void saveScore(int score) {
		try {
			FileWriter writer = new FileWriter (filePath, false);
			writer.write("" + score);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
