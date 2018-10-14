package model;
import java.io.Serializable;

public class Request implements Serializable 
{
	private static final long serialVersionUID = -4137284727528762260L;
	
	private eRequests m_RequestType;
	private String[] m_Args;
	
	public Request(eRequests type, String[] args)
	{
		m_RequestType = type;
		m_Args = args;
	}
	
	@Override
	public String toString() 
	{
		// Will return: requestType_arg1,args2,...,argn
		StringBuilder str = new StringBuilder();
		str.append(m_RequestType.GetValue() + "_");
		
		if(m_Args != null && m_Args.length > 0)
		{
			for (String arg : m_Args) 
			{
				str.append(arg + ",");
			}
			
			str.deleteCharAt(str.length() - 1); // Delete last ','
		}
		
		return str.toString();
	}
}
