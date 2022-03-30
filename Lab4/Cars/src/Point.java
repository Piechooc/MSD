public class Point {

    // TODO
    public int type;
    public Point next;
    public Point prev;
    public Point left = null;
    public Point right = null;
    public boolean moved;

    public int velocity;

    public static Integer[] types = {0, 1, 2, 3, 5};

    public void move() {
        // TODO
        if ((this.type == 1 || this.type == 2 || this.type == 3) && !moved) {
            Point temp = this;

            if (canGoBack()) {
                temp = changeSide(this.right);
            } else if (canOvertake()) {
                temp = changeSide(this.left);
            } else {
                acceleration();
                slowingDown(temp);
            }

            if (temp.velocity == 0){
                temp.moved = true;
                return;
            }

            Point next = temp;
            for (int i = 0; i < temp.velocity; i++)
                next = next.next;

            next.type = temp.type;
            temp.type = 0;

            next.moved = true;
            temp.moved = true;

            next.velocity = temp.velocity;
            temp.velocity = 0;

        }
    }

    public boolean canOvertake() {
        int max_velocity = 0;
        if (this.type == 1) {
            max_velocity = 3;
        }
        if (this.type == 2) {
            max_velocity = 5;
        }
        if (this.type == 3) {
            max_velocity = 7;
        }

        return this.velocity != max_velocity && this.left != null && distanceBehind(this) && distanceBehind(left) &&
                distanceAhead(left);
    }

    public boolean canGoBack() {
        return this.right != null && !distanceBehind(this) && distanceBehind(right) &&
                distanceAhead(right);
    }

    public boolean distanceBehind(Point p) {
        Point temp = p;
        int distance = 0;
        while (distance <= 7) {
            if ((temp.type == 1 || temp.type == 2 || temp.type == 3) && temp != p) {
                int max_velocity = 0;
                if (temp.type == 1) {
                    max_velocity = 3;
                }
                if (temp.type == 2) {
                    max_velocity = 5;
                }
                if (temp.type == 3) {
                    max_velocity = 7;
                }

                return max_velocity < distance;
            }

            temp = temp.prev;
            distance++;
        }

        return true;
    }

    public boolean distanceAhead(Point p) {
        Point temp = p;
        int distance = 0;
        while (distance <= 7) {
            if ((temp.type == 1 || temp.type == 2 || temp.type == 3) && temp != p) {
                return false;
            }

            temp = temp.prev;
            distance++;
        }

        return true;
    }

    public Point changeSide(Point newPosition) {
        newPosition.type = this.type;
        newPosition.velocity = this.velocity;

        this.moved = true;
        this.type = 0;
        this.velocity = 0;

        return newPosition;
    }

    public void clicked() {
        // TODO
        this.type = 0;
        this.velocity = 0;
    }

    public void clear() {
        // TODO
        this.type = 0;
        this.velocity = 0;
    }

    public void acceleration() {
        if (this.type == 1 && this.velocity < 3) {
            this.velocity++;
        }
        if (this.type == 2 && this.velocity < 5) {
            this.velocity++;
        }
        if (this.type == 3 && this.velocity < 7) {
            this.velocity++;
        }
    }

    public void setVelocity(int newVelocity) {
        this.velocity = newVelocity;
    }

    public void slowingDown(Point p) {
        int max_velocity = p.velocity;
        Point temp = p;
        for (int i = 0; i < p.velocity; i++){
            if (temp.next.type == 1 || temp.next.type == 2 || temp.next.type == 3){
                max_velocity = i;
                break;
            }
            temp = temp.next;
        }

        p.setVelocity(max_velocity);
    }
}

