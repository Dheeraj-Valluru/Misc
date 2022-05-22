public class App {

  public static void main(String[] args) {
    Name name = new Name.Builder()
            .firstName("philip")
            .middleNames("peter")
            .surname("stark")
            .build();

    Address address = new Address.Builder()
            .city("Boston")
            .houseNumber(21)
            .zipCode("01922")
            .street("Forsyth")
            .build();

    Account account = new Account.Builder()
            .id(1)
            .email("email")
            .name(name)
            .address(address)
            .build();


  }
}
