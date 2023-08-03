package springtest4.dataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.logging.Logger;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-07-26 11:40
 */
@Component
public class MyDataSource implements DataSource {

    private ConcurrentLinkedDeque<MyConnection> pool;
    @Value("${coreSize}")
    private int coreSize;
    @Value("${mysql.username}")
    private String username;
    @Value("${mysql.password}")
    private String password;
    @Value("${mysql.url}")
    private String url;

    public MyDataSource() {
        System.out.println("MyDataSource的构造方法");
    }

    @PostConstruct  //此方法在 构造方法执行后执行  => 即初始化连接池
    public void init() throws SQLException {
        System.out.println("MyDataSource的init()");
        pool = new ConcurrentLinkedDeque<>();
        for (int i = 0; i < coreSize; i++) {
            MyConnection mc = new MyConnection();
            mc.statue = false;
            mc.conn = DriverManager.getConnection(url, username, password);
            pool.add(mc);
        }
    }


    class MyConnection {
        Connection conn;
        boolean statue;
    }

    @Override
    public Connection getConnection() throws SQLException {
        do {
            MyConnection mc = this.pool.poll();
            if (mc == null) {
                return null;
            }
            if (!mc.statue) {
                return mc.conn;
            }
        } while (true);
    }

    public void returnConnection(Connection con) {
        MyConnection mc = new MyConnection();
        mc.statue = false;
        mc.conn = con;
        this.pool.add(mc);
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
