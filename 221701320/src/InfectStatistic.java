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
	public static String[] province= {"北京","天津","上海","重庆","河北","山西","辽宁",
						"吉林","黑龙江","江苏","浙江","安徽","福建","江西",
						"山东","河南","湖北","湖南","广东","海南","四川",
						"贵州","云南","陕西","甘肃","青海","台湾","内蒙古",
						"广西","西藏","宁夏","新疆","香港","澳门"};
	public static int[] ip= {0,0,0,0,0,0,0,
			   0,0,0,0,0,0,0,
			   0,0,0,0,0,0,0,
			   0,0,0,0,0,0,0,
			   0,0,0,0,0,0};
	public static int[] sp= {0,0,0,0,0,0,0,
			   0,0,0,0,0,0,0,
			   0,0,0,0,0,0,0,
			   0,0,0,0,0,0,0,
			   0,0,0,0,0,0};
	public static int[] cp= {0,0,0,0,0,0,0,
			   0,0,0,0,0,0,0,
			   0,0,0,0,0,0,0,
			   0,0,0,0,0,0,0,
			   0,0,0,0,0,0};
	public static int[] dp= {0,0,0,0,0,0,0,
			   0,0,0,0,0,0,0,
			   0,0,0,0,0,0,0,
			   0,0,0,0,0,0,0,
			   0,0,0,0,0,0};
	
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
				readfile2(str);
			}
		}catch (IOException e) {
        }
		
	}
	
	public static void readfile2(String str) {
		String[] a=str.split(" ");
		int m=0;
		for(int i=0;i<34;i++) {
			if(province[i].equals(a[0])) {
				m=i;break;
			}
		}
		if(a.length==3) {
			if(a[1].equals("死亡")) {
				if(a[2].length()==3) {
					dp[m]+=(10*(Integer.parseInt(a[2].subSequence(0, 1).toString()))+Integer.parseInt(a[2].subSequence(1, 2).toString()));
					ip[m]-=(10*(Integer.parseInt(a[2].subSequence(0, 1).toString()))+Integer.parseInt(a[2].subSequence(1, 2).toString()));
				}
				else {
					dp[m]+=(Integer.parseInt(a[2].subSequence(0, 1).toString()));
					ip[m]-=(Integer.parseInt(a[2].subSequence(0, 1).toString()));
				}
			}
			if(a[1].equals("治愈")) {
				if(a[2].length()==3) {
					cp[m]+=(10*(Integer.parseInt(a[2].subSequence(0, 1).toString()))+Integer.parseInt(a[2].subSequence(1, 2).toString()));
					ip[m]-=(10*(Integer.parseInt(a[2].subSequence(0, 1).toString()))+Integer.parseInt(a[2].subSequence(1, 2).toString()));
				}
				else {
					cp[m]+=(Integer.parseInt(a[2].subSequence(0, 1).toString()));
					ip[m]-=(Integer.parseInt(a[2].subSequence(0, 1).toString()));
				}
			}
		}
		if(a.length==5) {
			int n=0;
			if(a[1].equals("感染患者")) {
				for(int i=0;i<34;i++) {
					if(province[i].equals(a[3])) {
						n=i;break;
					}
				}
				if(a[4].length()==3) {
					ip[m]-=(10*(Integer.parseInt(a[4].subSequence(0, 1).toString()))+Integer.parseInt(a[4].subSequence(1, 2).toString()));
					ip[n]+=(10*(Integer.parseInt(a[4].subSequence(0, 1).toString()))+Integer.parseInt(a[4].subSequence(1, 2).toString()));
				}
				else {
					ip[m]-=(Integer.parseInt(a[4].subSequence(0, 1).toString()));
					ip[n]+=(Integer.parseInt(a[4].subSequence(0, 1).toString()));
				}
			}
			if(a[1].equals("疑似患者")) {
				for(int i=0;i<34;i++) {
					if(province[i].equals(a[3])) {
						n=i;break;
					}
				}
				if(a[4].length()==3) {
					sp[m]-=(10*(Integer.parseInt(a[4].subSequence(0, 1).toString()))+Integer.parseInt(a[4].subSequence(1, 2).toString()));
					sp[n]+=(10*(Integer.parseInt(a[4].subSequence(0, 1).toString()))+Integer.parseInt(a[4].subSequence(1, 2).toString()));
				}
				else {
					sp[m]-=(Integer.parseInt(a[4].subSequence(0, 1).toString()));
					sp[n]+=(Integer.parseInt(a[4].subSequence(0, 1).toString()));
				}
			}
		}
		if(a.length==4) {
			if(a[1].equals("新增")&&a[2].equals("感染患者")) {
				if(a[3].length()==3) {
					ip[m]+=(10*(Integer.parseInt(a[3].subSequence(0, 1).toString()))+Integer.parseInt(a[3].subSequence(1, 2).toString()));
				}
				else {
					ip[m]+=(Integer.parseInt(a[3].subSequence(0, 1).toString()));
				}
			}
			if(a[1].equals("新增")&&a[2].equals("疑似患者")) {
				if(a[3].length()==3) {
					sp[m]+=(10*(Integer.parseInt(a[3].subSequence(0, 1).toString()))+Integer.parseInt(a[3].subSequence(1, 2).toString()));
				}
				else {
					sp[m]+=(Integer.parseInt(a[3].subSequence(0, 1).toString()));
				}
			}
			if(a[2].equals("确诊感染")) {
				if(a[3].length()==3) {
					ip[m]+=(10*(Integer.parseInt(a[3].subSequence(0, 1).toString()))+Integer.parseInt(a[3].subSequence(1, 2).toString()));
					sp[m]-=(10*(Integer.parseInt(a[3].subSequence(0, 1).toString()))+Integer.parseInt(a[3].subSequence(1, 2).toString()));
				}
				else {
					ip[m]+=(Integer.parseInt(a[3].subSequence(0, 1).toString()));
					sp[m]-=(Integer.parseInt(a[3].subSequence(0, 1).toString()));
				}
			}
			if(a[1].equals("排除")) {
				if(a[3].length()==3) {
					sp[m]-=(10*(Integer.parseInt(a[3].subSequence(0, 1).toString()))+Integer.parseInt(a[3].subSequence(1, 2).toString()));
				}
				else {
					sp[m]-=(Integer.parseInt(a[3].subSequence(0, 1).toString()));
				}
			}
		}
	}
	
	public static void main(String[] args){
		ArrayList<String> listFileName = new ArrayList<String>();
		
		getAllFileName("D:\\log\\",listFileName);
		System.out.println(ip[12]);
		System.out.println(sp[12]);
		System.out.println(cp[12]);
		System.out.println(dp[12]);
	}
}
