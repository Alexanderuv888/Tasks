import java.util.Arrays;
import java.util.stream.Collectors;

public class IntToXlsConverter {
    static final char[] MASK = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    public static StringBuilder convert(StringBuilder sb, int val) {
        if (val<=0 || sb == null) {
            return sb;
        }
        if (val <= MASK.length) {
            return sb.append(MASK[val-1]);
        }
        int whole = val/MASK.length;
        int reminder = val % MASK.length;
        return convert(sb, whole)
                .append(MASK[reminder-1]);
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
