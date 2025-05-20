package pack;

public class UserBuilder {
    private User user;
    private UserBuilder() {
        user = new User();
    }

    public static UserBuilder builder() { return new UserBuilder(); }

    public User build() { return this.user; }

    public UserBuilder username(String username) {
        this.user.setUsername(username);
        return this;
    }
    public UserBuilder email(String email) {
        this.user.setEmail(email);
        return this;
    }
    public UserBuilder password(String password) {
        this.user.setPassword(password);
        return this;
    }

}
