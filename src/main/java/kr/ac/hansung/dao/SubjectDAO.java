package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.CreditsPerSemester;
import kr.ac.hansung.model.Subject;

@Repository
public class SubjectDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Subject> getOffers() {
		String sqlStatement = "select * from subjects";

		return jdbcTemplate.query(sqlStatement, new RowMapper<Subject>() {

			@Override
			public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
				Subject subject = new Subject();

				subject.setYear(rs.getInt("year"));
				subject.setSemester(rs.getInt("semester"));
				subject.setCode(rs.getString("code"));
				subject.setTitle(rs.getString("title"));
				subject.setDivision(rs.getString("division"));
				subject.setCredit(rs.getInt("credit"));

				return subject;
			}
		});
	}
	
	
	public boolean insert(Subject subject) {
		String code = subject.getCode();
		String title = subject.getTitle();
		String division = subject.getDivision();
		int credit = subject.getCredit();

		String sqlStatement = "insert into subjects (year, semester, code, title, division, credit) values(2019, 1, ?, ?, ?, ?)";

		return (jdbcTemplate.update(sqlStatement, new Object[] { code, title, division, credit }) == 1);
	}
	
	
	public List<CreditsPerSemester> getCreditsPerSemester() {
		String sqlStatement = "select year, semester, sum(credit) from subjects group by year, semester";

		return jdbcTemplate.query(sqlStatement, new RowMapper<CreditsPerSemester>() {

			@Override
			public CreditsPerSemester mapRow(ResultSet rs, int rowNum) throws SQLException {
				CreditsPerSemester creditsPerSemester=new CreditsPerSemester();

				creditsPerSemester.setYear(rs.getInt("year"));
				creditsPerSemester.setSemester(rs.getInt("semester"));
				creditsPerSemester.setTotalCredit(rs.getInt("sum(credit)"));

				return creditsPerSemester;
			}
		});
	}
}
