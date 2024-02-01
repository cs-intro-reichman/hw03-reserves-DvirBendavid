/** String processing exercise 1. */
public class LowerCase {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(lowerCase(str));
    }

   /**
    * Returns a string which is identical to the original string, 
    * except that all the upper-case letters are converted to lower-case letters.
    * Non-letter characters are left as is.
    */
    public static String lowerCase(String s) {
        //establish new string to output and a char to help convert;
        String newS = "";
        char tempC;

        //goes through the original string and convert upper case chars.
        for(int i=0; i<s.length(); i++){

            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                tempC = (char)(s.charAt(i) + 32);
            }
            else{
                tempC = s.charAt(i);
            }
                newS += tempC;

        }
        return newS;
    }
}