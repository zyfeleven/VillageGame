package Inhabitant;

public class Army implements Inhabitant{
    protected int attackDmg;
    protected int attackRange;
    Army(){}

    public String typeOf(){
        return "Army";
    }

    public int getAtkDmg(){
        return this.attackDmg;
    }

    public int getAtkRange(){
        return this.attackRange;
    }
}
