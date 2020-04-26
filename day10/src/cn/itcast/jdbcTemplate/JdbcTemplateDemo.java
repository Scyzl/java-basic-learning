package cn.itcast.jdbcTemplate;

import cn.itcast.dataSource.utils.JDBCUtils;
import cn.itcast.student.Student;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JdbcTemplateDemo {
    // 获取JdbcTemplate对象
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getPool());
    // Junit 单元测试 @Test

    /**
     * 修改学号为201001的学生的年龄
     */
    @Test
    public void test1() {
        // 获取JdbcTemplate对象
//        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getPool());

        String sql = "update student set age = ? where sid = ?";
        int num = template.update(sql, 16, 201001);
        System.out.println("此次操作一共影响了" + num + "行数据。");
    }

    /**
     * 添加一条记录
     */
    @Test
    public void test2() {
//        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getPool());
        String sql = "insert into student values(?, ?, ?, ?)";
        int num = template.update(sql, 201004, "Kobe", 24, 19970526);
        System.out.println("此次操作一共影响了" + num + "行数据。");
    }

    /**
     * 删除刚才添加的记录
     */
    @Test
    public void test3() {
        String sql = "delete from student where sid = ?";
        int num = template.update(sql, 201004);
        System.out.println("此次操作一共影响了" + num + "行数据。");
    }

    /**
     * 查询学号为 201002 的学生，将其封装为Map集合，列名为key，值为value
     *  queryForMap() 方法查询的结果长度只能是 1
     */
    @Test
    public void test4() {
        String sql = "select * from student where sid = ?";
        Map<String, Object> map = template.queryForMap(sql, 201002);
        System.out.println(map);
    }

    /**
     * 查询所有记录，将其封装为 list
     *  queryForList() 方法将每一条查询结果记录封装成Map，再Map集合装载到一个list集合
     */
    @Test
    public void test5() {
        String sql = "select * from student";
        List<Map<String, Object>> list = template.queryForList(sql);

        for (Map<String, Object> map : list) {
            System.out.println(map);
        }
    }

    /**
     * 查询所有记录，将其封装称为JavaBean对象（这里是Student对象）的list集合
     */
    @Test
    public void test6_1() {
        String sql = "select * from student";
        List<Student> list = template.query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student student = new Student();
                student.setSid(resultSet.getInt("sid"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                student.setBirthday(resultSet.getDate("birthday"));

                return student;
            }
        });

        for (Student s : list) {
            System.out.println(s);
        }
    }

    /**
     * 查询所有记录，将其封装称为JavaBean对象（这里是Student对象）的list集合
     *  使用 BeanPropertyRowMapper<类型>(类型.class) 实现类，完成查询结果数据到JavaBean对象的封装
     */
    @Test
    public void test6_2() {
        String sql = "select * from student";
        List<Student> list = template.query(sql, new BeanPropertyRowMapper<Student>(Student.class));

        for (Student s : list) {
            System.out.println(s);
        }
    }

    /**
     * 查询总记录数
     */
    @Test
    public void test7() {
        String sql = "select count(distinct sid) from student";
        Long aLong = template.queryForObject(sql, Long.class);
        System.out.println("总记录数： " + aLong);

    }
}
