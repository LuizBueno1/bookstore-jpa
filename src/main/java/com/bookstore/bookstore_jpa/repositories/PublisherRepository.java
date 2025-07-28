package com.bookstore.bookstore_jpa.repositories;

import com.bookstore.bookstore_jpa.models.PublisherModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PublisherRepository extends JpaRepository<PublisherModel, UUID> {
}
