package com.tap.connection;

import java.util.Arrays;

public class string_split {
	@SuppressWarnings("null")
	public static void main(String args[]) throws Exception {
//		String s = "Singapore : Aqueen Hotel Lavender or\r\nSimilar + Sentosa : Amara Sanctuary\r\nResort or Similar";
//		String[] d = getplaces(s);
	}

	public static String[] getplaces(String string) {
		String word = "Or Similar\r\n Similar";
		String word2 = "Or\r\n Similar";
		String word3 = "\r\nor Similar";
		String word4 = "or\r\nSimilar";
		String word5 = "\r\nOr Similar";
		String word6 = "\r\n Similar";
		String word7 = "Or similar";
		String word8 = "Or Similar";
		String word9 = "or similar";
		String word10 = "OR SIMILAR";
		String word11 = "or Similar";
		String word12 = "OrSimilar";
		String word13 = "\r\nor";
		String word14 = "\r\n";
		String word15 = "Similar";
		String word16 = "Similar ";
		String word17 = "similar";
		String word18 = "Or";
		String word19 = "or";
		String word20 = " or";
		String result1 = removeWord(string, word);
		String result2 = removeWord(result1, word2);
		String result3 = removeWord(result2, word3);
		String result4 = removeWord(result3, word4);
		String result5 = removeWord(result4, word5);
		String result6 = removeWord(result5, word6);
		String result7 = removeWord(result6, word7);
		String result8 = removeWord(result7, word8);
		String result9 = removeWord(result8, word9);
		String result10 = removeWord(result9, word10);
		String result11 = removeWord(result10, word11);
		String result12 = removeWord(result11, word12);
		String result13 = removeWord(result12, word13);
		String result14 = removeWord(result13, word14);
		String result15 = removeWord(result14, word15);
		String result16 = removeWord(result15, word16);
		String result17 = removeWord(result16, word17);
		String result18 = removeWord(result17, word18);
		String result19 = removeWord(result18, word19);
		String result20 = removeWord(result19, word20);
		//System.out.println(result20);

		String[] words = result20.split("[:,+]");
		//System.out.println(words.length);
//		for (String str1 : words) {
//			System.out.println(str1);
//		}
		//System.out.println(words.length);
		int l = words.length / 2;
		//System.out.println(l);
		String places[] = new String[l];
		String hotels[] = new String[l];
		int i = 0;
		for (int j = 0; j < words.length; j++) {

			if (j % 2 == 0) {
				places[i] = words[j];

				//System.out.println("places-------" + Arrays.toString(places));
				j++;
				i++;
			}
			//System.out.println(places.length);
		}
		return places;

	}

	public static String[] gethotels(String string) {
		String word = "Or Similar\r\n Similar";
		String word2 = "Or\r\n Similar";
		String word3 = "\r\nor Similar";
		String word4 = "or\r\nSimilar";
		String word5 = "\r\nOr Similar";
		String word6 = "\r\n Similar";
		String word7 = "Or similar";
		String word8 = "Or Similar";
		String word9 = "or similar";
		String word10 = "OR SIMILAR";
		String word11 = "or Similar";
		String word12 = "OrSimilar";
		String word13 = "\r\nor";
		String word14 = "\r\n";
		String word15 = "Similar";
		String word16 = "Similar ";
		String word17 = "similar";
		String word18 = "Or";
		String word19 = "or";
		String word20 = " or";
		String result1 = removeWord(string, word);
		String result2 = removeWord(result1, word2);
		String result3 = removeWord(result2, word3);
		String result4 = removeWord(result3, word4);
		String result5 = removeWord(result4, word5);
		String result6 = removeWord(result5, word6);
		String result7 = removeWord(result6, word7);
		String result8 = removeWord(result7, word8);
		String result9 = removeWord(result8, word9);
		String result10 = removeWord(result9, word10);
		String result11 = removeWord(result10, word11);
		String result12 = removeWord(result11, word12);
		String result13 = removeWord(result12, word13);
		String result14 = removeWord(result13, word14);
		String result15 = removeWord(result14, word15);
		String result16 = removeWord(result15, word16);
		String result17 = removeWord(result16, word17);
		String result18 = removeWord(result17, word18);
		String result19 = removeWord(result18, word19);
		String result20 = removeWord(result19, word20);
	//	System.out.println(result20);

		String[] words = result17.split("[:,+]");
		int l = words.length / 2;
		//System.out.println(l);
		String places[] = new String[l];
		String hotels[] = new String[l];
		int k = 0;
		for (int j = 0; j < words.length; j++) {

			if (j % 2 != 0) {
				hotels[k] = words[j];

				//System.out.println("Hotel Names-------" + Arrays.toString(hotels));
				j++;
				k++;
			}
			//System.out.println(hotels.length);
		}
		return hotels;

	}

