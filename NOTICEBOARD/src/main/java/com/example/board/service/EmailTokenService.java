package com.example.board.service;

import com.example.board.domain.EmailToken;

public interface EmailTokenService {
    String createEmailToken(long memberId, String receiverEmail);
    EmailToken findByIdAndExpirationDateAfterAndExpired(String emailTokenId);
}
