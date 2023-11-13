package hello.member;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    public final JdbcTemplate jdbcTemplate;

    public MemberRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void initTable() {
        jdbcTemplate.execute("CREATE TABLE MEMBER (MEMBER_ID VARCHAR(255) NOT NULL PRIMARY KEY , NAME VARCHAR(255))");
    }

    public void save(Member member) {
        jdbcTemplate.update("INSERT INTO MEMBER (MEMBER_ID, NAME) VALUES (?, ?)", member.getMemberId(), member.getName());
    }

    public Member findById(String memberId) {
        return jdbcTemplate.queryForObject("SELECT * FROM MEMBER WHERE MEMBER_ID = ?",
                BeanPropertyRowMapper.newInstance(Member.class),
                memberId);
    }

    public List<Member> findAll() {
        return jdbcTemplate.query("SELECT * FROM MEMBER",
                BeanPropertyRowMapper.newInstance(Member.class));
    }
}
