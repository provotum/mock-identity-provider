package org.provotum.mockidentityprovider.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.provotum.mockidentityprovider.model.Wallet;

import java.util.List;

public class WalletRequest {

    private List<Wallet> wallets;

    public WalletRequest(@JsonProperty("wallets") List<Wallet> wallets) {
        this.wallets = wallets;
    }

    public List<Wallet> getWallets() {
        return wallets;
    }
}
