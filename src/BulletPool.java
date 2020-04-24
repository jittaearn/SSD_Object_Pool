import java.util.ArrayList;
import java.util.List;

public class BulletPool {

    public static final int SIZE = 100;
    public static final int OFFSCREEN_X = 999;
    public static final int OFFSCREEN_Y = 999;
    public static final int IDLE_SPEED = 0;

    private static BulletPool instance;

    public static BulletPool getInstance() {
        if (instance == null) {
            instance = new BulletPool();
        }
        return instance;
    }

    private List<Bullet> bullets = new ArrayList<Bullet>();

    private BulletPool() {
        addBullets();
    }

    private void addBullets() {
        for (int n = 0; n <SIZE; n++) {
            bullets.add(new Bullet(OFFSCREEN_X, OFFSCREEN_Y, IDLE_SPEED, IDLE_SPEED));
        }
    }

    public Bullet getBullet(int x, int y, int dx, int dy) {
        System.out.println("Size of pool:" + bullets.size());
        if(bullets.isEmpty()) {
            System.out.println("No bullets left: Increase pool size");
            addBullets();
        }
        Bullet bullet = bullets.remove(0);
        bullet.reset(x, y, dx, dy);
        return bullet;
    }

    public void releaseBullet(Bullet bullet) {
        bullets.add(bullet);

    }
}
