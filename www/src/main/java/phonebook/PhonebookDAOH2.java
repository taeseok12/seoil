package phonebook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PhonebookDAOH2 implements PhonebookDAO {
	
	Connection conn;
	
	public PhonebookDAOH2() {
		try {
			Class.forName("org.h2.Driver");
			String url ="jdbc:h2:tcp://localhost/~/test";
			String user = "sa";
			String password = "";
			conn = DriverManager.getConnection(url, user, password);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void test() {
//		System.out.println(conn);
//		System.out.println(findAll());
//		System.out.println(findbyId(2));
		Phonebook pb = new Phonebook(0, "kim" , "010-2222-2222", "kim@my.com", "회사");
		System.out.println("result: " + insert(pb));
		System.out.println(findAll());
	}
	
	@Override
	public int insert(Phonebook pb) {
		//id는 자동으로 생성되도록 처리하시오. 현재 최대값 id를 구한 후 +1을 id 에 입력
		int id = 0;
		
		try {
			ResultSet rs = conn.createStatement().executeQuery("select max(id) max from phonebook");
			if(rs.next()) {
				id = rs.getInt("max");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		String sql = "insert into phonebook(id, name, hp, email, memo) values(?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, pb.getName());
			ps.setString(3, pb.getHp());
			ps.setString(4, pb.getEmail());
			ps.setString(5, pb.getMemo());
			int result = ps.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Phonebook> findAll() {
		String sql = "select * from phonebook";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			List<Phonebook> list = new ArrayList<Phonebook>();
			while(rs.next()) {
				Phonebook pb = new Phonebook();
				pb.setId(rs.getInt("id"));
				pb.setName(rs.getString("name"));
				pb.setHp(rs.getString("hp"));
				pb.setEmail(rs.getString("email"));
				pb.setMemo(rs.getString("memo"));
				list.add(pb);
			}
			return list;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Phonebook findbyId(int id) {
		String sql = "select * from phonebook where id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,  id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Phonebook pb = new Phonebook();
				pb.setId(id);
				pb.setName(rs.getString("name"));
				pb.setHp(rs.getString("hp"));
				pb.setEmail(rs.getString("email"));
				pb.setMemo(rs.getString("memo"));
				return pb;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int updateById(Phonebook pb) {
		String sql = "update phonebokk set name=?, hp=?, email=?, where id ";
		//시나리오: pb 객체에 수정할 내용만 입력된 상태로 전달된 경우
		//수정할 sql 문만을 별도로 만들어야 하는가?
		//null 값일 경우 기존 데이를 가지고 와서 pb 에 셋팅 후 위의 sql문 처리
		Phonebook prepb = findbyId(pb.getId()); //이전의 값을 가지고 옴
		if(pb.getName() == null) 
			pb.setName(prepb.getName());
		if(pb.getHp() == null) 
			pb.setName(prepb.getHp());
		if(pb.getEmail() == null) 
			pb.setName(prepb.getEmail());
		if(pb.getMemo() == null) 
			pb.setName(prepb.getMemo());
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pb.getName());
			ps.setString(2, pb.getHp());
			ps.setString(3, pb.getEmail());
			ps.setString(4, pb.getMemo());
			ps.setInt(5, pb.getId());
			int result = ps.executeUpdate();
			return result;
			} catch(SQLException e) {
				e.printStackTrace();
			}

		return 0;
		
		//참고사항 값이 "": 빈값, null:객체가 생성되지 않은 값
		//빈값은 name.equals(""),name == null
	}

	@Override
	public int deleteById(int id) {
		String sql = "delete from phonebook where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,  id);
			int  result = ps.executeUpdate();
			return result;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
