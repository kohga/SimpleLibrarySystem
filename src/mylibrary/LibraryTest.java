package mylibrary;

import java.util.Map;

import mypub.*;

public class LibraryTest {
	public static void main(String[] args) {
		Library t = new Library();
		ControlFile c = new ControlFile();
		try{
			c.lordFile(t, "log.csv");
			//t.addBook("1234567891234","永遠の0","講談社文庫",2011,"百田 尚樹");
			//t.addBook("1515151515151","ロスジェネの逆襲","ダイヤモンド社",2012,"池井戸 潤");
			//t.addBook("2323232323232","疾風ロンド ","実業之日本社",2000,"東野 圭吾");
			//t.addMagazine("1234567897894","少年ジャンプ","集英社",1999,7,1234);
			//t.addMagazine("7777777777777","BOMB","学研マーケティング",1995,12,1113);
			//t.addMagazine("4564564564564","AneCan","小学館",2013,9,2323);
			for(Map.Entry<String,Publication> entry : t.getMap().entrySet()){
				System.out.println(entry.getKey()+" ⇒"+entry.getValue());
			}
			c.makeFile(t, "after_log.csv");
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}