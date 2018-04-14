package test;
/*
 * 
allIsNotNull 接收 N(1<=N) 个 String 类型参数，返回是否都不为 null
allIsNotEmpty 接收 N(1<=N) 个 String 类型参数，返回是否都不为 null 且都不为空串 ""
 */
public class String_arg_not_null {
	public static boolean allIsNotNull(String...S) {
		try {
			for(int i = 0;i<S.length;i++) {
				if(S[i].equals(null)) {
					return false;
				}
			}
		}catch(NullPointerException e){
			return false;
		}
			
		return true;
	}
	public static boolean allIsNotEmpty(String...S) {
		try {
			for(int i = 0;i<S.length;i++) {
				if(S[i].equals(null)||S[i].equals("")) {
					return false;
				}
			}	
		}catch(NullPointerException e) {
			return false;
		}
		
		return true;
	}
	public static void main(String[] args) {
		boolean a = allIsNotNull("sas","sasss","");
		boolean b = allIsNotEmpty("sas","sasss");
		System.out.println(a);
		System.out.println(b);
	}
}
