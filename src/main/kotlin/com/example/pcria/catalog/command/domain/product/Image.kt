package com.example.pcria.catalog.command.domain.product

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "image_type")
@Table(name = "image")
abstract class Image(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private val id: Long,

    @Column(name = "image_path")
    private val path: String,

    @Column(name = "upload_time")
    private val uploadTime: LocalDateTime
) {
    constructor(path: String) : this(0, path, LocalDateTime.now())
}