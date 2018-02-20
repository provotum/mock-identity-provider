package org.provotum.mockidentityprovider.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No wallet left")
public class NoWalletLeftException extends RuntimeException {
}
