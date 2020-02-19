import java.io.BufferedReader;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * InfectStatistic
 * TODO
 *
 * @author xxx
 * @version xxx
 * @since xxx
 */
class InfectStatistic {
	public class Province{
		String name;
		int ip;//感染患者
		int sp;//疑似患者
		int cp;//治愈患者
		int dp;//死亡患者
	}
	
	public static void getAllFileName(String path,ArrayList<String> listFileName){
		File file = new File(path);
		String [] names = file.list();
		if(names != null){
			String [] completNames = new String[names.length];
			for(int i=0;i<names.length;i++){
					completNames[i]=path+names[i];
			}
			listFileName.addAll(Arrays.asList(completNames));
		}
		for(String fname:listFileName) {
			readfile(fname);
		}
	}
	
	public static void readfile(String file) {
		try {
			BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
			String str="";
			while((str=bReader.readLine())!=null) {
				System.out.println(str);
			}
		}catch (IOException e) {
        }
		
	}
	
	public static void main(String[] args){
		ArrayList<String> listFileName = new ArrayList<String>();
		getAllFileName("D:\\log\\",listFileName);
//		for(String name:listFileName){
//			System.out.println(name);
//		}
//		System.out.println(fujian.name);
	}
}
