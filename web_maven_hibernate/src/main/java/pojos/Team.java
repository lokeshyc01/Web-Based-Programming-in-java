package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * id , name, abbreviation,owner,max_age,batting_avg,wickets_taken	
 */
@Entity
@Table(name="teams")
public class Team extends BaseEntity{
//	private int teamId;//PK
	@Column(length = 100,unique=true)
	private String name;
	@Column(length = 20,unique = true)
	private String abbreviation;
	@Column(length=20,nullable = false)
	private String owner;
	@Column(name="max_age")
	private int maxAge;
	@Column(name="min_batting")
	private double minBattingAvg;
	
	@Column(name="min_wicket")
	int minWicketsTaken;
	
//	team1 ====> *player
//	Terms : one,parent table,inverse(since no FK here)
	@OneToMany(mappedBy = "myTeam",cascade = CascadeType.ALL,orphanRemoval = true)
	List<Player> players = new ArrayList<>();    //initialize the collection based property to empty collection --Gavin King
	public Team() {
		// TODO Auto-generated constructor stub
	}
	
	public void addPlayer(Player player)
	{
		this.players.add(player);
		player.setTeam(this);
	}
	
	public void removePlayer(Player player)
	{
		this.players.remove(player);
		player.setTeam(null);
	}
	
	public Team(int teamId, String name, String abbreviation, String owner, int maxAge, double minBattingAvg,
			int minWicketsTaken) {
		super();
//		this.teamId = teamId;
		this.name = name;
		this.abbreviation = abbreviation;
		this.owner = owner;
		this.maxAge = maxAge;
		this.minBattingAvg = minBattingAvg;
		this.minWicketsTaken = minWicketsTaken;
	}
	
	
//
//	public int getTeamId() {
//		return teamId;
//	}
//	public void setTeamId(int teamId) {
//		this.teamId = teamId;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}
	public double getMinBattingAvg() {
		return minBattingAvg;
	}
	public void setMinBattingAvg(Double minBattingAvg) {
		if(minBattingAvg instanceof Double)
		{
			System.out.println("minBatting average setting called");			
		}
		System.out.println("not a double");
		this.minBattingAvg = minBattingAvg;
	}
	public int getMinWicketsTaken() {
		return minWicketsTaken;
	}
	public void setMinWicketsTaken(int minWicketsTaken) {
		this.minWicketsTaken = minWicketsTaken;
	}
	@Override
	public String toString() {
		return "Team [teamId=" + getId() + ", name=" + name + ", abbreviation=" + abbreviation + ", owner=" + owner
				+ ", maxAge=" + maxAge + ", minBattingAvg=" + minBattingAvg + ", minWicketsTaken=" + minWicketsTaken
				+ "]";
	}
	
}
