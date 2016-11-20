package com.example.starter.service


interface IdentificationService {
    /**
     * @return unique installation identifier, persistent while app is installed
     */
    fun getInstallUuid(): String
}
