package model;
import java.security.InvalidParameterException;

public abstract class User
{
	protected String m_FirstName;
	protected String m_LastName;
	//protected String m_Password;
	protected String m_ID;

	public User(){}

	public User(String i_FirstName, String i_LastName, String i_ID)
	{
		setID(i_ID);
		setName(i_FirstName, i_LastName);
	}
	
	public String GetName()
	{
		return m_FirstName + " " + m_LastName;
	}
/*	
	public User CreateNewUser(eUsersTypes userType, User user)
	{
		return (userType == eUsersTypes.Resident) ? new Resident(user.m_FirstName, user.m_LastName, user.m_ID, user.m_Password, user.m_ApartmentNumber) :
													new Commitee()
	}*/
	
	private void setName(String i_FirstName, String i_LastName)
	{
		if(!isValidString(i_FirstName) || !isValidString(i_LastName))
		{
			throw new InvalidParameterException("Invalid Name.");
		}
		
		m_FirstName = i_FirstName;
		m_LastName = i_LastName;
	}
	
//	public String GetPassword()
//	{
//		return m_Password;
//	}
	
//	public void SetPassword(String i_NewPassword) throws InvalidParameterException
//	{
//		if(!isValidString(i_NewPassword))
//		{
//			throw new InvalidParameterException("Invalid Password.");
//		}
//        /*else if(i_NewPassword.equals(m_Password))
//		{
//			throw new OperationNotSupportedException("New password can't be the same as the current password");
//		}*/
//
//		m_Password = i_NewPassword;
//	}
	
//	public String toString()
//	{
//		return "First Name: " + m_FirstName + ", Last Name: " + m_LastName + ", ID: " + m_ID;
//	}
//
	private void setID(String i_ID)
	{
		if(!isValidString(i_ID))
		{
			throw new InvalidParameterException("Invalid ID.");
		}

		m_ID = i_ID;
	}
	
	public String GetID()
	{
		return m_ID;
	}
	
	private boolean isValidString(String i_StrToCheck)
	{
		return (i_StrToCheck != null && !i_StrToCheck.isEmpty() && i_StrToCheck.trim().length() > 0 /*Not only whitespace*/);
	}
}
