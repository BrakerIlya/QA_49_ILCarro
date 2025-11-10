package utils;

public class Experiments {
    public static void main(String[] args) {
        System.out.println(monthCreate("DECEMBER"));
    }
    private static String monthCreate(String month){
        StringBuilder result =new StringBuilder();
        return result.append(month.substring(0,1).toUpperCase())
                .append(month.substring(1).toLowerCase()).toString();

    }
}
