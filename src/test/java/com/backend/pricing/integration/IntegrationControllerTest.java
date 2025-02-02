package com.backend.pricing.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDateTime;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationControllerTest {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    @DisplayName("Get price on June 14 at 10:00 a.m.")
    public void getPriceTestOne() {
        this.webTestClient.get()
                .uri(uriBuilder ->
                        uriBuilder.path("/api/prices")
                                .queryParam("brandCode", String.valueOf(1L))
                                .queryParam("productCode", String.valueOf(35455L))
                                .queryParam("dateApplication",
                                        String.valueOf(LocalDateTime.of(2020, 6, 14, 10,
                                                0)))
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.price.amount.price").isEqualTo("35.50")
                .jsonPath("$.product.description").isEqualTo("Jeans");
    }

    @Test
    @DisplayName("Get price on June 14 at 16:00 p.m.")
    public void getPriceTestTwo() {
        this.webTestClient.get()
                .uri(uriBuilder ->
                        uriBuilder.path("/api/prices")
                                .queryParam("brandCode", String.valueOf(1L))
                                .queryParam("productCode", String.valueOf(35455L))
                                .queryParam("dateApplication",
                                        String.valueOf(LocalDateTime.of(2020, 6, 14, 16,
                                                0)))
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.price.amount.price").isEqualTo("25.45")
                .jsonPath("$.product.description").isEqualTo("Jeans");
    }

    @Test
    @DisplayName("Get price on June 14 at 21:00 p.m.")
    public void getPriceTestThree() {
        this.webTestClient.get()
                .uri(uriBuilder ->
                        uriBuilder.path("/api/prices")
                                .queryParam("brandCode", String.valueOf(1L))
                                .queryParam("productCode", String.valueOf(35455L))
                                .queryParam("dateApplication",
                                        String.valueOf(LocalDateTime.of(2020, 6, 14, 21,
                                                0)))
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.price.amount.price").isEqualTo("35.50")
                .jsonPath("$.product.description").isEqualTo("Jeans");
    }

    @Test
    @DisplayName("Get price on June 15 at 10:00 a.m.")
    public void getPriceTestFour() {
        this.webTestClient.get()
                .uri(uriBuilder ->
                        uriBuilder.path("/api/prices")
                                .queryParam("brandCode", String.valueOf(1L))
                                .queryParam("productCode", String.valueOf(35455L))
                                .queryParam("dateApplication",
                                        String.valueOf(LocalDateTime.of(2020, 6, 15, 10,
                                                0)))
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.price.amount.price").isEqualTo("30.50")
                .jsonPath("$.product.description").isEqualTo("Jeans");
    }

    @Test
    @DisplayName("Get price on June 16 at 21:00 p.m.")
    public void getPriceTestFive() {
        this.webTestClient.get()
                .uri(uriBuilder ->
                        uriBuilder.path("/api/prices")
                                .queryParam("brandCode", String.valueOf(1L))
                                .queryParam("productCode", String.valueOf(35455L))
                                .queryParam("dateApplication",
                                        String.valueOf(LocalDateTime.of(2020, 6, 16, 21,
                                                0)))
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.price.amount.price").isEqualTo("38.95")
                .jsonPath("$.product.description").isEqualTo("Jeans");
    }


}