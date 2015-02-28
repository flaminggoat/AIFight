package textParser;

import java.util.ArrayList;
import javax.swing.JLabel;

import textParser.textParserFunction.function;
import textParser.textParserFunction.param;

public class textParserFunctionator
{
	public ArrayList <textParserFunction> functions = new ArrayList <textParserFunction>();
	
	public ArrayList<textParserFunction> textParserFunctionator(ArrayList<JLabel> labels)
	{
		for (int i = 0; i < labels.size(); i++)
		{
			JLabel selection = labels.get(i);
			String text = selection.getText();
			switch(text){
			case "RUN":
				functions.add(new textParserFunction(function.RUN));
				break;
			case "STOP":
				functions.add(new textParserFunction(function.STOP));
				break;
			case "JUMP":
				functions.add(new textParserFunction(function.JUMP));
				break;
			case "DELAY":
				functions.add(new textParserFunction(function.DELAY));
				break;
			case "IF":
				functions.add(new textParserFunction(function.IF));
				break;
			case "ELSE":
				functions.add(new textParserFunction(function.ELSE));
				break;
			case "ENDIF":
				functions.add(new textParserFunction(function.ENDIF));
				break;
			case "BLOCKED":
				functions.get(functions.size()).setParam(param.BLOCKED);
				break;
			case "EDGE":
				functions.get(functions.size()).setParam(param.EDGE);
				break;
			case "1":
				functions.get(functions.size()).setParam(param.ONE);
				break;
			case "2":
				functions.get(functions.size()).setParam(param.TWO);
				break;
			case "3":
				functions.get(functions.size()).setParam(param.THREE);
				break;
			case "4":
				functions.get(functions.size()).setParam(param.FOUR);
				break;
			case "5":
				functions.get(functions.size()).setParam(param.FIVE);
				break;
			case "6":
				functions.get(functions.size()).setParam(param.SIX);
				break;
			case "7":
				functions.get(functions.size()).setParam(param.SEVEN);
				break;
			case "8":
				functions.get(functions.size()).setParam(param.EIGHT);
				break;
			case "9":
				functions.get(functions.size()).setParam(param.NINE);
				break;
			case "10":
				functions.get(functions.size()).setParam(param.TEN);
				break;
			default:
				break;				
			}			
		}
		return functions;
	}
	
}
