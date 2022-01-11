import java.util.Objects;

public class Vector2d {

        public final double x;
        public final double y;

        public Vector2d(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public String toString(){

            return "(" + this.x + "," + this.y + ")";
        }

        @Override
        public boolean equals(Object other){
            if (this == other)
                return true;
            if (!(other instanceof Vector2d))
                return false;
            Vector2d that = (Vector2d) other;

            return that.x == this.x && that.y == this.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.x, this.y);
        }

        public Vector2d add(Vector2d other){
        return new Vector2d(x + other.x, y + other.y);
    }

        public boolean precedes(Vector2d other){
        return this.x <= other.x && this.y <= other.y;
    }

        public boolean follows(Vector2d other){
        return this.x >= other.x && this.y >= other.y;
    }
}
