
import java.util.Arrays;
import java.util.Optional;

/**
 * Реализовал енум для универсальности, вдруг Microsoft решит переделать наименования столбцов в таблицах, будет проще исправлять=)
 * Скорость доступа будет O(n), но зато его можно будет использовать где нибудь еще.
 */
public enum Letters {
    A(1,'A'),
    B(2,'B'),
    C(3,'C'),
    D(4,'D'),
    E(5,'E'),
    F(6,'F'),
    G(7,'G'),
    H(8,'H'),
    I(9,'I'),
    J(10,'J'),
    K(11,'K'),
    L(12,'L'),
    M(13,'M'),
    N(14,'N'),
    O(15,'O'),
    P(16,'P'),
    Q(17,'Q'),
    R(18,'R'),
    S(19,'S'),
    T(20,'T'),
    U(21,'U'),
    V(22,'V'),
    W(23,'W'),
    X(24,'X'),
    Y(25,'Y'),
    Z(26,'Z');

    final char c;
    final int v;
    Letters(int v, char c) {
        this.v = v;
        this.c = c;
    }

    public static String getLetter(int v) {
        Optional<Letters> optional = Arrays.stream(values()).filter(l -> l.v == v).findFirst();
        return optional.map(letters -> String.valueOf(letters.c)).orElse("");
    }

    @Override
    public String toString() {
        return String.valueOf(c);
    }

    public static int length() {
        return values().length;
    }
}
