package teamwork;

import java.util.ArrayList;

public class Team {
    private int id;
    private String name;
    private ArrayList<User> members;
    
    
    public Team(int id, String name) {
        this(id, name, new ArrayList<>());
    }
    
    public Team(int id, String name, ArrayList<User> members) {
        this.id = id;
        this.name = name;
        this.members = members;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public ArrayList<User> getMembers(){ return members; }
    public void setMembers(ArrayList<User> members){ this.members = members; }
    public void addMember(User user) { members.add(user); }

    @Override
    public String toString() {
        return "Team{" + "id=" + id + ", name=" + name + ", members=" + members + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Team other = (Team) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}