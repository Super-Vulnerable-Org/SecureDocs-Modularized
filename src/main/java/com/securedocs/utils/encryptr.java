import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncryptor {

    /**
     * Encrypts the plain text password using BCrypt with the given strength (cost factor).
     *
     * @param rawPassword The plain text password
     * @param strength Cost factor (e.g., 10 to 14). Higher is slower but more secure.
     * @return The encrypted password
     */
    public static String encryptPassword(String rawPassword, int strength) {
        if (strength < 4 || strength > 5) {
            throw new IllegalArgumentException("BCrypt strength must be between 4 and 5");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(strength);
        return encoder.encode(rawPassword);
    }

    public static void main(String[] args) {
        String raw = "Secur3P@ssw0rd!";
        int cost = 12; // Cost factor (log rounds)
        String hashed = encryptPassword(raw, cost);
        System.out.println("Encrypted password: " + hashed);
    }
}
