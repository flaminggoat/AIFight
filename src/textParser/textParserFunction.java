package textParser;

public class textParserFunction {

	enum param
	{
		ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, BLOCKED, EDGE
	}
	enum function
	{
		IF, JUMP, RUN, STOP, DELAY, ELSE, ENDIF, NONE
	}
	
	param parameter;
	function function;
	public textParserFunction (function Function)
	{	
		parameter = param.ONE;
		function = Function;
	}
	public param getParam()
	{
		return parameter;
	}
	public function getFunction()
	{
		return function;
	}
	public void setParam(param Parameter)
	{
		parameter = Parameter;
	}
	public void setFunction(function Function)
	{
		function = Function;
	}
}
