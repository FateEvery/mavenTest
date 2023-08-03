package springtest4.jdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {
    /**
     * 对第i行的ResultSet 转化成 T 对象  这个具体的实现由用户完成
     *
     * @param rs
     * @param i
     * @return
     * @throws SQLException
     */
    public T mapper(ResultSet rs, int i) throws SQLException;
}
