package model;
public enum eResidentsTableCols
{
	ID(1),
	FirstName(2),
	LastName(3),
	AptNumber(4),
	MonthlyPayment(5);
	
	private int m_Value;
	
	eResidentsTableCols(int value)
	{
		m_Value = value;
	}
	
	public int GetValue()
	{
		return m_Value;
	}
}
