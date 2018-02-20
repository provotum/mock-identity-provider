package org.provotum.mockidentityprovider.controller;

import org.provotum.mockidentityprovider.exception.NoWalletLeftException;
import org.provotum.mockidentityprovider.model.Wallet;
import org.provotum.mockidentityprovider.model.WalletRequest;
import org.provotum.mockidentityprovider.service.WalletAssigner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class WalletController {

    private static final String CONTEXT = "/wallets";

    private WalletAssigner walletAssigner;

    @Autowired
    public WalletController(WalletAssigner walletAssigner) {
        this.walletAssigner = walletAssigner;
    }

    @RequestMapping(value = CONTEXT, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addWallets(@RequestBody WalletRequest wallets) {
        this.walletAssigner.addWallets(wallets.getWallets());
    }

    @RequestMapping(value = CONTEXT + "/next", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Wallet getNewWallet() {
        Wallet nextWallet = this.walletAssigner.getNextWallet();

        if (null == nextWallet) {
            throw new NoWalletLeftException();
        }

        return nextWallet;
    }
}
