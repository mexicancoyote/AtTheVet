package Animal_Data_Base;

public class Fish extends Variables {
 public int howManyScales;
 public Fish(int howManyScales){
this.howManyScales=howManyScales;
 }
    public Fish(int howManyScales, String owner, String breed, String name, int age){
        super(owner, breed, name, age);
        this.howManyScales=howManyScales;

    }

}