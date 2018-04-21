package com.karyawan.karyawan.dto;

import com.karyawan.karyawan.models.Tetap;

public class TetapDTO {
    private String errorMsg;
    private Tetap tetap;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Tetap getTetap() {
        return tetap;
    }

    public void setTetap(Tetap tetap) {
        this.tetap = tetap;
    }
}
