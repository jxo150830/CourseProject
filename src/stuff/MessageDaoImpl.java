package stuff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DbManager;

public class MessageDaoImpl implements MessageDao {
	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();

	@Override
	public int createMessage(Message m) {
		int status = 0;
		try {
			conn = db.getConnection();
			ps = conn.prepareStatement("INSERT INTO message VALUES (?,?,?,?,?)");
			ps.setInt(1, m.getSender().getId());
			ps.setInt(2, m.getReceiver().getId());
			ps.setString(3, m.getDate());
			ps.setString(4, m.getSubject());
			ps.setString(5, m.getBody());
			status = ps.executeUpdate();
			conn.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}

	@Override
	public List<Message> getMessages(String id) {
		CustomerDao customerDao = new CustomerDaoImpl();
		List<Message> messages = new ArrayList<Message>();
		try {
			conn = db.getConnection();
			ps = conn.prepareStatement("SELECT * FROM message WHERE receiver_id=?");
			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();
			for (int i = 0; rs.next(); i++) {
				messages.add(new Message());
				messages.get(i).setSender(customerDao.getCustomer(rs.getInt(1)));
				messages.get(i).setReceiver(customerDao.getCustomer(rs.getInt(2)));
				messages.get(i).setDate(rs.getString(3));
				messages.get(i).setSubject(rs.getString(4));
				messages.get(i).setBody(rs.getString(5));
			}
			conn.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return messages;
	}
	

}