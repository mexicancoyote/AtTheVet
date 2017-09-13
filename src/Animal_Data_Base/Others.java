package Animal_Data_Base;

public class Others extends Variables {
  public String category;
  public Others(String category){
      this.category=category;
  }
    public Others (String owner, String breed, String name, int age, String category){
        super(owner, breed, name, age);
        this.category=category;

    }

}