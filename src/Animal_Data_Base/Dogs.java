package Animal_Data_Base;

public class Dogs extends Variables {
public int howManyBarks;
    public Dogs(int howManyBarks, String owner, String breed, String name, int age ){
        super(owner, breed, name, age);
        this.howManyBarks=howManyBarks;

    }

}