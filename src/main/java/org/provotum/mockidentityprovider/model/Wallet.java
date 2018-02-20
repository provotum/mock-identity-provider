package org.provotum.mockidentityprovider.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Wallet {

    private String privateKey;

    public Wallet(@JsonProperty("private-key") String privateKey) {
        this.privateKey = privateKey;
    }

    @JsonProperty("private-key")
    public String getPrivateKey() {
        return privateKey;
    }
}
