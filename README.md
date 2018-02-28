Mock Identity Provider
======================

This project represents a mock identity provider which
returns pre-allocated private-keys until none are left.

# Configuration

The identity provider is running on port `8090` by default.
If you need to change this setting, head to `src/main/resources/application.properties`
and change the value of `server.port`.

# Routes

## Add new wallets
In order to add new wallets (and remove the old ones), submit their private keys.

**Route**: `POST http://localhost:8090/wallets`

```json
    {
        "wallets": [
            {
                "private-key": "0"
            },
            {
                "private-key": "1"
            },
            {
                "private-key": "2"
            }
        ]
   }
```

## Get a wallet

In order to get a non-assigned wallet's private-key, use the following route:

**Route**: `GET http://localhost:8090/wallets/next`

On _success_, you'll retrieve a response with status code `200`.
Its response body will contain:

```json
    {
      "private-key": "0"
    }
```

On _failure_, you'll retrieve a response with status code `404`.
Its response body will contain

```json
    {
      "timestamp": 1519138261748,
      "status": 404,
      "error": "Not Found",
      "exception": "org.provotum.mockidentityprovider.exception.NoWalletLeftException",
      "message": "No wallet left",
      "path": "/wallets/next"
    }
```