public class MainLoginRegister {
    public static void main(String[] args) {

        Login login = new Login(null);
        if (login.isAuthenticated) {
            System.out.println("User is valid");
        } else {
            System.out.println("Invalid user");
        }
    }
}