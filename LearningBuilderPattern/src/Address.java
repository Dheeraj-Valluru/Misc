public class Address {

  private int houseNumber;
  private String street;
  private String zipCode;
  private String city;

  public Address (Builder builder){
    this.houseNumber = builder.houseNumber;
    this.street = builder.street;
    this.zipCode = builder.zipCode;
    this.city = builder.city;
  }

  public static class Builder{
    private int houseNumber;
    private String street;
    private String zipCode;
    private String city;

    public Builder houseNumber(int houseNumber){
      this.houseNumber = houseNumber;
      return this;
    }

    public Builder street(String street){
      this.street = street;
      return this;
    }

    public Builder zipCode(String zipCode){
      this.zipCode = zipCode;
      return this;
    }

    public Builder city(String city){
      this.city = city;
      return this;
    }

    public Address build(){
      return new Address(this);
    }
  }
}
