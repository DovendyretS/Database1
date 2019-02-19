package dal;

import dto.UserDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {

    private Connection conn;

    public UserDAO(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/s185129?"
                    + "user=s185129&password=TXhorZDbFXMG7hfo1zM1y");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserDTO getUser(int userId) throws DALException {
        try {
            Statement stm = conn.createStatement();
            stm.executeQuery("SELECT * FROM users WHERE userID = "+userId+"");
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<UserDTO> getUserList() throws DALException {
        ResultSet rs;
        try {
            Statement stm = conn.createStatement();
            rs = stm.executeQuery("SELECT * FROM users");
            ArrayList<UserDTO> users = new ArrayList<>();
            //TODO users from db into List




            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void createUser(UserDTO user) throws DALException {

        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate("INSERT INTO users VALUES("+user.getUserId()+",\""+user.getUserName()+"\",\""+user.getIni()+"\",\""+user.getRoles()+"\")");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateUser(UserDTO user) throws DALException {

    }

    @Override
    public void deleteUser(int userId) throws DALException {

        try {
            Statement stm = conn.createStatement();
            for (UserDTO user :getUserList()){
                if (userId == user.getUserId()){
                    stm.executeUpdate("DELETE FROM user WHERE userId = "+user.getUserId());
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
