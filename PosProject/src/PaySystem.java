
public class PaySystem {
	public PaySystem(){}
	
	public void getPayMentEmail(String toEmail){
		PayMentEmail pay=new PayMentEmail();
		pay.SMTP(toEmail);
	}

}
