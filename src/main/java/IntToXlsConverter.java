import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Конвертер преобразует целые положительные числа в наименования столбцов таблицы xls документа.
 */
public class IntToXlsConverter {

    public static StringBuilder convert(StringBuilder sb, int val) {
        if (val<=0 || sb == null) {
            return sb;
        }
        if (val <= Letters.length()) {
            return sb.append(Letters.getLetter(val));
        }
        int whole = val/Letters.length();
        int reminder = val % Letters.length();
        return convert(sb, whole)
                .append(Letters.getLetter(reminder));
    }

    public static String getColName(int... vals) {
        return Arrays.stream(vals).mapToObj(v ->
                convert(new StringBuilder()
                        .append(v)
                        .append(":"), v)
                        .append('\n')
                        .toString()
        ).collect(Collectors.joining());
    }

}
