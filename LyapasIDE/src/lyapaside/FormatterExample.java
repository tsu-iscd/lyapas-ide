package lyapaside;

// пример форматера

public class FormatterExample implements Formatter {

	@Override
	public String Format(String str) {
		str.replaceAll("\n\\s+", "\n");
		return str;
	}

}
