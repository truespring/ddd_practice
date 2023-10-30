package com.example.pcria.payment.ui

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@RequestMapping("/api/v1/payments")
annotation class PaymentV1Controller
