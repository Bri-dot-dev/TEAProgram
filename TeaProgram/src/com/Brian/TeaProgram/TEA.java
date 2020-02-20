package com.Brian.TeaProgram;
//----------------------------------------------------------------------------------------------------------------------
//   *********************************** FOR LICENSING PLEASE VIEW LICENSING FILE ***********************************
//----------------------------------------------------------------------------------------------------------------------
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
// *Algorithm designed and written by: Roger Needham, and David Wheeler (1994-1998)*
//----------------------------------------------------------------------------------------------------------------------
//                                 +====================================+
//                                 | Code By: Brian Carey               |
//                                 | Tiny Encryption (TEA) Program      |
//                                 | Updated: 2.19.2020                 |
//                                 | v. 1.0.4                           |
//                                 |   https://github.com/Bri-dot-dev   |
//                                 +====================================+
//----------------------------------------------------------------------------------------------------------------------
//  ******************** PLEASE VIEW README FOR INSTRUCTIONS ON HOW TO USE THIS PROGRAM PROPERLY ********************
//----------------------------------------------------------------------------------------------------------------------
class TEA {

    // Variables
    static int sum = 0x0;
    static int delta = 0x9e3779b9; //Constant Variable Delta
    static int lText = 0x01ca4567; //<----- ENTER LEFT HEX HERE (Left Text Block In Hex)
    static int rText = 0x0cabcdef; //<------ENTER RIGHT HEX HERE (Right Text Block In Hex)
    static int key[] = {0xaf6babcd, 0xef00f000, 0xfeafffaf, 0xabcdef01}; //<-- ENTER KEY HERE (128-Bit Key)


    public static void log(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] args) {
        log("+==============================================+");
        log("|======| Tiny Encryption (TEA) Program |=======|");
        log("|===============| Brian Carey |================|");
        log("|==================| v1.0.4 |==================|");
        log("+==============================================+");
        // Printing Plain Text
        log(String.format("| Plain Text is:     "+"0x%08x", lText) + "" + String.format("%08x        |", rText));
        log( "|----------------------------------------------|");
        // Calling Encryption
        int[] encText = encrypt(lText, rText);
        // Calling Decryption
        String decText = decrypt(encText[0], encText[1]);
        //Parsing Left Block
        lText = Integer.parseInt(decText.substring(String.valueOf(lText).length()),16);
        //Parsing Right Block
        rText = Integer.parseInt(decText.substring(String.valueOf(rText).length()),16);
        // Printing Key Used
        log(String.format("| Key Used: 0x%08x%08x%08x%08x |", key[0], key[1], key[2], key[3]));
        log("+==============================================+");
    }
    //Encryption Method
    public static int[] encrypt (int l, int r) {
        // Handling Errors With Key Input
        if( key == null)
        {
            log("Key is not defined!");
            System.exit(0);
        }
        sum = 0;
        //TEA Algorithm for Encrypting
        for(int i =0; i  <32; i++) {

            sum  += delta;

            l += (r << 4 & 0xfffffff0 ) + key[0] ^ r + sum ^ (r >>> 5 & 0x7ffffff) + key[1];

            r += (l << 4 & 0xfffffff0 ) + key[2] ^ l + sum ^ (l >>> 5 & 0x7ffffff) + key[3];

        }
        // Printing out Encrypted Cipher Text
        log(String.format("| Cipher Text is:    "+"0x%08x", l) + "" + String.format("%08x        |", r));
        log("|----------------------------------------------|");
        // Returning "encText" or Encrypted Text
        int[] encText = {l,r};
        return encText;
    }
    //------------------------------------------------------------------------------------------------------------------
    //Decryption Method
    public static String decrypt (int l, int r) {
        // Handling Errors With Key Input
        if( key == null)
        {
            log("Key is not defined!");
            System.exit(0);
        }
        // TEA Algorithm for Decrypting
        sum = delta << 5;

        for ( int i=0; i<32; i++) {

            r -= (l << 4 & 0xfffffff0) + key[2] ^ l + sum ^ (l >>> 5 & 0x7ffffff) + key[3];

            l -= (r << 4 & 0xfffffff0) + key[0] ^ r + sum ^ (r >>> 5 & 0x7ffffff) + key[1];

            sum -= delta;
        }
        //--------------------------------------------------------------------------------------------------------------
        // Printing out Decrypted Text
        log(String.format("| Decrypted Text is: "+"0x%08x", l) + "" + String.format("%08x        |", r));
        log("|----------------------------------------------|");
        // Returning "decText" or Decrypted Text
        String decText = Integer.toString(l,16) + Integer.toString(r,16);
        return decText;
    }
}
