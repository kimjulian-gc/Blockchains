import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/*this class is to represent, and provide methods for, the Hash objects in our MP7 */
public class Hash {
    int currNode;
    String data;
    byte[] prevHash;
    byte[] currHash;
    int nonce;

    /*
     * calculateHash returns a byte array that represents the hash generated by
     * putting the input msg into the "sha-265" algorithm
     * 
     * @pre: msg is a valid string
     * 
     * @post: a vaid byte array is returned, or an error is returned
     */
    public byte[] calculateHash(String msg) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("sha-256");
        md.update(msg.getBytes());
        byte[] hash = md.digest();
        return hash;
    }

    /*
     * isValid uses the nonce to compare with the hash as a way of determining if a
     * hash is valid
     * 
     * @pre: the nonce and hash byte array are valid and exist
     * 
     * 
     * @post: a boolean is returned that derrmines validity, true or false
     */
    public boolean isValid() {
        String nonceString = Integer.toString(nonce);// converting our nonce value to a string
        int nonceLength = nonceString.length();// getting the length of the nonce string;
        String HashComparison = Arrays.toString(currHash);
        HashComparison = HashComparison.substring(0, nonceLength);// getting the substring of the hash that we will
                                                                  // compare to the nonce to see if it is a valid Hash
        return HashComparison.equals(nonceString);// return the boolean here if the hash substring is equal to the nonce
                                                  // comparator string
    }

    byte[] getData() {
        return this.currHash;
    }

    /*
     * equals compares the hash object to another object to
     * determine whetehr the other object is a hash object, and, if so,
     * that hash matches with the current hash object
     * 
     * @pre: none
     * 
     * @post: a true/false boolean is returned
     */
    public boolean equals(Object o) {
        if (o instanceof Hash) {
            Hash input = (Hash) o;
            if (input.currHash.equals(this.currHash)) {
                return true;// if o is a hash object who's hash byte array is identical to the current
                // objects, return true
            }
        }
        return false; // if o is not a hash object who's hash byte array is identical to the current
                      // objects, return false
    }

    /*
     * toString converts the hash of the object to a string made up of hexadecimal
     * representation of the values in the hash. it also prints it out.
     * 
     * @pre: none
     * 
     * @post: a string is returned that represents the hash code in hexadecimal
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < this.currHash.length; i++) {
            Byte curr = this.currHash[i];// getting the byte at the current index
            System.out.printf("%x", Byte.toUnsignedInt(curr));
            String added = "";
            added = String.format("%x", Byte.toUnsignedInt(curr));
            s = s + added;// converting the byte to a unsigned int, and adding it to
                          // the end of s;
        }
        return s;
    }

}