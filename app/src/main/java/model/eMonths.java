package model;
public enum eMonths
{
	January ("January"),
	February ("February"),
	March ("March"),
	April ("April"),
	May ("May"),
	June ("June"),
	July ("July"),
	August ("August"),
	September ("September"),
	October ("October"),
	November ("November"),
	December ("December");
	
    private final String name;       

    private eMonths(String s)
    {
        name = s;
    }

    public boolean equalsName(String otherName) 
    { 
        return name.equals(otherName);
    }

    public String toString() 
    {
       return this.name;
    }
}
