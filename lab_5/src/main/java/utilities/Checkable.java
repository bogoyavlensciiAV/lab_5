package utilities;
import exceptions.InappropriateArgumentException;
public interface Checkable {
    public boolean check() throws InappropriateArgumentException;
}
