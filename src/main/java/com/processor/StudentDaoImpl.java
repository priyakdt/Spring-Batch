package com.processor;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class StudentDaoImpl implements StudentDao {
	public static java.sql.Date getCurrentJavaSqlDate() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	  }


	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void save(final Student record) {
		//final int prv_xwk_id = this.jdbcTemplate.queryForInt("select max(prv_xwk_id) from jv_provider_xwalk");

		
		jdbcTemplate
				.update("INSERT INTO map t (t.student_id,t.pin,t.class_id,t.section,t.grade,t.create_date,t.create_user) values(SEQUENCE_Student.NEXTVAL,?,?,?,?,?,?,?)",
						new PreparedStatementSetter() {
							public void setValues(PreparedStatement stmt)
									throws SQLException {
								//stmt.setInt(1,prv_xwk_id);
								stmt.setString(1, record.getPin());
								stmt.setString(2, record.class_id());
								stmt.setString(3,record.getSection());
								stmt.setString(4,record.getGrade());
								stmt.setTimestamp(5,new java.sql.Timestamp(System.currentTimeMillis())); 
						     	stmt.setString(6,"NULL");
						       
						     	}
								
							
			
						});
		
	}
	
	public String findByStudentId(String class_id,String section,String grade,String pin){
		String student_id= "";
			String sql = "select class_id from student.t where " +
					      "t.class_id = '" +class_id+
				            "' " +
				            "and t.section ='" +section+
				           "' and t.grade='" +grade+
				           "' and t.pin='" +pin+
				             "' ";
	List<String> certs = jdbcTemplate.queryForList(sql, String.class); 
   // System.out.println("certs.isEmpty()..."+certs.isEmpty());
	 if (certs.isEmpty())
	 {
           return student_id;
								    
	 } else {
								     
		 return certs.get(0);
								   
	     }
									
	    }

	@Override
	public String findByProviderId(String Class_id, String Section,
			String Grade, String pin) {
		// TODO Auto-generated method stub
		return null;
	}
	
}




