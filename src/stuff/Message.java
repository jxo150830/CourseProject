package stuff;

public class Message {
	private Customer sender;
	private Customer receiver;
	private String date;
	private String subject;
	private String body;
	
	public Customer getSender() { return sender; }
	public void setSender(Customer sender) { this.sender = sender; }
	
	public Customer getReceiver() { return receiver; }
	public void setReceiver(Customer receiver) { this.receiver = receiver; }
	
	public String getDate() { return date; }
	public void setDate(String date) { this.date = date; }
	
	public String getSubject() { return subject; }
	public void setSubject(String subject) { this.subject = subject; }
	
	public String getBody() { return body; }
	public void setBody(String body) { this.body = body; }
}