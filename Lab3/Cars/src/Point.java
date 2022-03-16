import java.util.Random;

public class Point {

    // TODO
    public int type;
    public Point next;
    public boolean moved;

    public int velocity;
    public int p = 25;

    public void move() {
        // TODO
        Point temp = this;

        for (int i = 0; i < this.velocity; i++) {
            temp = temp.next;
        }

        if (this.type == 1 && !this.moved && temp.type == 0)
        {
            this.type = 0;
            temp.type = 1;

            this.moved = true;
            temp.moved = true;

            this.velocity = 0;
            temp.velocity = this.velocity;
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

    public void acceleration() {
        if (this.velocity < 5) {
            this.velocity++;
        }
    }

    public void slowing(int slow) {
        this.velocity = slow;
    }

    public void randomization() {
        if (this.velocity > 0) {
            Random rand = new Random();
            int random = rand.nextInt(100);
            if (random < p) {
                this.velocity--;
            }
        }
    }
}

