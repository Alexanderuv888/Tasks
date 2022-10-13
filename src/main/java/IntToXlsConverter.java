import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Конвертер преобразует целые положительные числа в наименования столбцов таблицы xls документа.
 * 1-1 вариант преобразования. В качестве хранилища букв используется обычный массив,
 * что обеспечивает лучшую скорость при польших кол-вах преобразований.
 * 2-й вариант преобразования. В качестве хранилища используется enum. Этот вариант работает медленней,
 * но расширяет функциональность хранилища.
 */
public class IntToXlsConverter {
    static final char[] MASK = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    public static StringBuilder convertUsingEnum(StringBuilder sb, int val) {
        if (val<=0 || sb == null) {
            return sb;
        }
        if (val <= Letters.length()) {
            return sb.append(Letters.getLetter(val));
        }
        int whole = val/Letters.length();
        int reminder = val % Letters.length();
        return convertUsingEnum(sb, whole)
                .append(Letters.getLetter(reminder));
    }

    public static StringBuilder convertUsingMassive(StringBuilder sb, int val) {
        if (val<=0 || sb == null) {
            return sb;
        }
        if (val <= MASK.length) {
            return sb.append(MASK[val-1]);
        }
        int whole = val/MASK.length;
        int reminder = val % MASK.length;
        return convertUsingMassive(sb, whole)
                .append(MASK[reminder-1]);
    }

    public static String getColNameUsingEnum(int... vals) {
        return Arrays.stream(vals).mapToObj(v ->
                convertUsingEnum(new StringBuilder()
                        .append(v)
                        .append(":"), v)
                        .append('\n')
                        .toString()
        ).collect(Collectors.joining());
    }

    public static String getColNameUsingMassive(int... vals) {
        return Arrays.stream(vals).mapToObj(v ->
                convertUsingMassive(new StringBuilder()
                        .append(v)
                        .append(":"), v)
                        .append('\n')
                        .toString()
        ).collect(Collectors.joining());
    }

}
