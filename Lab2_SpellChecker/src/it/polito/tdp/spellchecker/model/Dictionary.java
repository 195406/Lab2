package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Dictionary {
	
	
	private List<String> dictionary=new LinkedList<String>();
	
	public void loadDictionary(){

	/*try {
		FileReader fr = new FileReader("rsc/Italian.txt");
		BufferedReader br = new BufferedReader(fr);
		String word;
		while ((word = br.readLine()) != null) {
		// Aggiungere word alla struttura dati
			dictionary.add(word);
		}
		br.close();
		} catch (IOException e){
		System.out.println("Errore nella lettura del file");
		}*/
	
	
	}
	
	
	public List<String> getDictionary(){
		return dictionary;
	}
	
	public List<RichWord> spellCheckText(List<String> inputTextList){
		
		ArrayList<RichWord> output=new ArrayList<RichWord>();
		//boolean trovata=false;
		
		
	
		
		boolean corretto = false;
		for(String s : inputTextList){
			if(dictionary.contains(s))
				corretto = true;
			else
				corretto = false;
			output.add(new RichWord (s, corretto));
		}
		
		
		return output;
	}

}
