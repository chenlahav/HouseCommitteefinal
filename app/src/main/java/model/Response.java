package model;
public class Response<T>
{
	private boolean m_IsAcceptedOK;
	private T m_Result;
	
	public Response(boolean isAcceptedOK, T result)
	{
		m_IsAcceptedOK = isAcceptedOK;
		m_Result = result;
	}
	
	public boolean GetAcceptedStatus()
	{
		return m_IsAcceptedOK;
	}
	
/*	public void SetAcceptedStatus(boolean isAcceptedOK) 
	{
		this.m_IsAcceptedOK = isAcceptedOK;
	}*/

	public T GetResult() 
	{
		return m_Result;
	}

/*	public void SetResult(T result) 
	{
		this.m_Result = result;
	}*/
}
