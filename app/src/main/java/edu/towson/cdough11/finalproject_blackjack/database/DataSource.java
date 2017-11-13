package edu.towson.cdough11.finalproject_blackjack.database;

import java.util.List;

/**
 * Created by Sips Tea on 11/6/2017.
 */

public interface DataSource {

    List<Profile> getAllProfiles();
    Profile getProfile(String name);
    void deleteProfile(Profile profile);
    void addProfile(Profile profile);
    void updateProfile(Profile originalProfile, Profile profile);

}
