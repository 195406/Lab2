package it.polito.tdp.spellchecker.controller;

//import java.awt.Color;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.EnglishDictionary;
import it.polito.tdp.spellchecker.model.ItalianDictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
//import javafx.scene.paint.Paint;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class SpellCheckerController {
	
	private Dictionary model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtOutput;
    
    @FXML
    private TextFlow txtFlow;

    @FXML
    private Button btnClear;

    @FXML
    private Label lblStato;

    @FXML
    private Label lblPrestazione;

    @FXML
    private ComboBox<String> boxLanguage;

    @FXML
    private TextArea txtInput;

    @FXML
    private Button btnSpell;

    @FXML
    void doClearText(ActionEvent event) {
    	
    	txtInput.clear();
    	txtOutput.clear();
    	lblStato.setText("");

    }
    
    
   // @FXML
   // void doSpellCheck(ActionEvent event){
    	
   // }
    

    @FXML
    void doSpellCheck(ActionEvent event) {
    	
    	if(txtInput.getLength()==0){
    		txtOutput.setText("Insert text in the text area below!");
    	}
    	if(boxLanguage.getValue()==null){
    		txtOutput.setText("insert language!");
    	}
    	
    	if(boxLanguage.getValue().contains("Italian")){
    		
    		double t0= System.nanoTime();
    		ItalianDictionary id=new ItalianDictionary();
    		id.loadDictionary();
    		List<String> verifica=new ArrayList<String>();
    		String input=txtInput.getText();
    		
    		
    		StringTokenizer st=new StringTokenizer(input," ");
    		
    		while(st.hasMoreTokens()){
    			verifica.add(st.nextToken().toLowerCase());
    		}
    		
    		ArrayList<RichWord> output=(ArrayList<RichWord>) id.spellCheckText(verifica);
    		double t1= System.nanoTime();
    		double tot=((t1-t0));
    		lblPrestazione.setText("Spell check completed in "+tot+" s");
    		for(RichWord rw:output){
    			System.out.println(rw.getWord());
    		}
    		
    		
    		
    		
    		for(int i=0;i<output.size();i++){
    			if(output.get(i).isCorretta()==true){
    				
    				System.out.println(output.get(i).isCorretta());
    				//Text t=new Text(output.get(i).getWord());
    				//txtFlow.getChildren().add(t);
    				
    				txtOutput.appendText(output.get(i).getWord()+" ");
    			}else{
    				
    				lblStato.setText("il testo contiene errori");
    				lblStato.setTextFill(Color.RED);
    				
    			
    				
    			//	Text t=new Text(output.get(i).getWord());
    			//	t.setFill(Color.RED);
    				txtOutput.appendText(output.get(i).getWord().toUpperCase()+" ");
    				//txtFlow.getChildren().add(t);
    				
    				System.out.println(output.get(i).isCorretta());
    			}
    			
    			
    		}
    		
    	
    		
    	  
    		
    		
    		
    		
    	}
    	
if(boxLanguage.getValue().contains("English")){
    		long t0=System.nanoTime();
    		EnglishDictionary id=new EnglishDictionary();
    		id.loadDictionary();
    		List<String> verifica=new ArrayList<String>();
    		String input=txtInput.getText();
    		
    		
    		StringTokenizer st=new StringTokenizer(input," ");
    		
    		while(st.hasMoreTokens()){
    			verifica.add(st.nextToken().toLowerCase());
    		}
    		
    		ArrayList<RichWord> output=(ArrayList<RichWord>) id.spellCheckText(verifica);
    		long t1=System.nanoTime();
    		long tot=t1-t0;
    		lblPrestazione.setText(String.format("Spell check completed in %d seconds",tot));
    		for(RichWord rw:output){
    			System.out.println(rw.getWord());
    		}
    		
    		
    		
    		for(int i=0;i<output.size();i++){
    			if(output.get(i).isCorretta()==true){
    				
    				System.out.println(output.get(i).isCorretta());
    				txtOutput.appendText(output.get(i).getWord()+" ");
    			}else{
    				lblStato.setText("your text contains error");
    				lblStato.setTextFill(Color.RED);
    				
    				System.out.println(output.get(i).isCorretta());
    				txtOutput.appendText(output.get(i).getWord().toUpperCase()+" ");
    			}
    			
    			
    		}
    		}
    		

    }
    
    public void setModel(Dictionary model){
    	this.model=model;
    }

    @FXML
    void initialize() {
    	//assert txtFlow != null : "fx:id=\"txtFlow\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtOutput != null : "fx:id=\"txtOutput\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lblStato != null : "fx:id=\"lblStato\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lblPrestazione != null : "fx:id=\"lblPrestazione\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert boxLanguage != null : "fx:id=\"boxLanguage\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnSpell != null : "fx:id=\"btnSpell\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        boxLanguage.getItems().addAll("English","Italian");
    }
}