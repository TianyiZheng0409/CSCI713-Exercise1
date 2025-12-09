
public class Utils {

    public static boolean isValidName(String name) {
        return name != null && !name.isEmpty();
    }

    public static boolean isValidAge(int age) {
        if (age < 0 || age > 120) return false;
        else return true;  
    }

}
