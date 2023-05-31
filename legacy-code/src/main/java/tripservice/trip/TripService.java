package tripservice.trip;

import java.util.ArrayList;
import java.util.List;

import tripservice.exception.UserNotLoggedInException;
import tripservice.user.User;
import tripservice.user.UserSession;

public class TripService {

    public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
        User loggedUser = UserSession.getInstance().getLoggedUser();
        return getTripsByUser(user, loggedUser);
    }

    List<Trip> getTripsByUser(User user, User loggedInUser) {
        validate(loggedInUser);
        return user.isFriendsWith(loggedInUser) ?
                findTripsBy(user) :
                new ArrayList<>();
    }

    private void validate(User loggedInUser) {
        if (loggedInUser == null) {
            throw new UserNotLoggedInException();
        }
    }

    List<Trip> findTripsBy(User user) {
        return TripDAO.findTripsByUser(user);
    }

}
