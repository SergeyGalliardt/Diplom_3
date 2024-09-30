package UserData;

import org.apache.commons.lang3.RandomStringUtils;

public class DataGenerate {
    public static User makeNewUser() {
        return new User(RandomStringUtils.randomAlphanumeric(22) + "@yandex.ru", "password", "Username");
    }
    public static User makeUserWithShortPassword() {
        return new User(RandomStringUtils.randomAlphanumeric(22) + "@yandex.ru", "passw", "Username");
    }
}
