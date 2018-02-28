package org.provotum.mockidentityprovider.service;

import org.provotum.mockidentityprovider.model.Wallet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
public class WalletAssigner {

    private static final Logger logger = Logger.getLogger(WalletAssigner.class.getName());

    private int counter;
    private List<Wallet> wallets;

    public WalletAssigner() {
        this.wallets = new ArrayList<>();
        this.counter = 0;
    }

    public void addWallet(Wallet wallet) {
        logger.info("Adding a new wallet.");
        this.wallets.add(wallet);
    }

    public void addWallets(List<Wallet> wallets) {
        logger.info("Adding " + wallets.size() + " wallets.");
        this.wallets.addAll(wallets);
    }

    public void overrideWallets(List<Wallet> wallets) {
        logger.info("Removing old wallets. Adding " + wallets.size() + " wallets.");
        this.wallets = wallets;
    }

    public Wallet getNextWallet() {
        if (this.counter == this.wallets.size()) {
            logger.warning("No wallet left to assign. Reached (" + (this.counter + 1) + "/" + this.wallets.size() + "). Returning null.");
            return null;
        }

        logger.info("Returning wallet at index " + this.counter);

        return this.wallets.get(this.counter++);
    }
}
