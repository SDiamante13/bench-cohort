package tripservice.user;

import java.util.ArrayList;
import java.util.List;

import tripservice.trip.Trip;

public class User {

	private List<Trip> trips = new ArrayList<>();
	private List<User> friends = new ArrayList<>();

	public void addFriend(User user) {
		friends.add(user);
	}

	public void addTrip(Trip trip) {
		trips.add(trip);
	}
	
	public List<Trip> trips() {
		return trips;
	}

	public boolean isFriendsWith(User loggedInUser) {
		return friends
				.stream()
				.anyMatch(friend -> friend.equals(loggedInUser));
	}
}
