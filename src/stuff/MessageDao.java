package stuff;

import java.util.List;

public interface MessageDao {
	public int createMessage(Message m);

	public List<Message> getMessages(String id);
}