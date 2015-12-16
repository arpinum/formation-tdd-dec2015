import com.google.common.base.Objects;

public class Position {

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return Objects.equal(x, position.x) &&
                Objects.equal(y, position.y);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(x, y);
    }

    private int x;
    private int y;
}
