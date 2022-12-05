package system.users;

import java.util.Scanner;

public class SignInBoundry {
    static Customer currentCustomer = new Customer("habibayasser", "habibayasser@gmail.com", "123");
    Scanner sc = new Scanner(System.in);
    static Admin currentAdmin = new Admin("maimostafa", "maimostafa@gmail.com", "321");

    private String Email;
    private String Password;
    private String user;
    private int z;
    AuthenticationController controller = new AuthenticationController();

    public SignInBoundry(){};

    public SignInBoundry(String userName, String email, String password) {
        Email = email;
        Password = password;
        user = userName;

    }

    public SignInBoundry(String e, String p) {
        Email = e;
        Password = p;
    }

    void setEmail(String e) {
        Email = e;
    }

    void setPassword(String p) {
        Password = p;
    }

    String getEmail() {
        return Email;
    }

    String getPassword() {
        return Password;
    }

    void setUserl(String e) {
        user = e;
    }

    String getuser() {
        return user;
    }


    public boolean SignInAdmin() {
        return controller.SignInAdmin(Email, Password);
    }

    public boolean SignInUSer() {
        return controller.SignInUser(Email, Password);
    }

    public String SignUp() {
        return controller.SignUpUser(user, Email, Password);
    }

    public Customer getCustomer(String Email) {
        return controller.getCurrentCustomer(Email);
    }

    public Admin getAdmin(String Email) {
        return controller.getCurrentAdmin(Email);
    }

    public int Show(int x) { //show signInboundry for the user or admin to choose if he is admin or user or want to sign up
        if(x==1) {
            System.out.print("Please Enter your email: ");
            Email = sc.next().toLowerCase();
            System.out.print("Please Enter your password: ");
            Password = sc.next();
            SignInBoundry s = new SignInBoundry(Email, Password);
            while (!s.SignInAdmin()) {
                System.out.println("Email or Password is not correct");
                System.out.println();
                System.out.print("Please Enter your email: ");
                Email = sc.next().toLowerCase();
                System.out.print("Please Enter your password: ");
                Password = sc.next();
                System.out.println();
                s = new SignInBoundry(Email, Password);
                if (s.SignInAdmin()) {
                    currentAdmin = s.getAdmin(Email);
                }
            }
            z=1;
        }else if(x==2){
            int y;
            System.out.println("1 :Sign in");
            System.out.println("2: Sign up");
            y = sc.nextInt();

            if (y == 1) {
                System.out.print("Please Enter your email: ");
                Email = sc.next().toLowerCase();
                System.out.print("Please Enter your password: ");
                Password = sc.next();
                System.out.println();
                SignInBoundry s = new SignInBoundry(Email, Password);
                while (!s.SignInUSer()) {
                    System.out.println("Email or Password is not correct");
                    System.out.println();
                    System.out.print("Please Enter your email: ");
                    Email = sc.next().toLowerCase();
                    System.out.print("Please Enter your password: ");
                    Password = sc.next();
                    System.out.println();
                    s = new SignInBoundry(Email, Password);
                    if (s.SignInUSer()) {
                        currentCustomer = s.getCustomer(Email);
                    }
                }

            }
            else if (y == 2)//sign up user
            {
                System.out.print("Please Enter user name: ");
                user = sc.next();
                sc.nextLine();
                System.out.print("Please Enter your email: ");
                Email = sc.next().toLowerCase();
                System.out.print("Please Enter your password: ");
                Password = sc.next();
                SignInBoundry s = new SignInBoundry(user, Email, Password);
                System.out.println(s.SignUp());
                currentCustomer = s.getCustomer(Email);

            }
            z=2;
        }

        return z;
        }


    }


