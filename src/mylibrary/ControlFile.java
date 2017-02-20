package mylibrary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import mypub.Publication;

public class ControlFile {
	protected String targetfile;
	protected String sourcefile;

	public void makeFile(Library t,String targetfile) {
		this.targetfile = targetfile;
		try {
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(this.targetfile)));
			for(Map.Entry<String,Publication> entry : t.getMap().entrySet()) {
				writer.println(entry.getValue().csvString());
			}
			writer.close();
			System.out.println(targetfile + " のファイルの書き込みに成功しました。");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void lordFile(Library t,String sourcefile) {
		this.sourcefile = sourcefile;
		try {
			@SuppressWarnings("resource")
			BufferedReader reader =	new BufferedReader(new FileReader(this.sourcefile));
			String line;
			while((line=reader.readLine()) != null) {
				String[] lineAry = line.split(",");
				if(lineAry.length == 7){
					t.csvAddBook(lineAry[1], lineAry[2], lineAry[3], Integer.parseInt(lineAry[4]),
							lineAry[5], lineAry[6]);
				} else if(lineAry.length == 8) {
					t.csvAddMagazine(lineAry[1], lineAry[2], lineAry[5], Integer.parseInt(lineAry[6]),
							Integer.parseInt(lineAry[6]), Integer.parseInt(lineAry[3]), lineAry[7]);
				} else {
					throw new Exception();
				}
			}
			reader.close();
			System.out.println(sourcefile + " のファイルの読み込みに成功しました.");
		} catch (FileNotFoundException e) {
			System.out.println(sourcefile + " is not found.");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error : 読み込んだファイルの記述が正確ではありません.");
			e.printStackTrace();
		}
	}
}
