package lyapaside;

public class FormatterExample implements Formatter {

	@Override
	public String Format(String str) {
		return str.replaceAll("\n\\s+", "\n");
	}

}
