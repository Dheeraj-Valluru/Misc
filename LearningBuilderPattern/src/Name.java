import java.util.List;

public class Name {

  private String firstName;
  private String middleNames;
  private String surname;

  public Name(Builder builder){
    this.firstName = builder.firstName;
    this.middleNames = builder.middleNames;
    this.surname = builder.surname;
  }

  public static class Builder{
    private String firstName;
    private String middleNames;
    private String surname;

    public Builder firstName(String firstName){
      this.firstName = firstName;
      return this;
    }

    public Builder middleNames(String middleNames){
      this.middleNames = middleNames;
      return this;
    }

    public Builder surname(String surname){
      this.surname = surname;
      return this;
    }

    public Name build(){
      return new Name(this);
    }
  }
}
