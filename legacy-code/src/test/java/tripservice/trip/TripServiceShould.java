package tripservice.trip;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tripservice.exception.UserNotLoggedInException;
import tripservice.user.User;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

class TripServiceShould {

    private TripService tripService = Mockito.spy(new TripService());

    @Test
    void returnsNoTripsForASearchedUserWithNoFriends() {
        User searchedUser = new User();
        User loggedInUser = new User();

        List<Trip> trips = tripService.getTripsByUser(searchedUser, loggedInUser);

        assertThat(trips).isEmpty();
    }

    @Test
    void throwsExceptionWhenTheUserIsNotLoggedIn() {
        User searchedUser = new User();
        User notLoggedInUser = null;

        assertThrows(UserNotLoggedInException.class,
                () -> tripService.getTripsByUser(searchedUser, notLoggedInUser));
    }

    @Test
    void returnsNoTripsWhenSearchedUserIsNotFriendsWithLoggedInUser() {
        User searchedUser = new User();
        User loggedInUser = new User();
        searchedUser.addFriend(new User());

        List<Trip> trips = tripService.getTripsByUser(searchedUser, loggedInUser);

        assertThat(trips).isEmpty();
    }

    @Test
    void returnsTripsOfSearchedUserWhenTheyAreFriendsWithTheLoggedInUser() {
        User searchedUser = new User();
        User loggedInUser = new User();
        searchedUser.addFriend(loggedInUser);
        List<Trip> expectedTrips = List.of(new Trip());
        stub(expectedTrips);

        List<Trip> trips = tripService.getTripsByUser(searchedUser, loggedInUser);

        assertThat(trips).isEqualTo(expectedTrips);
    }

    private void stub(List<Trip> expectedTrips) {
        doReturn(expectedTrips)
                .when(tripService)
                .findTripsBy(any(User.class));
    }
}
