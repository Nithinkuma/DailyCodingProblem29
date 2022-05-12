/**This problem was asked by Amazon.

 Run-length encoding is a fast and simple method of encoding strings.
 The basic idea is to represent repeated successive characters as a single count and character.
 For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".

 Implement run-length encoding and decoding.
 You can assume the string to be encoded have no digits and consists solely of alphabetic characters.
 You can assume the string to be decoded is valid.**/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String inputString = scan.nextLine();
        String encodedString = encodingTheString(inputString);
        String decodedString = decodingTheString(encodedString);
        System.out.println(encodedString);
        System.out.println(decodedString);
    }

    private static String decodingTheString(String encodedString) {
        StringBuilder decode = new StringBuilder();
        for(int i =0 ; i<encodedString.length();i=i+2){
            int rep = Integer.parseInt(String.valueOf(encodedString.charAt(i)));
            char s = encodedString.charAt(i+1);
            while(rep!=0){
                decode.append(s);
                rep--;
            }
        }
        return decode.toString();
    }

    private static String encodingTheString(String inputString) {
        int count=1;
        StringBuilder encode= new StringBuilder();
        for(int i =1 ; i<inputString.length();i++){
            if(inputString.charAt(i)==inputString.charAt(i-1)){
                count+=1;
            } else {
                String s=Integer.toString(count);
                encode.append(s).append(inputString.charAt(i-1));
                count=1;
            }
        }
        encode.append(count).append(inputString.charAt(inputString.length()-1));

        return encode.toString();
    }
}