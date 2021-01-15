package inter;

/**
 * Hero
 */
public class Hero {

  String name;
  float hp;

  public void attack() {
    System.out.println("Hero attack!");
  }

  public void kill(Mortal m) {
    m.die();
  }
}