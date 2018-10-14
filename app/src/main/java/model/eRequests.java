package model;
public enum eRequests 
{
	Login(1),
	UpdatePassword(2),
	SignUp(3),
	ResidentPaymentDetails(4), 	// Committee ONLY
	BuildingPaymentDetails(5), 	// Committee ONLY
	PaymentUpdate(6), 			// Committee ONLY
	MonthlyIncome(7), 			// Committee ONLY
	ShowAllSuppliers(8), 		// Committee ONLY
	ShowOptimalSupplier(9), 	// Committee ONLY
	UpdateSupplierDetails(10), 	// Committee ONLY
	ShowAllPayments(11); 		// Resident ONLY
	
	private int m_Value;
	
	eRequests(int value)
	{
		m_Value = value;
	}
	
	public int GetValue()
	{
		return m_Value;
	}
}
