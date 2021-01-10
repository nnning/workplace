package inter;

/**
 * APHero
 */
public class APHero extends Hero implements Mortal{

  public void attack() {
    System.out.println("AP attack!");
  }

  @Override
  public void die() {
    System.out.println(name + " AP Hero die!");
  }
}