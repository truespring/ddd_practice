package com.example.pcria.catalog.command.domain.product

import com.example.pcria.catalog.command.domain.category.CategoryId
import com.example.pcria.common.jpa.MoneyConverter
import com.example.pcria.common.model.Money
import jakarta.persistence.*

@Entity
@Table(name = "product")
class Product(
    @EmbeddedId
    private val id: ProductId,

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "product_category", joinColumns = [JoinColumn(name = "product_id")])
    private val categories: Set<CategoryId>,

    private val name: String,

    @Convert(converter = MoneyConverter::class)
    private val price: Money,

    private val detail: String,

    @OneToMany(
        cascade = [CascadeType.PERSIST, CascadeType.REMOVE],
        orphanRemoval = true,
        fetch = FetchType.LAZY
    ) @JoinColumn(name = "product_id") @OrderColumn(name = "list_idx")
    private var images: MutableList<Image> = ArrayList()
) {

    fun id() = this.id
    fun categories() = this.categories
    fun name() = this.name
    fun price() = this.price
    fun detail() = this.detail
}