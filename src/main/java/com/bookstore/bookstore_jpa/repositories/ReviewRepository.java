package com.bookstore.bookstore_jpa.repositories;

import com.bookstore.bookstore_jpa.models.ReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReviewRepository extends JpaRepository<ReviewModel, UUID> {
}
