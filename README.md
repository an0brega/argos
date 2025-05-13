# 🧠 Argos – Inventory Management System

**Argos** is a Java-based command-line application designed to manage stock and inventory efficiently. It allows users to add, update, remove, and list products based on their categories. Built with clean architecture and object-oriented principles, it's ideal for educational purposes and future scalability.

---

## 📁 Project Structure


  ```bash
argos/
├── br/com/backsolutions/argos/
│ ├── models/
│ │ ├── Product.java
│ │ ├── Electronic.java
│ │ ├── Food.java
│ │ └── Clothing.java
│ ├── interfaces/
│ │ └── IStoredItem.java
│ ├── service/
│ │ └── ProductService.java
│ │ └── ContextType.java
│ └── ArgosApp.java
```
---

## 🚀 Features

- 📥 Add new products to the stock  
- 🔁 Update existing product quantities (increase/decrease)  
- 📋 List all products currently in stock  
- ❌ Remove products from the stock  
- 🔍 *(Planned)*: Search for products by code

---

## 🛠️ Technologies & Concepts

- **Java SE** – Pure Java application
- **Object-Oriented Programming** – Inheritance, polymorphism, and encapsulation
- **Exception Handling** – Input validation with try-catch blocks
- **Scanner** – For user input via command-line
- **Clean Code** – Well-structured classes and separation of concerns

---

## 📦 Product Models

The abstract class `Product` is the base for all product types:

| Type       | Additional Attribute    |
|------------|--------------------------|
| Electronic | `voltage`                |
| Food       | `cookingPoint`           |
| Clothing   | `size`                   |

All products include: `name`, `code`, `price`, `quantityInStock`, and `totalStock`.

---

## 💡 Sample Interaction

```bash
Please input the product type:
1 - Electronic
2 - Food
3 - Clothing
Option: 1
Name: Laptop
Code: 102
Price: 3500.00
Quantity in stock: 10
Voltage (110/220): 110
```

---

## 👁️‍🗨️ Why “Argos”?
In Greek mythology, Argos Panoptes was a giant with a hundred eyes — a perfect symbol of vigilance. Just like him, this system keeps constant watch over your inventory.

## 🙋‍♂️ Author
Crafted with care and learning in mind by an0brega.

---

## Maybe will be added someday:
- A translated Portuguese version below (bilingual)
- Customization like badges, version numbers, or logos


Happy coding with Argos! 💻🧠
