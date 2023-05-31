package tripservice.trip;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import tripservice.exception.UserNotLoggedInException;
import tripservice.user.User;
import tripservice.user.UserSession;

public class TripService {

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		User loggedUser = UserSession.getInstance().getLoggedUser();
		return getTripsByUser(user, loggedUser);
	}

	List<Trip> getTripsByUser(User user, User loggedUser) {
		List<Trip> tripList = new ArrayList<Trip>();
		boolean isFriend = false;
		if (loggedUser != null) {
			for (User friend : user.getFriends()) {
				if (friend.equals(loggedUser)) {
					isFriend = true;
					break;
				}
			}
			if (isFriend) {
				tripList = findTripsBy(user);
			}
			return tripList;
		} else {
			throw new UserNotLoggedInException();
		}
	}

	List<Trip> findTripsBy(User user) {
		return TripDAO.findTripsByUser(user);
	}

}
