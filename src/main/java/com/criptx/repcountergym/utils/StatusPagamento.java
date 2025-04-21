package com.criptx.repcountergym.utils;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum StatusPagamento {
    PIX(),
    DEBITO(),
    CREDITO();

}
