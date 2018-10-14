package model;
public enum eUsersTypes
{
	Resident(1),
	Committee(2);
	
	private int m_Value;
	
	eUsersTypes(int value)
	{
		m_Value = value;
	}
	
	public int GetValue()
	{
		return m_Value;
	}
}
