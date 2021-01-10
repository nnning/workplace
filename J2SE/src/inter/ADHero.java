package inter;

/**
 * ADHero
 */
public class ADHero extends Hero implements Mortal{

  public void attack() {
    System.out.println("AD attack!");
  }

  @Override
  public void die() {
    System.out.println(name + " AD Hero Die!");
  }
}