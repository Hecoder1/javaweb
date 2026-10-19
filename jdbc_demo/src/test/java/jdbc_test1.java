import org.junit.jupiter.api.Test;
import java.sql.*;

public class jdbc_test1 {
    @Test
    public void test1() {
        String url = "jdbc:mysql://localhost:3306/你的数据库";
        String username = "root";
        String dbPassword = "你的密码";


        try (Connection connection = DriverManager.getConnection(
                url, username, dbPassword)) {
            //编写sql语句
            String sql = "update user set password=? ,name=?,age=? where id=?";

            //获取PreparedStatement对象
            PreparedStatement pstmt = connection.prepareStatement(sql);

            //设置参数
            pstmt.setString(1, "666888");
            pstmt.setString(2, "大乔");
            pstmt.setInt(3, 32);
            pstmt.setInt(4, 4);


            //执行更新
            int rows = pstmt.executeUpdate();

            //输出结果
            System.out.println("成功更新" + rows + "条记录");

            pstmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Test
    public void test2() {
        String url = "jdbc:mysql://localhost:3306/你的数据库";
        String username = "root";
        String dbPassword = "你的密码";

        //编写sql语句
        String sql = "select id,username,password,name,age "+"from user where age>= ? and id<=?";

        try (Connection connection = DriverManager.getConnection(
                url, username, dbPassword)) {

            //获取PreparedStatement对象
            PreparedStatement pstmt = connection.prepareStatement(sql);

            //设置参数(从一开始)

            pstmt.setInt(1, 2);
            pstmt.setInt(2, 18);


            //执行更新
            try(ResultSet rs = pstmt.executeQuery()){
                //遍历结果集
                while(rs.next()){
                    //将查到的每条记录封装成user对象
                    User user = new User(
                            rs.getInt("id"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("name"),
                            rs.getInt("age")
                    );

                    //输出
                    System.out.println(user);
                }
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}