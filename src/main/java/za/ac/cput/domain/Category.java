package za.ac.cput.domain;

import java.util.Objects;

/**
 * Category.java
 * This is the Domain Entity for Category
 * Author: Mbasa Mcakumba 241080371
 * Date: 23 March 2026
 */
public class Category {
    private String categoryId;
    private String name;


    private Category(Builder builder) {
        this.categoryId = builder.categoryId;
        this.name = builder.name;
    }


    public String getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(categoryId, category.categoryId) &&
                Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, name);
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId='" + categoryId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }


    public static class Builder {
        private String categoryId;
        private String name;

        public Builder setCategoryId(String categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }


        public Builder copy(Category category) {
            this.categoryId = category.categoryId;
            this.name = category.name;
            return this;
        }


        public Category build() {
            return new Category(this);
        }
    }
}