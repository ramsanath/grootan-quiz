package com.grootan.quiz.model.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class JwtClaim implements Serializable {
    private String userId;

    public JwtClaim(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Map<String, Object> toMap() {
        return new HashMap<String, Object>() {{
            put("userId", userId);
        }};
    }

    public static JwtClaim fromMap(Map<String, Object> map) {
        return new JwtClaim((String) map.get("userId"));
    }
}
