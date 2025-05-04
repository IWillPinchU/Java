public class StringMethods {
    public static void main(String[] args) {
        String name = "        SANSKAR      ";

        int length = name.length();
        char letter = name.charAt(0);
        int index = name.indexOf("N");
        int lastIndex = name.lastIndexOf("A");

        //name = name.toUpperCase();
        //name = name.toLowerCase();
        //name = name.trim(); to remove white spaces
        //name = name.replace("A", "O");
        //boolean Empty = name.isEmpty();
        //boolean containChar = name.contains(" ");

        /*
        if(name.equals("password")){
            System.out.println("Your name can not be password");
        }
        else{
            System.out.println(name);
        }

        if(name.equalsIgnoreCase("password")){  //ignores case sensitivity
            System.out.println("Your name can not be password");
        }
        else{
            System.out.println(name);
        }
        */

        System.out.println(name);
    }
}
