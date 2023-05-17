package primitiveobsession;

public class UserRole {
    private final int role;

    public static final int USER_ROLE_ADMIN = 0;
    public static final int USER_ROLE_ENGINEER = 1;
    public static final int USER_ROLE_MANAGER = 2;
    public static final int USER_ROLE_SALES = 3;

    public UserRole(int role) {
        this.role = role;
    }

    public int getRole() {
        return role;
    }

    public boolean canDeleteUsers() {
        if (getRole() == USER_ROLE_MANAGER) return true;
        return role == USER_ROLE_ADMIN;
    }
}
