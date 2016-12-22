package lyapaside;

public class SpacesFormatter implements Formatter {
	
	//вычисление длины макс. длинного параграфа
	public int MaxLengthOfParagraph(String str) {
		
		int i = 0, max = 0;
		while(i != -1)
		{
			i = str.indexOf('§', i);
			int a = i;
			while(str.charAt(i) < '9' && str.charAt(i) > '0')
				i++;
			if(i-a > max) max = i-a;
		}
		return max;
	}
	
	public String DeleteSpacesAfterLineBreak(String str){
		
		str.replaceAll("\n\\s+", "\n");
		return str;
	}
	
	//нужно еще сделать 'каждый параграф на новой строке' и засунуть в начало этого метода
	public String FormatIndents(String str) {
		
		int max = this.MaxLengthOfParagraph(str);
		String SpaceString = "";
		int j = 0;
		while(j < max+2)
			SpaceString += " ";
			
		this.DeleteSpacesAfterLineBreak(str);
		
		int i = 0;
		while(i != -1)
		{
			i = str.indexOf('\n', i);
			if(str.charAt(i+1) == '§')
			{
				//??
			}
			else
			{
				str = str.substring(0, i) + SpaceString + str.substring(i+1);   // i или i+1 ??? 
			}
		}
		
		return str;
	}

	@Override
	public String Format(String str) {
		// TODO Auto-generated method stub
		return null;
	}
}
