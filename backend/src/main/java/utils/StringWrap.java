package utils;

public class StringWrap {

    String stringValue;

    public StringWrap() {
        stringValue = new String();
    }

    public StringWrap(String val) {
        stringValue = new String(val);
    }

    public String getString() {
        return stringValue;
    }

    public void setString(String val) {
        stringValue = new String(val);
    }

    public String toString() {
        return stringValue;
    }

}

