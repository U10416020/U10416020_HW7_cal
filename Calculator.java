//U10416020

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Parent;
import java.util.*;

public class Calculator extends Application {
	//Data fields
	public ArrayList<Double> memory = new ArrayList<Double>();
	public ArrayList<String> memory_symbol = new ArrayList<String>();
	public String display = "";
	public String remember = "";
	public String compute = "";
	public double result;
	public double memory_result;
	public char symbol = 'b';	
	public boolean has_symbol = false;	
	
	//Override the start method in the Application class
	@Override
	public void start(Stage primaryStage){		
		//Create menu & menuBar
		Menu visiable = new Menu("檢視(V)");
		Menu edit = new Menu("編輯(E)");
		Menu explan = new Menu("說明(H)");
		MenuBar mainMenu = new MenuBar();
		
		//Add menu to menu bar
		mainMenu.getMenus().addAll(visiable, edit, explan);
		
		//Create menu items
		MenuItem basic = new MenuItem("標準型(T)\t\tAlt+1");
		MenuItem engineer = new MenuItem("工程型(S)\t\tAlt+2");
		MenuItem program = new MenuItem("程式設計師(P)\tAlt+3");
		MenuItem count = new MenuItem("統計資料(A)\t\tAlt+4");
		MenuItem record = new MenuItem("歷程記錄(Y)\t\tAlt+H");
		MenuItem digit = new MenuItem("數字分位(I)");
		MenuItem basic1 = new MenuItem("基本(B)\t\t\tAlt+F4");
		MenuItem alter = new MenuItem("單位轉換(U)\t\tAlt+U");
		MenuItem date = new MenuItem("日期計算(D)\t\tAlt+E");
		MenuItem work = new MenuItem("工作表(W)");
		
		//Add menu items to menu
		visiable.getItems().addAll(basic, engineer, program, count, record,
		digit, basic1, alter, date, work);
		
		//Create menu items
		MenuItem copy = new MenuItem("複製(C)\t\tCtrl+C");
		MenuItem paste = new MenuItem("貼上(P)\t\tCtrl+V");
		MenuItem record1 = new MenuItem("歷程記錄(H)");
		
		//Add menu items to menu
		edit.getItems().addAll(copy, paste, record1);
		
		//Create menu item
		MenuItem viewExplan = new MenuItem("檢視說明(V)\t\tF1");
		MenuItem about = new MenuItem("關於小算盤(A)");
		
		//Add menu items to menu
		explan.getItems().addAll(viewExplan, about);	
		
		//Create a text field
		TextField textField = new TextField();
		textField.setAlignment(Pos.CENTER_RIGHT);
		textField.setEditable(false);
		
		//Create buttons		
		Button zero = new Button("0");
		Button one = new Button("1");
		Button two = new Button("2");
		Button three = new Button("3");
		Button four = new Button("4");
		Button five = new Button("5");
		Button six = new Button("6");
		Button seven = new Button("7");
		Button eight = new Button("8");
		Button nine = new Button("9");
		Button plus = new Button("+");
		Button minus = new Button("-");
		Button cross = new Button("*");
		Button divide = new Button("÷");
		Button mc = new Button("MC");
		Button mr = new Button("MR");
		Button ms = new Button("MS");
		Button mplus = new Button("M+");
		Button mminus = new Button("M-");
		Button delete = new Button("<--");
		Button ce = new Button("CE");
		Button c = new Button("C");
		Button mark = new Button("±");
		Button root = new Button("√");
		Button percent = new Button("%");
		Button divide1 = new Button("1/x");
		Button equal = new Button("=");
		Button dot = new Button(".");		
		
		//Set the size of buttons
		one.setPrefSize(40,20);
		two.setPrefSize(40,20);
		three.setPrefSize(40,20);
		four.setPrefSize(40,20);
		five.setPrefSize(40,20);
		six.setPrefSize(40,20);
		seven.setPrefSize(40,20);
		eight.setPrefSize(40,20);
		nine.setPrefSize(40,20);
		plus.setPrefSize(40,20);
		minus.setPrefSize(40,20);
		cross.setPrefSize(40,20);
		divide.setPrefSize(40,20);
		mc.setPrefSize(40,20);
		mr.setPrefSize(40,20);
		ms.setPrefSize(40,20);
		mplus.setPrefSize(40,20);
		mminus.setPrefSize(40,20);
		delete.setPrefSize(40,20);
		ce.setPrefSize(40,20);
		c.setPrefSize(40,20);
		mark.setPrefSize(40,20);
		root.setPrefSize(40,20);
		percent.setPrefSize(40,20);
		divide1.setPrefSize(40,20);
		dot.setPrefSize(40,20);		
		zero.setPrefSize(85,20);
		equal.setPrefSize(40,50);
		
		//Create pane, HBox, VBox 
		StackPane paneTextField = new StackPane();			
		Pane pane = new VBox(5);
		HBox h1 = new HBox(5);
		HBox h2 = new HBox(5);
		HBox h3 = new HBox(5);
		HBox h4 = new HBox(5);
		HBox h5 = new HBox(5);
		HBox h6 = new HBox(5);
		HBox h7 = new HBox(5);
		VBox v1 = new VBox(5);
		h1.getChildren().addAll(mc,mr,ms,mplus,mminus);
		h2.getChildren().addAll(delete,ce,c,mark,root);
		h3.getChildren().addAll(seven,eight,nine,divide,percent);
		h4.getChildren().addAll(four,five,six,cross,divide1);
		h5.getChildren().addAll(one,two,three,minus);
		h6.getChildren().addAll(zero,dot,plus);
		v1.getChildren().addAll(h5,h6);
		h7.getChildren().addAll(v1,equal);		
		
		//Add a text field to paneTextField
		paneTextField.getChildren().add(textField);			
		pane.getChildren().add(mainMenu);
		pane.getChildren().add(paneTextField);
		pane.getChildren().add(h1);
		pane.getChildren().add(h2);
		pane.getChildren().add(h3);
		pane.getChildren().add(h4);		
		pane.getChildren().add(h7);			
		
		//Create and set scene
		Scene scene = new Scene(pane, 250, 250);
		
		//Set stage
		primaryStage.setTitle("U10416020 Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//Set action for buttons
		//Add character to a variable named display to show what user key in
		//Add character to compute to calculate
		zero.setOnAction(e -> {
			display += "0";
			compute += "0";
			textField.setText(display);
		});
		one.setOnAction(e -> {
			display += "1";
			compute += "1";
			textField.setText(display);
		});
		two.setOnAction(e -> {
			display += "2";
			compute += "2";
			textField.setText(display);
		});
		three.setOnAction(e -> {
			display += "3";
			compute += "3";
			textField.setText(display);
		});
		four.setOnAction(e -> {
			display += "4";
			compute += "4";
			textField.setText(display);
		});
		five.setOnAction(e -> {
			display += "5";
			compute += "5";
			textField.setText(display);
		});
		six.setOnAction(e -> {
			display += "6";
			compute += "6";
			textField.setText(display);
		});
		seven.setOnAction(e -> {
			display += "7";
			compute += "7";
			textField.setText(display);
		});
		eight.setOnAction(e -> {
			display += "8";
			compute += "8";
			textField.setText(display);
		});
		nine.setOnAction(e -> {
			display += "9";
			compute += "9";
			textField.setText(display);
		});
		dot.setOnAction(e -> {
			display += ".";
			compute += ".";
			textField.setText(display);
		});
		
		//Change symbol to know which operation should be used to calculate
		//Use if-else to check if compute has symbol to calculate
		plus.setOnAction(e -> {	
			if(has_symbol == false){
				result = Double.valueOf(compute);
				has_symbol = true;
			}
			else{
				if(display.charAt(display.length()-1) == symbol){
					display = display.substring(0,display.length() - 1);
				}
				else{
					setRemember();
					calculate();
				}	
			}			
			display += "+";
			compute += "+";
			symbol = '+';
			textField.setText(display);
		});
		minus.setOnAction(e -> {
			if(has_symbol == false){
				result = Double.valueOf(compute);
				has_symbol = true;
			}
			else{
				if(display.charAt(display.length()-1) == symbol)
					display = display.substring(0,display.length() - 1);
				else{
					setRemember();
					calculate();
				}
			}				
			display += "-";
			compute += "-";
			symbol = '-';
			textField.setText(display);
		});
		cross.setOnAction(e -> {
			if(has_symbol == false){
				result = Double.valueOf(compute);
				has_symbol = true;
			}
			else{
				if(display.charAt(display.length()-1) == symbol)
					display = display.substring(0,display.length() - 1);
				else{
					setRemember();
					calculate();
				}
			}			
			display += "x";
			compute += "x";
			symbol = 'x';
			textField.setText(display);
		});
		divide.setOnAction(e -> {	
			if(has_symbol == false){
				result = Double.valueOf(compute);
				has_symbol = true;
			}
			else{
				if(display.charAt(display.length()-1) == symbol)
					display = display.substring(0,display.length() - 1);
				else{
					setRemember();
					calculate();
				}
			}			
			display += "÷";
			compute += "÷";
			symbol = '÷';
			textField.setText(display);
		});
		
		//Function to delete the last character
		delete.setOnAction(e -> {
			display = display.substring(0,display.length() - 1);
			compute = compute.substring(0,compute.length() - 1);
			textField.setText(display);
		});
		
		//Function to clear all 
		c.setOnAction(e -> {
			display = "";
			compute = "";
			result = 0;
			remember = "";
			symbol = 'b';
			has_symbol = false;				
			textField.setText(display);
		});
		
		//Function to clear the last number
		ce.setOnAction(e -> {
			if(has_symbol == true){
				display = display.substring(0,display.length() - display.lastIndexOf(symbol));
				compute = compute.substring(0,compute.length() - compute.lastIndexOf(symbol));
			}	
			else{
				display = "";
				compute = "";
			}
			textField.setText(display);
		});
		
		//Function to display the result
		equal.setOnAction(e -> {				
			setRemember();
			calculate();			
			display = String.valueOf(result);
			compute = display;
			symbol = 'b';
			has_symbol = false;				
			textField.setText(display);
		});	
		
		//Function to remember current result and prepare to add next result
		mplus.setOnAction(e -> {						
			memory.add(result);
			memory_symbol.add("+");
		});
		
		//Function to remember current result and prepare to minus next result
		mminus.setOnAction(e -> {			
			memory.add(result);
			memory_symbol.set(memory_symbol.size()-1,"-");
		});
		
		//Function to display the result which is use M+ or M- to calculate
		mr.setOnAction(e -> {
			calculateMemory();
			textField.setText(String.valueOf(memory_result));
		});
		
		//Function to clear the numbers in memory
		mc.setOnAction(e -> {
			memory.clear();
			memory_symbol.clear();
			memory_result = 0;
		});
		
		//Function to replace the numbers in memory with current number
		ms.setOnAction(e -> {
			memory.clear();
			setRemember();
			calculate();
			memory.add(result);
		});
		
		//Function to divide the number by 100
		percent.setOnAction(e -> {
			setRemember();
			compute = compute.substring(0,compute.length() - remember.length());
			remember = String.valueOf(Double.valueOf(remember) / 100);
			compute += remember;
			display += "%";
			textField.setText(display);
			remember = "";			
		});
		
		//Function to calculate square root
		root.setOnAction( e -> {
			setRemember();			
			display = display.substring(0,display.length() - remember.length());
			compute = compute.substring(0,compute.length() - remember.length());
			display += "√"+remember;
			remember = String.valueOf(Math.sqrt(Double.valueOf(remember)));	
			textField.setText(display);			
			compute += remember;
			remember = "";			
		});
		
		//Funtion to divide the number and if number is 0, display error
		divide1.setOnAction(e -> {
			setRemember();
			display = display.substring(0,display.length() - remember.length());
			compute = compute.substring(0,compute.length() - remember.length());
			display += "1/"+remember;
			if((Double.valueOf(remember)) == 0)
				symbol = 'e';
			else{
				remember = String.valueOf(1/(Double.valueOf(remember)));
				compute += remember;
			}					
			textField.setText(display);				
			remember = "";			
		});
		
		//Function to change plus or minus sign
		mark.setOnAction(e -> {
			setRemember();			
			if(symbol == 'b'){
				calculate();
				result *= (-1);
				display = String.valueOf(result);
				compute = display;
				textField.setText(display);
			}
			remember = "";						
		});
	}
	
	//Mutator method to select number form compute and store in remember
	public void setRemember(){			
		for(int i = 1+compute.lastIndexOf(symbol); i < compute.length();i++){
			remember += compute.charAt(i);	
		}			
	}
	
	//Method to calculate
	public void calculate(){		
		switch(symbol){
			case '+':				
				result += Double.valueOf(remember);
				break;
			case '-':
				result -= Double.valueOf(remember);
				break;
			case 'x':
				result *= Double.valueOf(remember);
				break;
			case '÷':
				result /= Double.valueOf(remember);
				break;
			case '√':
				result = Math.sqrt(Double.valueOf(remember));
				break;
			case 'e':
				display = "ERROR";				
				break;
			case 'b':
				result = Double.valueOf(remember);
				break;
		}
		remember = "";		
	}
	
	//Calculate the result
	public void calculateMemory(){
		memory_result = memory.get(0);
		for(int i = 0; i < memory_symbol.size();i++){
			if(memory_symbol.get(i) == "+"){
				memory_result += memory.get(i+1);
			}
			else{
				memory_result -= memory.get(i+1);
			}				
		}
	}
}
