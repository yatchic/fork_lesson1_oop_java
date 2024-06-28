package family_tree;

public abstract class DataAbstractClass {
    abstract  protected int raznitsaVremeni(String birthDateStr, String deathDateStr);

    protected abstract int calculateAge(String birthDateStr);
}
