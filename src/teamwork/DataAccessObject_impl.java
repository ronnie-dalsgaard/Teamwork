package teamwork;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataAccessObject_impl {
    private static final boolean DEBUG = true;
    private DBConnector connector = null;

    DataAccessObject_impl(DBConnector connector) {
        this.connector = connector;
    }
    
    // User
    public ArrayList<User> getUsers(){
        try {
            Statement statement = connector.getConnection().createStatement();
            String query = 
                      "SELECT * "
                    + "FROM `user`;";
            ResultSet res = statement.executeQuery(query);
            ArrayList<User> users = new ArrayList<>();
            while(res.next()){
                int id = res.getInt("user_id");
                String username = res.getString("username");
                String password = res.getString("password");
                boolean admin = res.getBoolean("admin");
                User user = new User(id, username, password, admin);
                users.add(user);
            }
            return users;
        } catch (SQLException ex) {
            if(DEBUG) ex.printStackTrace();
            System.out.println("Unable to retrieve data from DB!");
            System.exit(0);
            return null;
        }
    }
    public User getUser(int id){
        try {
            Statement statement = connector.getConnection().createStatement();
            String query = 
                      "SELECT * "
                    + "FROM `user` "
                    + "WHERE `user_id` = "+id+";";
            ResultSet res = statement.executeQuery(query);
            User user = null;
            if(res.next()){
                String username = res.getString("username");
                String password = res.getString("password");
                boolean admin = res.getBoolean("admin");
                user = new User(id, username, password, admin);
            }
            return user;
        } catch (SQLException ex) {
            if(DEBUG) ex.printStackTrace();
            System.out.println("Unable to retrieve data from DB!");
            System.exit(0);
            return null;
        }
    }
    public User getUser(String username){
        try {
            Statement statement = connector.getConnection().createStatement();
            String query = 
                      "SELECT * "
                    + "FROM `user` "
                    + "WHERE `username` = '"+username+"';";
            ResultSet res = statement.executeQuery(query);
            User user = null;
            if(res.next()){
                int id = res.getInt("user_id");
                String password = res.getString("password");
                boolean admin = res.getBoolean("admin");
                user = new User(id, username, password, admin);
            }
            return user;
        } catch (SQLException ex) {
            if(DEBUG) ex.printStackTrace();
            System.out.println("Unable to retrieve data from DB!");
            System.exit(0);
            return null;
        }
    }
    
    // Team
    public ArrayList<Team> getTeams(){
        try {
            Statement statement = connector.getConnection().createStatement();
            String query = 
                      "SELECT * "
                    + "FROM `team`;";
            ResultSet res = statement.executeQuery(query);
            ArrayList<Team> teams = new ArrayList<>();
            while(res.next()){
                int id = res.getInt("team_id");
                String teamname = res.getString("teamname");
                ArrayList<User> members = getTeamMembers(id);
                Team team = new Team(id, teamname, members);
                teams.add(team);
            }
            return teams;
        } catch (SQLException ex) {
            if(DEBUG) ex.printStackTrace();
            System.out.println("Unable to retrieve data from DB!");
            System.exit(0);
            return null;
        }
    }
    public Team getTeam(int id){
        try {
            Statement statement = connector.getConnection().createStatement();
            String query = 
                      "SELECT * "
                    + "FROM `team` "
                    + "WHERE `team_id` = '"+id+"';";
            ResultSet res = statement.executeQuery(query);
            Team team = null;
            if(res.next()){
                String teamname = res.getString("teamname");
                ArrayList<User> members = getTeamMembers(id);
                team = new Team(id, teamname, members);
            }
            return team;
        } catch (SQLException ex) {
            if(DEBUG) ex.printStackTrace();
            System.out.println("Unable to retrieve data from DB!");
            System.exit(0);
            return null;
        }
    }
    public Team getTeam(String teamname){
        try {
            Statement statement = connector.getConnection().createStatement();
            String query = 
                      "SELECT * "
                    + "FROM `team` "
                    + "WHERE `teamname` = '"+teamname+"';";
            ResultSet res = statement.executeQuery(query);
            Team team = null;
            if(res.next()){
                int id = res.getInt("team_id");
                ArrayList<User> members = getTeamMembers(id);
                team = new Team(id, teamname, members);
            }
            return team;
        } catch (SQLException ex) {
            if(DEBUG) ex.printStackTrace();
            System.out.println("Unable to retrieve data from DB!");
            System.exit(0);
            return null;
        }
    }
    public ArrayList<User> getTeamMembers(int team_id){
        try {
            Statement statement = connector.getConnection().createStatement();
            String query = 
                      "SELECT * "
                    + "FROM `team_member` NATURAL JOIN `user` "
                    + "WHERE `team_id` = '"+team_id+"';";
            ResultSet res = statement.executeQuery(query);
            ArrayList<User> users = new ArrayList<>();
            while(res.next()){
                int id = res.getInt("user_id");
                String username = res.getString("username");
                String password = res.getString("password");
                boolean admin = res.getBoolean("admin");
                User user = new User(id, username, password, admin);
                users.add(user);
            }
            return users;
        } catch (SQLException ex) {
            if(DEBUG) ex.printStackTrace();
            System.out.println("Unable to retrieve data from DB!");
            System.exit(0);
            return null;
        }
    }
    
}
