package reversetext;


public class MyString implements Runnable {

    private String str;
    private StringBuilder stringBuilder = new StringBuilder();

    public MyString(String str) {
        this.str = str;
    }

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }

    public String getStr() {
        return str;
    }

    @Override
    public void run() {
       stringBuilder.append(new StringBuilder(str));
       stringBuilder.reverse();
    }
}
