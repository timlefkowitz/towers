package com.home.towers.controllers;

import java.util.Arrays;

public class prac {

    static boolean areAnagram(char[] str1, char[] str2)
    {
        // get the lengths of both strings
        int n1 = str1.length;
        int n2 = str2.length;

        // If length of both strings is not the same, the they cannot be anagrams
        if (n1 != n2)
            return false;

        // Lets sort both strings
        Arrays.sort(str1);
        Arrays.sort(str2);

        //Compare sorted strings
        for (int i = 0; i < n1; i++)
            if(str1[i] != str2[i])
                return false;

            return true;
    }

    public static void main(String args[]){
        char str1[] = { 't', 'e', 's', 't' };
        char str2[] = { 't', 't', 'e', 'w' };

        // function call
        if(areAnagram(str1, str2))
            System.out.println("The two strings are" + " anagram of each other");

        else
            System.out.println("The two strings are not " + " anagrams of each other");
    }

}
