package com.mycompany.pos.util;

import org.mindrot.jbcrypt.BCrypt;

public class HashUtil {
    public String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    public Boolean checkIfPasswordMatched(String candidate, String hashed) {
        if (BCrypt.checkpw(candidate, hashed))
            return true;
        return false;
    }
}
