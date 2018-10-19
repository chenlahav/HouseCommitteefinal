package model;
import java.io.Serializable;
import java.security.InvalidParameterException;

public class Committee extends User implements Serializable
{
	protected int m_Seniority;
	protected  eRole m_Role;

	public Committee(String i_FirstName, String i_LastName, String i_ID, int i_Seniority, String i_Email)
	{
		super(i_FirstName, i_LastName, i_ID, i_Email);
		SetSeniority(i_Seniority);
		m_Role = eRole.Committee;
	}
	
	public void SetSeniority(int i_Seniority)
	{
//		if(i_Seniority < 0)
//		{
//			throw new InvalidParameterException("Seniority must be 0 or more.");
//		}
		
		m_Seniority = i_Seniority;
	}
	
	public int GetSeniority()
	{
		return m_Seniority;
	}

//	public String toString()
//	{
//		return super.toString() + "Seniority: " + m_Seniority;
//		//return "First Name: " + m_FirstName + ", Last Name: " + m_LastName + ", ID: " + m_ID;
//	}
}
