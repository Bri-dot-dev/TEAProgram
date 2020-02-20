----------------------------------------------------------------------------------------------------
Copyright 2020 Brian Carey
----------------------------------------------------------------------------------------------------
Tiny Encryption Algorithm (TEA) - Java Implementation
For the JAVA class "TEAProgram.java"
----------------------------------------------------------------------------------------------------
Licensing:
----------------------------------------------------------------------------------------------------
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
----------------------------------------------------------------------------------------------------
    http://www.apache.org/licenses/LICENSE-2.0
----------------------------------------------------------------------------------------------------
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
----------------------------------------------------------------------------------------------------
NOTICE:
----------------------------------------------------------------------------------------------------
The "TEA" ("Tiny Encryption") Algorithm and the successor "Corrected Block TEA" also known as 
"XXTEA or XTEA"  was published 1994-1998 by Roger Needham, and David Wheeler. Roger Needham, and
David Wheeler are here by understood and given complete recognition as the designers of the 
Tiny Encryption Algorithm that is being used in this program. 
----------------------------------------------------------------------------------------------------
Using this Program:
----------------------------------------------------------------------------------------------------
1) *PLAINTEXT*

For example, given the plaintext of: 0x12345678abcdef00 (Entries must be in hex) 64-bit max

Split into left and right .... Left or "lText" ---> 0x01ca4567 | 0x0cabcdef <--- Right or "rText"
						                                          	^            ^
                                                        |            |
                                                    (32-bits) + (32-bits) 
						                = 64-bits toal

Where, "lText" contains the left block of the 64 bit plain text, 32-bits total

    static int lText = 0x01ca4567; <---- Left Text Block In Hex

  and, "rText" contains the right block of the 64 bit plain text, 32-bits total

    static int rText = 0x0cabcdef; <---- Right Text Block In Hex


2) *KEY*

For example, given the key of: 0xa56babcdffffffffffffffffabcdef01 (Key must be in hex) 128-bit max

Enter key into the given array in 32 bit segments, must include "0x" in front of each segment

    static int key[] = {0xa56babcd, 0xffffffff, 0xffffffff, 0xabcdef01}; // 128-Bit Key
			                    ^             ^            ^            ^
                                 key[0](32-bits) key[1](32-bits) key[2](32-bits) key[3](32-bits)
				                       = 128 bits total

3) Compile and run, must include package "com.Brian.TeaProgram;" in order to run

***Since they keys and the the plaintext are NOT given by random I have attached some at the bottom 
to use these keys can also be found online or generated. 

----------------------------------------------------------------------------------------------------
Examples: Cyphertext generated is NOT random. You can use these examples for experimental purposes.
----------------------------------------------------------------------------------------------------
                                        
Plaintext: 0x123456789abcdef            
                                        
Key: 0xa56babcdf000ffffffffffffabcdef01 
                                        
Cyphertext: 0x7556391b2315d9f8          
                                        
=========================================
                                        
Plaintext: 0x123456789abcdef            
                                        
Key: 0xa56babcdffffffffffffffffabcdef01 
                                        
Cyphertext: 0xfe18f8f3fcb8dcd3          
                                        
=========================================
                                        
Plaintext: 0x123456789abcdef            
                                        
Key: 0xa56babcdffabffffffffffffabcdef01 
                                        
Cyphertext: 0x97f78dcf1dba72ba 

----------------------------------------------------------------------------------------------------
***This program is in an experimental stage and will be updated in the future. Please send any bugs 
or errors to https://github.com/Bri-dot-dev
----------------------------------------------------------------------------------------------------

