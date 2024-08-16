package utilities;

public class FormatCheck {
    public static boolean isInt(String str) {
        try {
            Integer.parseInt(str);
        } catch ( NumberFormatException exp) {
            return false;
        }
        return true;
    }
    public static boolean isLong(String str) {
        try {
            Long.parseLong(str);
        } catch ( NumberFormatException exp) {
            return false;
        }
        return true;
    }
    public static boolean isFloat(String str) {
        try {
            Float.parseFloat(str);
        } catch ( NumberFormatException exp) {
            return false;
        }
        return true;
    }
    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
        } catch ( NumberFormatException exp) {
            return false;
        }
        return true;
    }
}