	public static String removeWord(String string, String word) {

		// Check if the word is present in string
		// If found, remove it using removeAll()
		if (string.contains(word)) {

			// To cover the case
			// if the word is at the
			// beginning of the string
			// or anywhere in the middle
			String tempWord = word + " ";
			string = string.replaceAll(tempWord, "");

			// To cover the edge case
			// if the word is at the
			// end of the string
			tempWord = " " + word;
			string = string.replaceAll(tempWord, "");
		}
		// System.out.println(string.toString());
		return string;
	}

	public static String[] gethotelssingle(String hotel_name) {

		String word = "Or Similar\r\n Similar";
		String word2 = "Or\r\n Similar";
		String word3 = "\r\nor Similar";
		String word4 = "or\r\nSimilar";
		String word5 = "\r\nOr Similar";
		String word6 = "\r\n Similar";
		String word7 = "Or similar";
		String word8 = "Or Similar";
		String word9 = "or similar";
		String word10 = "OR SIMILAR";
		String word11 = "or Similar";
		String word12 = "OrSimilar";
		String word13 = "\r\nor";
		String word14 = "\r\n";
		String word15 = "Similar";
		String word16 = "Similar ";
		String word17 = "similar";
		String word18 = "Or";
		String word19 = "or";
		String word20 = " or";
		String result1 = removeWord(hotel_name, word);
		String result2 = removeWord(result1, word2);
		String result3 = removeWord(result2, word3);
		String result4 = removeWord(result3, word4);
		String result5 = removeWord(result4, word5);
		String result6 = removeWord(result5, word6);
		String result7 = removeWord(result6, word7);
		String result8 = removeWord(result7, word8);
		String result9 = removeWord(result8, word9);
		String result10 = removeWord(result9, word10);
		String result11 = removeWord(result10, word11);
		String result12 = removeWord(result11, word12);
		String result13 = removeWord(result12, word13);
		String result14 = removeWord(result13, word14);
		String result15 = removeWord(result14, word15);
		String result16 = removeWord(result15, word16);
		String result17 = removeWord(result16, word17);
		String result18 = removeWord(result17, word18);
		String result19 = removeWord(result18, word19);
		String result20 = removeWord(result19, word20);

		
		String hotels[] = new String[1];
		String ch1 = "";
		String test = result20;
		CharSequence seq = "Similar";
		boolean bool = test.contains(seq);
		//System.out.println("Found soft?: " + bool);
		if(bool==true)
		{
		char[] ch = result20.toCharArray();
		for (int i = 0; i < ch.length - 7; i++) {
			//System.out.println("char at " + i + " index is: " + ch[i]);
			ch1 = ch1 + ch[i];

			
		}
		//System.out.println(ch1);
		//System.out.println(ch1.length());
		hotels[0]=ch1;
		result20 = String.valueOf(ch1);
	     // System.out.println(result20);
		}
		
		
		String ch3 = "";
		String test3 = result20;
		CharSequence seq3 = "similar";
		boolean bool3 = test3.contains(seq3);
		//System.out.println("Found soft?: " + bool3);
		if(bool3==true)
		{
		char[] ch = result20.toCharArray();
		for (int i = 0; i < ch.length - 7; i++) {
			/////System.out.println("char at " + i + " index is: " + ch[i]);
			ch3 = ch3 + ch[i];

			
		}
		hotels[0]=ch3;
		//System.out.println(ch3);
		//System.out.println(ch3.length());
		result20 = String.valueOf(ch3);
	     // System.out.println(result20);
		}
		//System.out.println(Arrays.toString(hotels));
		
		return hotels;

	}

}
