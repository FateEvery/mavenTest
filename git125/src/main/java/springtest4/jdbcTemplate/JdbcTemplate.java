package springtest4.jdbcTemplate;

import springtest4.dataSource.MyDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: mavenProject
 * @description: 模板类
 * @author: Joker
 * @create: 2023-07-26 20:18
 */
public abstract class JdbcTemplate<T> {
    private DataSource dataSource; //数据源

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 查询的模板方法
     *
     * @param sql
     * @param rowMapper
     * @param params
     * @return
     */
    public List<T> executeQuery(String sql, RowMapper<?> rowMapper, Object... params) {
        //模板方法
        List<T> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            //1.连接池中获取连接
            con = dataSource.getConnection();
            //2.创建语句对象 PreparedStatement
            pstmt = con.prepareStatement(sql);
            //3.设置参数
            setParams(pstmt, params);
            //4. 查询
            rs = pstmt.executeQuery();
            //5.循环 resultSet
            int i = 0;
            while (rs.next()) {
                T t = (T) rowMapper.mapper(rs, i);
                i++;
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != rs) {
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            ((MyDataSource) dataSource).returnConnection(con);
        }
        return list;
    }

    private void setParams(PreparedStatement stmt, Object... params) throws SQLException {
        if (null == params || params.length <= 0) {
            return;
        }
        for (int i = 0; i < params.length; i++) {
            stmt.setObject(i + 1, params[i]); // ? 从1开始 第一个参数 i+1
        }
    }
}
