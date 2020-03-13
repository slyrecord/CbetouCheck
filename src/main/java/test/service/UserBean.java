package test.service;



import test.DTO.User;
import test.Mappers.UserMapper;
import org.apache.ibatis.session.SqlSession;
import test.service.MyBatisUtil;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UserBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private List<User> users;
    private User selectedUser;

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }


    public String getName() {
        return name;
    }

    public List<User> getUsers() {

        getAllUsers();

        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


    public void insertUser(User user)
    {
        //System.out.println(MyBatisUtil.getSqlSessionFactory());
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try
        {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            System.out.println(user);
            userMapper.insertUser(user);
            sqlSession.commit();
        } finally
        {
            sqlSession.close();
        }
    }

    public void setName(String name)
    {
        System.out.println("was here");
        SqlSession sqlSession = null;
        try
        {
            sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
            System.out.println("was here222");
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            System.out.println("was here222");
            this.name = userMapper.getUserById(1).getUserName();
            System.out.println("was here222");
        }
        catch (Exception e){
            System.out.println("was here111");
            e.printStackTrace();
        } finally
        {
            sqlSession.close();
        }
    }

    public void getAllUsers()
    {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try
        {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            this.users = userMapper.getAllUsers();
        } finally
        {
            sqlSession.close();
        }
    }

    public void updateUser(User user)
    {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try
        {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.updateUser(user);
            sqlSession.commit();
        } finally
        {
            sqlSession.close();
        }
    }

    public void deleteUser(Integer userId)
    {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try
        {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.deleteUser(userId);
            sqlSession.commit();
        } finally
        {
            sqlSession.close();
        }
    }

}