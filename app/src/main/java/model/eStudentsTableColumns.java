package model;
public enum eStudentsTableColumns 
{
	ID(1),
	Name(2),
	Age(3),
	Phone(4),
	StudyYear(5),
	Debt(6);
	private int numVal;
	
	eStudentsTableColumns(int value)
	{
		numVal = value;
	}
	
    public int getValue() 
    {
        return numVal;
    }
}
