public class Point {

    // TODO
    public int type;
    public Point next;
    public boolean moved;

    public void move() {
        // TODO
        if (this.type == 1 && !this.moved && this.next.type == 0)
        {
            this.type = 0;
            this.next.type = 1;

            this.moved = true;
            this.next.moved = true;
        }
    }

    public void clicked() {
        // TODO
        this.type = 1;
    }

    public void clear() {
        // TODO
        this.type = 0;
    }
}

