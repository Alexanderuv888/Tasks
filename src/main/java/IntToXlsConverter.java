import java.util.Arrays;
import java.util.stream.Collectors;

public class IntToXlsConverter {
    static final char[] MASK = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    public static String convert(int val) {
        if (val <= MASK.length) {
            return String.valueOf(MASK[val-1]);
        }
        int whole = val/MASK.length;
        int reminder = val % MASK.length;
        return new StringBuilder(convert(whole))
                .append(MASK[reminder-1]).toString();
    }

    public static String getColName(int... vals) {
        return Arrays.stream(vals).mapToObj(v -> new StringBuilder()
                .append(v)
                .append(":")
                .append(convert(v))
                .append('\n')
                .toString()
        ).collect(Collectors.joining());
    }

}
