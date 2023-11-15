package com.hbbMarket.marketplace.model.dtos;

import com.hbbMarket.marketplace.model.UserRole;

public record RegisterDTO(String email, String password, UserRole role){
}
