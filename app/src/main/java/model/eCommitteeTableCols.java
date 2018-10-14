package model;
public enum eCommitteeTableCols
{
	ID(1),
	FirstName(2),
	LastName(3),
	Seniority(4);
	
	private int m_Value;
	
	eCommitteeTableCols(int value)
	{
		m_Value = value;
	}
	
	public int GetValue()
	{
		return m_Value;
	}
}
