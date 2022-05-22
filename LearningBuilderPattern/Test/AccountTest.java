import org.junit.Test;

public class AccountTest {

  @Test
  public void testBuilder() {
    Account account = new Account.Builder()
            .id(12)
            .email("email")
            .build();

    System.out.println(account.getId());
    System.out.println(account.getEmail());
  }
}