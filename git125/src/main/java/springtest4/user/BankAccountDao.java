package springtest4.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springtest4.jdbcTemplate.JdbcTemplate;
import springtest4.jdbcTemplate.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-07-26 21:06
 */
@Repository
public class BankAccountDao extends JdbcTemplate {
    @Autowired //按类型注入 DataSource接口 -> MDataSource 的实现类
    public BankAccountDao(DataSource dataSource) {
        super(dataSource);
    }

    public List<BankAccount> findALl() {
        return super.executeQuery("select * from bank where id = ?", new RowMapper<BankAccount>() {
            @Override
            public BankAccount mapper(ResultSet rs, int i) throws SQLException {
                BankAccount ba = new BankAccount();
                ba.setId(rs.getInt(1));
                ba.setBalance(rs.getDouble(2));
                return ba;
            }
        }, 2);
    }
}
