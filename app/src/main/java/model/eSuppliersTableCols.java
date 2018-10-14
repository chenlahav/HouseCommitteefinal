package model;
public enum eSuppliersTableCols 
{
	ID(1),
	Name(2),
	Availability(3),
	Quality(4),
	Price(5),
	Phone(6);
	
	private int m_Value;
	
	eSuppliersTableCols(int value)
	{
		m_Value = value;
	}
	
	public int GetValue()
	{
		return m_Value;
	}
}
