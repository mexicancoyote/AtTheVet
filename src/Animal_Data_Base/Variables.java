package Animal_Data_Base;

public abstract class Variables {
    public String owner;
    public String breed;
    public String name;
    public int age;
    public Variables(){
    }
    public Variables (String owner, String breed, String name, int age){
        this.owner=owner;
        this.breed=breed;
        this.name=name;
        this.age=age;
    }
}